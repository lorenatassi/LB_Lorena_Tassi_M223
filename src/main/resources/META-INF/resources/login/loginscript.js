const URL = 'http://localhost:8080';
var token;

function login() {
    const user = {};

    user['username'] = document.getElementById('username').value;
    user['passwort'] = document.getElementById('inputPassword').value;

    fetch(`${URL}/auth/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then((result) => {
        result.text().then((tokenStr) => {
            token = tokenStr;
            if (token !== null) {
                localStorage.setItem("token", tokenStr);

                window.location.replace("http://localhost:8080/form/form.html");
            }
        });
    });
}


function switchSite(){
    window.location.replace("http://localhost:8080/registrieren/register.html");
}
