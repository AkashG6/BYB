var http = require('http');

var finalhandler = require('finalhandler');
var serveStatic = require('serve-static');

var serve = serveStatic("./");

var server = http.createServer(function (req, res) {
    var done = finalhandler(req, res);
    serve(req, res, done);
});

const io = require('socket.io').listen(server);

server.listen(8000, function () {
    console.log('listening on localhost:8000');
});