var MongoClient = require("mongodb").MongoClient;
var url =
  "mongodb+srv://rahulvarma5297:rahulvarma@cluster0.sgtf0nt.mongodb.net/fsd?retryWrites=true&w=majority";

MongoClient.connect(url, function (err, db) {
  if (err) throw err;
  var dbo = db.db("fsd");

// Commented this out because it was creating a new collection every time I ran the script
// and every time the values are getting inserted into the collection

// Table Creation and Insertion
  //   dbo.createCollection("student", function (err, res) {
  //     if (err) throw err;
  //     console.log("Collection Student created !!!");
  //     db.close();
  //   });

  //   var student_value = [
  //     { name: "Arun", address: "Bangalore", rollno: "22101", branch: "CSE" },
  //     { name: "Anand", address: "Chennai", rollno: "22102", branch: "CSE" },
  //     { name: "Arvnind", address: "Tirupati", rollno: "22201", branch: "ECE" },
  //     { name: "Harish", address: "Mumbai", rollno: "22202", branch: "ECE" },
  //     { name: "Michael", address: "Delhi", rollno: "22103", branch: "CSE" },
  //     { name: "Santosh", address: "Delhi", rollno: "22104", branch: "CSE" },
  //     { name: "Betty", address: "Vizag", rollno: "22203", branch: "ECE" },
  //     { name: "Rishabh", address: "Kurnool", rollno: "22105", branch: "CSE" },
  //     { name: "Sumanth", address: "Nellore", rollno: "22106", branch: "CSE" },
  //     { name: "Vikas", address: "Surat", rollno: "22107", branch: "CSE" },
  //     { name: "Balaji", address: "Jaipur", rollno: "22204", branch: "ECE" },
  //     { name: "William", address: "Ajmer", rollno: "22205", branch: "ECE" },
  //     { name: "Chuck", address: "Mandi", rollno: "22206", branch: "ECE" },
  //     { name: "Vishnu", address: "Kolkata", rollno: "22207", branch: "ECE" },
  //   ];

  //   dbo.collection("student").insertMany(student_value, function (err, res) {
  //     if (err) throw err;
  //     console.log("Number of documents inserted: " + res.insertedCount);
  //     db.close();
  //   });

  //   // Course Values:
  //   dbo.createCollection("course", function (err, res) {
  //     if (err) throw err;
  //     console.log("Collection Course created !!!");
  //     db.close();
  //   });

  //   var course_value = [
  //     { name: "DL", type: "SE", code: "631" },
  //     { name: "ML", type: "PE", code: "511" },
  //     { name: "ADSA", type: "PC", code: "311" },
  //     { name: "CP", type: "PC", code: "111" },
  //     { name: "OCW", type: "PE", code: "221" },
  //     { name: "DBMS", type: "PC", code: "312" },
  //     { name: "EMTL", type: "PE", code: "521" },
  //     { name: "ADA", type: "SE", code: "641" },
  //     { name: "DIP", type: "IE", code: "551" },
  //     { name: "DM", type: "PE", code: "512" },
  //   ];

  //   dbo.collection("course").insertMany(course_value, function (err, res) {
  //     if (err) throw err;
  //     console.log("Number of documents inserted: " + res.insertedCount);
  //     db.close();
  //   });

  //   dbo.createCollection("course_registration", function (err, res) {
  //     if (err) throw err;
  //     console.log("Collection course_registration created !!!");
  //     db.close();
  //   });

  //   var course_registration_value = [
  //     { rollno: "22107", code: "631" },
  //     { rollno: "22201", code: "551" },
  //     { rollno: "22102", code: "312" },
  //     { rollno: "22103", code: "312" },
  //     { rollno: "22104", code: "311" },
  //     { rollno: "22202", code: "111" },
  //     { rollno: "22201", code: "111" },
  //     { rollno: "22103", code: "631" },
  //     { rollno: "22104", code: "631" },
  //     { rollno: "22105", code: "631" },
  //   ];

  //   dbo.collection("course_registration").insertMany(course_registration_value, function (err, res) {
  //     if (err) throw err;
  //     console.log("Number of documents inserted: " + res.insertedCount);
  //     db.close();
  //   });


// If you want to run the each question 4, 5, 6 then please comment other questions and run the code.
// since the code is written in the same file.


  // Question 4:
  // Write an appropriate query for retrieving relevant information using course_registration collection’s course_id and student_id fields and
  // display it in the following format.
    dbo
      .collection("course_registration")
      .aggregate([
        {
          $lookup: {
            from: "student",
            localField: "rollno",
            foreignField: "rollno",
            as: "student_info",
          },
        },
        {
          $lookup: {
            from: "course",
            localField: "code",
            foreignField: "code",
            as: "course_info",
          },
        },
        {
          $project: {
            _id: 0,
            "Registration ID": "$_id",
            "Name of the student": "$student_info.name",
            "Student Roll NO": "$student_info.rollno",
            Branch: "$student_info.branch",
            Address: "$student_info.address",
            "Course Name": "$course_info.name",
            "Course type": "$course_info.type",
            "Course ID": "$course_info.code",
          },
        },
      ])
      .toArray(function (err, res) {
        if (err) throw err;
        console.log("<--------------------------------Question 4--------------------------------->");
        console.log(res);
        console.log("<--------------------------------------------------------------------------->");
        // db.close();
      });

  // Question 5:
  // Write an appropriate query for retrieving relevant information using course_registration collection’s course_id and student_id fields and
  // display only the CSE students data in the following format.
  dbo
    .collection("course_registration")
    .aggregate([
      {
        $lookup: {
          from: "student",
          localField: "rollno",
          foreignField: "rollno",
          as: "student_info",
        },
      },
      {
        $lookup: {
          from: "course",
          localField: "code",
          foreignField: "code",
          as: "course_info",
        },
      },
      {
        $project: {
          _id: 0,
          "Registration ID": "$_id",
          "Name of the student": "$student_info.name",
          "Student Roll NO": "$student_info.rollno",
          Branch: "$student_info.branch",
          Address: "$student_info.address",
          "Course Name": "$course_info.name",
          "Course type": "$course_info.type",
          "Course ID": "$course_info.code",
        },
      },
      {
        $match: {
          Branch: "CSE",
        },
      },
    ])
    .toArray(function (err, res) {
      if (err) throw err;
      console.log("<--------------------------------Question 5--------------------------------->");
      console.log(res);
      console.log("<--------------------------------------------------------------------------->");
    //   db.close();
    });

// Group the results of the students retrieved in the previous Question 5 for each course 
// and display the count for no of registrations per course like below.
  dbo
    .collection("course_registration")
    .aggregate([
        {
            $lookup: {
                from: "student",
                localField: "rollno",
                foreignField: "rollno",
                as: "student_info",
            },
        },
        {
            $lookup: {
                from: "course",
                localField: "code",
                foreignField: "code",
                as: "course_info",
            },
        },
        {
            $project: {
                _id: 0,
                "Registration ID": "$_id",
                "Name of the student": "$student_info.name",
                "Student Roll NO": "$student_info.rollno",
                Branch: "$student_info.branch",
                Address: "$student_info.address",
                "Course Name": "$course_info.name",
                "Course type": "$course_info.type",
                "Course ID": "$course_info.code",
            },
        },
        {
            $match: {
                Branch: "CSE",
            },
        },
        {
            $group: {
                _id: "$Course Name",
                count: { $sum: 1 },
            },
        },
    ])
    .toArray(function (err, res) {
        if (err) throw err;
        console.log("<--------------------------------Question 6--------------------------------->");
        console.log(res);
        console.log("<--------------------------------------------------------------------------->");
        db.close();
    });

    // If there is an error occured then comment other part and run only one part of the question 
    // with including db.close() at each part of the code.
});
