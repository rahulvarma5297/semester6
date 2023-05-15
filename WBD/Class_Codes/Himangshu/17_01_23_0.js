// Multer is used to file upload (should be present in every one project)

var express = require('express');
var path = require('path');
var multer = require('multer');
var helmet = require('helmet');

var app = express();
app.use(helmet());

const filestorageEngine = multer.diskStorage({
    destination: (req, file, cb) => {
        cb(null, './images')
    },
    filename: (req, file, cb) => {
        cb(null, file.fieldname + '-' + Date.now())
    }
});

const upload = multer({ storage: filestorageEngine });

app.get('/', function(req, res) {
    res.sendFile(path.join(__dirname + '/public/index.html'));
});

// app.post('/single', upload.single('image'), (req, res) => {
//     res.send('uploaded');
// });

app.post('/single', upload.array('image', 3), (req, res) => {
    res.send('uploaded');
});

app.listen(3000, function() {
    console.log('Server is running on port 3000');
});