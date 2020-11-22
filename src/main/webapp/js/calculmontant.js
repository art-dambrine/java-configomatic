function calcMontant() {
    let spanMontant = document.getElementById("montant-total")

    let inputProcesseur = document.getElementById("inputProcesseur")
    let prixProcesseur = 0
    if (inputProcesseur.options[inputProcesseur.value])
        prixProcesseur = inputProcesseur.options[inputProcesseur.value].dataset.price


    let inputCarteMere = document.getElementById("inputCarteMere")
    let prixCarteMere = 0
    if (inputCarteMere.options[inputCarteMere.value])
        prixCarteMere = inputCarteMere.options[inputCarteMere.value].dataset.price


    let inputMemoire = document.getElementById("inputMemoire")
    let prixMemoire = 0
    if (inputMemoire.options[inputMemoire.value])
        prixMemoire = inputMemoire.options[inputMemoire.value].dataset.price


    let inputCarteGraphique = document.getElementById("inputCarteGraphique")
    let prixCarteGraphique = 0
    if (inputCarteGraphique.options[inputCarteGraphique.value])
        prixCarteGraphique = inputCarteGraphique.options[inputCarteGraphique.value].dataset.price


    let inputDisqueDur = document.getElementById("inputDisqueDur")
    let prixDisqueDur = 0
    if (inputDisqueDur.options[inputDisqueDur.value])
        prixDisqueDur = inputDisqueDur.options[inputDisqueDur.value].dataset.price


    let montantTotal = parseFloat(prixProcesseur) + parseFloat(prixCarteMere) + parseFloat(prixMemoire) + parseFloat(prixCarteGraphique) + parseFloat(prixDisqueDur)

    // Affichage du resultat
    spanMontant.innerText = montantTotal

}

calcMontant();

