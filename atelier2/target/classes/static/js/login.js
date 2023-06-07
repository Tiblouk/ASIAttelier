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
            .then((response) => {
              if (response.status !== 200) {
                alert('Mauvais identifiant')
                throw new Error('Request failed with status ' + response.status);
              }
              return response.json();
            })
            .then((data) => {
                console.log(data)
              // Process the response data
              if(data){
                // Calculate the new expiration date
                const currentDate = new Date();
                const expirationDate = new Date(currentDate.getFullYear() + 1, currentDate.getMonth(), currentDate.getDate());

                // Format the expiration date string
                const expires = expirationDate.toUTCString();

                // Set the new expiration date in the cookie
                document.cookie = `authToken=${username}; expires=${expires}; path=/`;
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

login();