function isAuthenticated() {
    const cookies = document.cookie;
    const cookieArray = cookies.split("; ");
    
    for (let i = 0; i < cookieArray.length; i++) {
      const cookie = cookieArray[i].split("=");
      if (cookie[0] === "authToken") {
        const token = cookie[1];
        
        // Perform a validation check with the server to verify the token
        // Assuming the server responds with a boolean indicating validity
        const isValidToken = true;
        return isValidToken;
      }
    }
    
    return false; // No valid token found
  }
  