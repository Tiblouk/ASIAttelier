function register() {
    document.getElementById('register').onclick = function(e) {
        let username = '';
        let password = '';
        let r_password = '';
        let form = document.querySelectorAll('#register-form input');

        form.forEach(input => {
            if (input.name == 'surname') {
                username = input.value;
            }
            if (input.name == 'password') {
                password = input.value
            }
            if (input.name == 're-password') {
                r_password = input.value
            }
        })
        
        // window.location.href = '/'
    }

}

document.getElementById('cancel').onclick = function(e) {
    window.location.href = '/'
}
register()