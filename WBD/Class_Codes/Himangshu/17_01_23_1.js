// Morgan is a middleware that logs all the requests to the console.

var express = require('express');
var app = express();
var path = require('path');
var morgan = require('morgan');
var rfs = require('rotating-file-stream');

// create a rotating write stream
var accessLogStream = rfs.createStream('access.log', {
    interval: '1h', // rotate daily
    path: path.join(__dirname, 'log')
});

app.use(morgan('tiny', { stream: accessLogStream }));

app.get('/', function(req, res) {
    res.send("working");
});

app.listen(3000, function() {
    console.log('Server is running on port 3000');
});