var mysql = require("mysql");

const connection = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "1234",
  database: "fsd",
});

connection.connect(function (err) {
  if (err) throw err;
  console.log("Connected!");
});

var table1 = "CREATE TABLE if not exists student (name varchar(30), roll varchar(30) primary key, branch varchar(30))";
var table2 = "Create table if not exists course (name varchar(30), type varchar(30), id varchar(30) primary key)";
var table3 = "Create table if not exists course_reg (id int primary key, student_id varchar(30), course_id varchar(30), foreign key (student_id) references student(roll), foreign key (course_id) references course(id))";

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

// var insert1 = "Insert into student values ?";
// connection.query(insert1, [values1], function (err, result) {
//   if (err) throw err;
//   console.log("Values inserted in table 1");
// });

var values2 = [
  ["Maths", "Theory", "1"],
  ["Physics", "Theory", "2"],
  ["Chemistry", "Theory", "3"],
  ["Python", "Lab", "4"],
  ["Java", "Lab", "5"],
]

// var insert2 = "Insert into course values ?";
// connection.query(insert2, [values2], function (err, result) {
//   if (err) throw err;
//   console.log("Values inserted in table 2");
// });

var values3 = [
  [1, "1", "1"],
  [2, "1", "2"],
  [3, "1", "3"],
  [4, "2", "1"],
  [5, "2", "2"],
  [6, "2", "3"],
] 

// var insert3 = "Insert into course_reg values ?";
// connection.query(insert3, [values3], function (err, result) {
//   if (err) throw err;
//   console.log("Values inserted in table 3");
// });


// Inner join
var inner = "Select * from student inner join course_reg on student.roll = course_reg.student_id inner join course on course_reg.course_id = course.id";
connection.query(inner, function (err, result) {
  if (err) throw err;
  console.log("Inner join");
  console.log(result);
});

// Left join
var left = "Select * from student left join course_reg on student.roll = course_reg.student_id left join course on course_reg.course_id = course.id";
connection.query(left, function (err, result) {
  if (err) throw err;
  console.log("Left join");
  console.log(result);
});

// Right join
var right = "Select * from student right join course_reg on student.roll = course_reg.student_id right join course on course_reg.course_id = course.id";
connection.query(right, function (err, result) {
  if (err) throw err;
  console.log("Right join");
  console.log(result);
});

// View
// var view = "Create view CSE_STUDENT as select * from student where branch = 'CSE'";
// connection.query(view, function (err, result) {
//   if (err) throw err;
//   console.log("View created");
// });

var view_data = "Select * from CSE_STUDENT";
connection.query(view_data, function (err, result) {
  if (err) throw err;
  console.log("View data");
  console.log(result);
});


connection.end();