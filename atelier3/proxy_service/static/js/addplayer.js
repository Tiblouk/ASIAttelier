function addplayer() {
  document.getElementById("addplayer").onclick = function (e) {
    let playername = "";
    let form = document.querySelectorAll("#login-form input");

    form.forEach((input) => {
      if (input.name == "player") {
        playername = input.value;
      }
    });

    
    if (playername != "") {
        
        const data = {
            name: playername,
          };
    
      fetch("/players/add", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
          },
        body: JSON.stringify(data),
      })
        .then((response) => {
        //   if (response.status !== 200) {
        //     alert("Mauvais identifiant");
        //     throw new Error("Request failed with status " + response.status);
        //   }
          return response.text();
        })
        .then((data) => {
          console.log(data);
          window.location.href = '/'

        })
        .catch((error) => {
          console.error("Error:", error);
        });
    } else {
      alert("formulaire invalide");
    }
  };

  // Redirect the user to the authenticated area or perform any other desired action
}

function update_account(userinfo) {

    fetch("/accounts/update", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
          },
        body: JSON.stringify(userinfo),
      })
        .then((response) => {
        //   if (response.status !== 200) {
        //     alert("Mauvais identifiant");
        //     throw new Error("Request failed with status " + response.status);
        //   }
          return response.text();
        })
        .then((data) => {
          console.log(data);
          window.location.href = '/'

        })
        .catch((error) => {
          console.error("Error:", error);
        });
}

document.getElementById("cancel").onclick = function (e) {
  window.location.href = "/";
};


addplayer();
