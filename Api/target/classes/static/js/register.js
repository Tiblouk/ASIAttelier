function register() {
  document.getElementById("register").onclick = function (e) {
    let username = "";
    let password = "";
    let r_password = "";
    let form = document.querySelectorAll("#register-form input");

    form.forEach((input) => {
      if (input.name == "surname") {
        username = input.value;
      }
      if (input.name == "password") {
        password = input.value;
      }
      if (input.name == "re-password") {
        r_password = input.value;
      }
    });

    if (username != "" && password != "" && password == r_password) {
      let formData = new FormData(); // Create a new FormData object from the form
      formData.append("user", username);
      formData.append("pass", password);

      fetch("/account", {
        method: "POST",
        body: formData
      })
        .then((response) => response.json())
        .then((data) => {
          // Process the response data
          console.log(data);
      // window.location.href = '/'
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    }
    else{
        alert("formulaire invalide")
    }
  };
}

document.getElementById("cancel").onclick = function (e) {
  window.location.href = "/";
};
register();
