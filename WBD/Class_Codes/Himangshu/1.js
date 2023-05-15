var express = require("express");
var app = express();

const myLogger1 = function (req, res, next) {
  console.log("LOGGED 1");
  next();
};

const myLogger2 = function (req, res, next) {
  console.log("LOGGED 2");
  next();
};

const myLogger3 = function (req, res, next) {
  console.log("LOGGED 3");
  next();
};

app.get("/", function (req, res) {
  res.send("Welcome to home page");
});

app.use(myLogger1);
app.get("/fsd1", function (req, res) {
  res.send("welcome to fsd1");
});

app.use(myLogger2);
app.get("/fsd2", function (req, res) {
  res.send("welcome to fsd2");
});

app.use(myLogger3);
app.get("/fsd3", function (req, res) {
  res.send("welcome to fsd3");
});

app.listen(3000);

// Problem
// when we call fsd3 all the 3 logger's are called
// when we call fsd2 only 2 logger's are called
// when we call fsd1 only 1 logger's are called

// Solution is in 2.js
