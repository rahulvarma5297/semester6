var express = require("express");
var app = express();
var fs = require("fs");

app.get("/getUsers", (req, res) => {
  fs.readFile(__dirname + "/" + "users.json", "utf8", (err, data) => {
    // add another user in the data
    var users = JSON.parse(data);
    var user = {
      user4: {
        name: "mohit",
        password: "password4",
        profession: "teacher",
        id: 4,
      },
    };
    users["user4"] = user["user4"];
    // console.log(users);
    res.end(JSON.stringify(users));
    // res.end(users);
  });
  const jsonString = JSON.stringify(users);
  fs.writeFile(__dirname + "/" + "users.json", jsonString, (err) => {
    if (err) {
      console.log("Error writing file", err);
    } else {
      console.log("Successfully wrote file");
    }
  });
});

var server = app.listen(8080, () => {
  var host = server.address().address;
  var port = server.address().port;
  console.log("REST API listening at http://%s:%s", host, port);
});
