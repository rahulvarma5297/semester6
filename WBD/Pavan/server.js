const app = require("express")();

const PORT = 8081;

app.listen(PORT, () => {
  console.log(`Server listening on port ${PORT}`);
});

app.get("/getdetails", (req, res) => {
  res.status(200).send({
    name: "John Doe",
    number: "1234",
  });
});
