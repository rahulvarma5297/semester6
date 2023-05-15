// Connecting MongoDB

var MongoClient = require("mongodb").MongoClient;
var url =
  "mongodb+srv://rahulvarma5297:rahulvarma@cluster0.sgtf0nt.mongodb.net/fsd?retryWrites=true&w=majority";

MongoClient.connect(url, function (err, db) {
  if (err) throw err;
  var dbo = db.db("fsd");

  //   dbo.createCollection("student", function (err, res) {
  //     if (err) throw err;
  //     console.log("Collection created!");
  //     db.close();
  //   });

  //   var values = [
  //     { name: "Rahul", roll: "1", branch: "CSE", address: "Bangalore" },
  //     { name: "Rohan", roll: "2", branch: "ECE", address: "Mysore" },
  //     { name: "Raj", roll: "3", branch: "ECE", address: "Chennai" },
  //     { name: "Ravi", roll: "4", branch: "CSE", address: "Hyderabad" },
  //     { name: "Ramesh", roll: "5", branch: "ECE", address: "Delhi" },
  //     { name: "Sai", roll: "6", branch: "ECE", address: "Mumbai" },
  //     { name: "Suresh", roll: "7", branch: "CSE", address: "Kolkata" },
  //     { name: "Sandeep", roll: "8", branch: "ECE", address: "Bangalore" },
  //     { name: "Srinivas", roll: "9", branch: "CSE", address: "Mysore" },
  //     { name: "Sudhakar", roll: "10", branch: "CSE", address: "Chennai" },
  //   ];

  //   dbo.collection("student").insertMany(values, function (err, res) {
  //     if (err) throw err;
  //     console.log("Number of documents inserted: " + res.insertedCount);
  //     db.close();
  //   });

  //   var query = { name: "Rahul" };
  //   dbo.collection("student").deleteOne(query, function (err, obj) {
  //     if (err) throw err;
  //     console.log("1 document deleted");
  //     db.close();
  //   });

  // Start with B
  //   var query = { address: /^B/ };
  //   dbo.collection("student").deleteMany(query, function (err, obj) {
  //     if (err) throw err;
  //     console.log(obj.deletedCount + " document(s) deleted");
  //     db.close();
  //   });

  //   var query = { branch: "ECE" };
  //   dbo
  //     .collection("student")
  //     .find(query)
  //     .toArray(function (err, result) {
  //       if (err) throw err;
  //       console.log(result);
  //       db.close();
  //     });

    // var query = { branch: { $regex: /.*/ } };
    // dbo
    //   .collection("student")
    //   .find(query)
    //   .toArray(function (err, result) {
    //     if (err) throw err;
    //     console.log(result);
    //     db.close();
    //   });

//   dbo
//     .collection("student")
//     .aggregate([{ $match: { branch: "CSE" } }, { $group: { _id: "$address" } }])
//     .toArray(function (err, result) {
//       if (err) throw err;
//       console.log(result);
//       db.close();
//     });


});

// Regex
// var query = {branch : {$regex : /ECE/}, $options : 'i'};
// Not operator
// var query = {branch : {$not : /^ECE/}};
// var query = {branch : {$regex: '/C*/'}};
