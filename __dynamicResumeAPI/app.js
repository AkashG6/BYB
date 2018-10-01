var http = require('http');

var finalhandler = require('finalhandler');
var serveStatic = require('serve-static');

var serve = serveStatic("./public");

var server = http.createServer(function (req, res) {
    var done = finalhandler(req, res);
    serve(req, res, done);
});

const io = require('socket.io').listen(server);
var fs = require('fs');

var exec = require('child_process').exec;

var nodemailer = require('nodemailer');

var transporter = nodemailer.createTransport({
    service: 'Gmail',
    auth: {
        user: 'smtp.byb@gmail.com',
        pass: 'mail@smtp.byb'
    }
});

function sendEmail(receiverEmail) {
    transporter.sendMail({
        from: 'smtp.byb@gmail.com',
        to: receiverEmail,
        subject: 'Resume',
        text: 'Your Resume is ready !!!',
        attachments: [{
            filename: 'Resume.pdf',
            path: './server/resume.pdf',
            contentType: 'application/pdf'
        }],
        function (err, success) {
            if (err) {
                // Handle error
                console.log(err);
            }
            else {
                console.log(success);
            }
        }
    });
}

io.on('connection', function (socket) {
    socket.on('generate', function (data) {
        console.log('in generate');
        console.log(data.resumeJSON.substring(100));
        fs.writeFile('./server/resume.json', data.resumeJSON, {flag: 'w'}, function (err) {
            exec('cd server && resume export --theme flat --format pdf resume.pdf', function (error, stdout, stderr) {
                console.log(stdout);
                var url = "http://localhost:8000/resume.pdf"
                socket.emit('generated', url);
                let receiverEmail = JSON.parse(data.resumeJSON).basics.email;
                console.log('parsed email');
                console.log(receiverEmail);
                sendEmail(receiverEmail);
            });
            if (err)
                return console.error(err);
        })
    });
});



server.listen(3000, function () {
    console.log('listening on localhost:3000');
});