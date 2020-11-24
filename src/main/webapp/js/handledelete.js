let handleDeleteOrdinateur = function (id, provenanceFiche) {

    // Validation avant suppression
    let confirm = window.confirm('Voulez vous vraiment cette config ?')
    if (!confirm) return

    let requestOptions = {
        method: 'POST',
        redirect: 'follow'
    };

    let path = "./deleteordinateur/"
    if (provenanceFiche) path = "../deleteordinateur/"

    fetch(path + id, requestOptions)
        .then(response => {
            if (response.status == 202) {
                if (provenanceFiche) window.location = "../ordinateurs"
                else document.location.reload()
                return response.status
            } else {
                console.log("Erreur : " + response.status)
            }
            return response.text()
        })
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}