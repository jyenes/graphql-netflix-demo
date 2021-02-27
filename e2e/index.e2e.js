const newman = require("newman"); // require newman in your project
const collection = require("./heroku-netflix-grapql-demo.postman_collection.json");

newman.run(
  {
    collection,
    reporters: "cli",
    insecure: true
  },
  (err) => {
    if (err) {
      throw err;
    }
    console.log("collection run complete!");
  }
);
