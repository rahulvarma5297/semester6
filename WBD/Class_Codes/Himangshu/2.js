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

app.get("/fsd1", myLogger1, function (req, res) {
  res.send("welcome to fsd1");
});

app.get("/fsd2", myLogger2, function (req, res) {
  res.send("welcome to fsd2");
});

app.get("/fsd3", myLogger3, function (req, res) {
  res.send("welcome to fsd3");
});

app.listen(3000);