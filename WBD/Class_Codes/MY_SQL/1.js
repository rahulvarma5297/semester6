var mysql = require("mysql");

const connection = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "1234",
  database: "test",
});

connection.connect(function (err) {
  if (err) throw err;
  console.log("Connected!");
});

var table1 = "CREATE TABLE if not exists student (name varchar(30), roll varchar(30), branch varchar(30))";
var table2 = "Create table if not exists course (name varchar(30), type varchar(30), id varchar(30))";
var table3 = "Create table if not exists course_reg (id int primary key, student_id varchar(30), course_id varchar(30))";

connection.query(table1, function (err, result) {
  if (err) throw err;
  console.log("Table 1 created");
});

connection.query(table2, function (err, result) {
  if (err) throw err;
  console.log("Table 2 created");
});

connection.query(table3, function (err, result) {
  if (err) throw err;
  console.log("Table 3 created");
});

var values1 = [
  ["Rahul", "1", "CSE"],
  ["Rohan", "2", "ECE"],
  ["Raj", "3", "EEE"],
  ["Ravi", "4", "CSE"],
  ["Ramesh", "5", "ECE"],
]

var insert1 = "Insert into student values ?";
connection.query(insert1, [values1], function (err, result) {
  if (err) throw err;
  console.log("Values inserted in table 1");
});

var values2 = [
  ["Maths", "Theory", "1"],
  ["Physics", "Theory", "2"],
  ["Chemistry", "Theory", "3"],
  ["Python", "Lab", "4"],
  ["Java", "Lab", "5"],
]

var insert2 = "Insert into course values ?";
connection.query(insert2, [values2], function (err, result) {
  if (err) throw err;
  console.log("Values inserted in table 2");
});

var values3 = [
  [1, "1", "1"],
  [2, "2", "2"],
  [3, "3", "3"],
  [4, "4", "4"],
  [5, "5", "5"],
]

var insert3 = "Insert into course_reg values ?";
connection.query(insert3, [values3], function (err, result) {
  if (err) throw err;
  console.log("Values inserted in table 3");
});



connection.end();