function login(username, password) {
    // document.getElementById('login').onclick = function(e) {
    //     let username = document.getElementById('username')
    //     let password = document.getElementById('password')
    //     login();
    //     window.location.href = '/'
    // }
    // Perform login request to server
    // Assuming the response contains a token
    const token = "your-authentication-token";
    
    // Set the token in a cookie with an expiration time
    document.cookie = `authToken=${token}; expires=Thu, 1 Jan 2024 12:00:00 UTC; path=/`;
  
    // Redirect the user to the authenticated area or perform any other desired action
}

document.getElementById('cancel').onclick = function(e) {
    window.location.href = '/'
}