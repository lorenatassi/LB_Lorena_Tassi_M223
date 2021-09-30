const URL = 'http://localhost:8080';
let users = [];

function createUser() {
    const user = {};
    user['username'] = document.getElementById('username').value;
    user['passwort'] = document.getElementById('passwort').value;


    fetch(`${URL}/users`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then((result) => {
        result.json().then((user) => {
            users.push(user);
        });
    });
}
