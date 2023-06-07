function logout() {
  document.getElementById('logout').onclick = function(e) {
    // Clear the authentication cookie by setting its expiration to a past date
  const expirationDate = new Date(0).toUTCString();
  document.cookie = `authToken=; expires=${expirationDate}; path=/`;

  // Redirect the user to the login or home page
  window.location.href = "/login.html"; // Replace "/login" with the appropriate URL
  }
}

logout();