var socket = io.connect('localhost:3000');
// var socket = io();

function generate() {
    console.log('clicked');
    var data = document.getElementById("rJSON").value;
    console.log(data);
    socket.emit('generate',{
        resumeJSON : data
    });
}

socket.on('generated', function(url){
    console.log(url);
    window.open(url);
});

