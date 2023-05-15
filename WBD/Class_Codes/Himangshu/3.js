// How many types of middle ware are there?
// 1. Application level
// 2. Router level
// 3. Error handling
// 4. Built-in
// 5. Third-party

// Error handling --> 4 arguments

var express = require('express');
var app = express();

app.get('/', function(req, res){
    res.send('Hello World!');
});

// app.use(function(err, req, res, next){
//     console.log(err.stack);
//     res.status(500).send('Something broke!');
// })



// Built in Middleware.

// app.use(express.static('public'));

// app.get('/', function(req, res){
//     res.send(path.join(__dirname, 'public', 'index.html'));
// });

// Third Party Middleware

var cookieParser = require('cookie-parser');
app.use(cookieParser());

app.get('/fsd', function(req, res){
    console.log("Cookies: ", req.cookies);
});

app.listen(3000);