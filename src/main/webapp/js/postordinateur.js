let postOrdinateur = async function (json) {

    let feedback = document.getElementById("invalid-feedback")
    feedback.innerText = "";

    let myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    let requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: json,
        redirect: 'follow'
    };

    fetch("./postordinateur", requestOptions)
        .then(response => {
            if(response.status==201){
                window.location = "./ordinateurs"
            } else {
                // TODO : Afficher l'erreur à côté du buttonSubmit
                console.log("Erreur : " + response.status)
                return response.text()
            }
        })
        .then(result => {
            console.log(JSON.parse(result))
            feedback.innerText = JSON.parse(result).message;
        })
        .catch(error => {
            console.log('error', error)
            feedback.innerText = "Veuillez remplir tous les champs.";
        });
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