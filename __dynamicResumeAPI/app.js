var ip = '192.168.31.230';
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

function sendEmail(receiverEmail, filename) {
    transporter.sendMail({
        from: 'smtp.byb@gmail.com',
        to: receiverEmail,
        subject: 'Resume',
        text: 'Your Resume is ready !!!',
        attachments: [{
            filename: 'Resume.pdf',
            path:`./server/resumes/${filename}.pdf`,
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

function generateFilename(parsedJSON) {
    var name = parsedJSON.basics.name.replace(' ','');
    var d = new Date();
    var prefix = [
        d.getDate(),
        d.getMonth(),
        d.getFullYear(),
        d.getTime()
    ].join('-');
    return `${prefix}-${name}`;
}

io.on('connection', function (socket) {
    socket.on('generate', function (data) {
		data=JSON.stringify(data);
        console.log('in generate');
		console.log(data);
        //console.log(data.resumeJSON.substring(100));
        var parsedJSON = JSON.parse(data);
        var filename = `${generateFilename(parsedJSON)}`
        var receiverEmail = parsedJSON.basics.email;
        fs.unlink('./server/resumes/resume.json', function (err) {
            fs.writeFile(`./server/resumes/resume.json`, data, {flag: 'w'}, function (err) {
                var command = `cd server/resumes && resume export --theme flat --format pdf ${filename}.pdf`;
                exec(command, function (error, stdout, stderr) {
                    console.log(stdout);
                    var url = `http://${ip}:8000/resumes/${filename}.pdf`
                    socket.emit('generated', url);
                    console.log('parsed email');
                    console.log(receiverEmail);
                    if (receiverEmail)
                        sendEmail(receiverEmail, filename);
                    else
                        console.log('Email not present');
                });
                if (err)
                    return console.error(err);
                });
            if (err)
                return console.error(err);
        });
    });
});



server.listen(3000, function () {
    console.log('listening on localhost:3000');
});