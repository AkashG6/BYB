const express = require('express');
const app = express();
const server = require('http').Server(app);
const io = require('socket.io').listen(server);
var fs = require('fs');

var exec = require('child_process').exec;

app.use(express.static(__dirname + '/public'));

// app.get('/', function (req, res) {
//     res.sendFile('index.html');
// });


io.on('connection', function (socket) {
    socket.on('generate', function (data) {
        console.log('in generate');
        fs.writeFile('./resume.json', data.resumeJSON, {
            flag: 'w'
        }, function (err) {
            exec('resume export --theme flat --format pdf resume.pdf', function (error, stdout, stderr) {
                console.log(stdout);
                var url = "http://localhost:3000/resume.pdf"
                socket.emit('generated', url)
            });
            if (err)
                return console.error(err);
        })
    });
});



app.listen(3000, function () {
    console.log('listening on localhost:3000');
});