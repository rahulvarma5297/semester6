const express = require("express");
const csrf = require("csurf");
const multer = require("multer");
const morgan = require("morgan");
const cookieParser = require("cookie-parser");
const fs = require("fs");
const path = require("path");
const app = express();

// Question 1:
app.use(express.static("public"));
app.set("view engine", "ejs");

// Question 5: Application should upload file using multer for profile pic of the user
const storage = multer.diskStorage({
  destination: function (req, file, cb) {
    cb(null, "./public/uploads");
  },
  filename: function (req, file, cb) {
    cb(null, Date.now() + path.extname(file.originalname));
  },
});

const upload = multer({ storage: storage });

const accessLogStream = fs.createWriteStream(
  path.join(__dirname, "access.log"),
  { flags: "a" }
);

// Question 4: Morgan After, every hour application should save log information using Morgan middleware.
app.use(morgan("combined", { stream: accessLogStream }));

const bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({ extended: false }));

app.get("/", (req, res) => {
  res.render("index");
});

// Question 2: form data and same should pass and print in the form post page
// form is in form.ejs and post page is in data.ejs
app.get("/form", (req, res) => {
  res.render("form");
});

app.post("/data", upload.single("image"), (req, res) => {
  const user = {
    name: req.body.name,
    email: req.body.email,
    image: req.file.filename,
  };
  res.render("data", { user });
});

// Question 3: Application should use cookie parser and csrf token for form submission
app.use(cookieParser());
var csrfProtection = csrf({ cookie: true });
var parseForm = bodyParser.urlencoded({ extended: false });

app.get("/form", csrfProtection, function (req, res) {
  res.render("form", { csrfToken: req.csrfToken() });
});

app.post("/process", parseForm, csrfProtection, function (req, res) {
  console.log("Form (from querystring): " + req.body.form);
});

app.listen(3000, () => {
  console.log("Server is running on port 3000");
  console.log("Please go to http://localhost:3000/form to submit the form");
});

// Morgan log rotate
setInterval(() => {
  accessLogStream.end();
  accessLogStream = fs.createWriteStream(path.join(__dirname, "access.log"), {
    flags: "a",
  });
  app.use(morgan("combined", { stream: accessLogStream }));
}, 1000 * 60 * 60);
