let token = ""
function isAuthenticated() {
    const cookies = document.cookie;
    const cookieArray = cookies.split("; ");
    
    for (let i = 0; i < cookieArray.length; i++) {
      const cookie = cookieArray[i].split("=");
      if (cookie[0] === "authToken") {
        token = cookie[1];
        
        // Perform a validation check with the server to verify the token
        // Assuming the server responds with a boolean indicating validity
        const isValidToken = true;
        return isValidToken;
      }
    }
    
    return false; // No valid token found
  }
  
  if(!isAuthenticated()){
    window.location.href = '/login.html'
  }else{
    // Retrieve the JSON string from localStorage
    const jsonData = localStorage.getItem('user');
    
    // Parse the JSON string back to an object
    const data = JSON.parse(jsonData);

    document.getElementById('playerId').textContent = data.username

  }