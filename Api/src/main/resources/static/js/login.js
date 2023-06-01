function login(username, password) {
    document.getElementById("connect").onclick = function (e) {
        let username = "";
        let password = "";
        let form = document.querySelectorAll("#login-form input");
    
        form.forEach((input) => {
          if (input.name == "surname") {
            username = input.value;
          }
          if (input.name == "password") {
            password = input.value;
          }
        });
    
        if (username != "" && password != "") {
          let formData = new FormData(); // Create a new FormData object from the form
          formData.append("user", username);
          formData.append("pass", password);
    
          fetch("/accounts/login", {
            method: "POST",
            body: formData
          })
            .then((response) => response.json())
            .then((data) => {
                console.log(data)
              // Process the response data
              if(data){
                document.cookie = `authToken=${username}; expires=Thu, 1 Jan 2024 12:00:00 UTC; path=/`;
                window.location.href = '/'
              }else{
                alert('Mauvais identifiant')
              }
          
            })
            .catch((error) => {
              console.error("Error:", error);
            });
        }
        else{
            alert("formulaire invalide")
        }
      };
  
    // Redirect the user to the authenticated area or perform any other desired action
}

document.getElementById('cancel').onclick = function(e) {
    window.location.href = '/'
}

login()