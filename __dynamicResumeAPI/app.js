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

io.on('connection', function (socket) {
    socket.on('generate', function (data) {
        console.log('in generate');
        console.log(data);
        fs.writeFile('./server/resume.json', data.resumeJSON, {
            flag: 'w'
        }, function (err) {
            exec('cd server && resume export --theme flat --format pdf resume.pdf', function (error, stdout, stderr) {
                console.log(stdout);
                var url = "http://localhost:8000/resume.pdf"
                socket.emit('generated', url)
            });
            if (err)
                return console.error(err);
        })
    });
});



server.listen(3000, function () {
    console.log('listening on localhost:3000');
});