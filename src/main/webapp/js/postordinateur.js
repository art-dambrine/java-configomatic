let postOrdinateur = async function (json) {

    let myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    let requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: json,
        redirect: 'follow'
    };

    fetch("./postordinateur", requestOptions)
        .then(response => response.json())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}

let buttonSubmit = document.getElementById("button-submit")
buttonSubmit.addEventListener('click', (e) => {
    e.preventDefault()

    let myForm = document.getElementById('myForm');
    let formData = new FormData(myForm)

    let object = {};
    formData.forEach((value, key) => {
        object[key] = value
    });
    postOrdinateur(JSON.stringify(object))

})