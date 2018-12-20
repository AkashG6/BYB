var ip = '192.168.31.230';
var socket = io.connect(`${ip}:3000`);
// var socket = io();

function generate() {
    console.log('clicked');
    var data = document.getElementById("rJSON").value;
    console.log(data);
    socket.emit('generate',data);
}

socket.on('generated', function(url){
    console.log(url);
    window.open(url);
});
