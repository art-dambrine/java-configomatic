SELECT
    ordinateur.id as 'ordinateur_id',

    -- processeur
    p.id as 'processeur_id',
    p.nom as 'processeur_nom',
    p.prix as 'processeur_prix',
    p.nombre_coeurs as 'processeur_nombre_coeurs',
    p.fabricant as 'processeur_fabricant_id',
    (SELECT fabricant.nom from fabricant WHERE fabricant.id = p.fabricant) as 'processeur_fabricant_nom',

    -- carte_mere
    cm.id as 'carte_mere_id',
    cm.nom as 'carte_mere_nom',
    cm.prix as 'carte_mere_prix',
    cm.compatibilite_usbc as 'carte_mere_compatibilite_usbc',
    cm.port_pci_express as 'carte_mere_port_pci_express',
    cm.fabricant as 'carte_mere_fabricant_id',
    (SELECT fabricant.nom from fabricant WHERE fabricant.id = cm.fabricant) as 'carte_mere_fabricant_nom',

    -- memoire
    m.id as 'memoire_id',
    m.nom as 'memoire_nom',
    m.prix as 'memoire_prix',
    m.capacite_go as 'memoire_capacite_go',
    m.type as 'memoire_type',
    m.fabricant as 'memoire_fabricant_id',
    (SELECT fabricant.nom from fabricant WHERE fabricant.id = m.fabricant) as 'memoire_fabricant_nom',

    -- carte_graphique
    cg.id as 'carte_graphique_id',
    cg.nom as 'carte_graphique_nom',
    cg.prix as 'carte_graphique_prix',
    cg.memoire_graphique_go as 'carte_graphique_memoire_graphique_go',
    cg.puissance_tflops as 'carte_graphique_puissance_tflops',
    cg.fabricant as 'carte_graphique_fabricant_id',
    (SELECT fabricant.nom from fabricant WHERE fabricant.id = cg.fabricant) as 'carte_graphique_fabricant_nom',

    -- disque_dur
    dd.id as 'disque_dur_id',
    dd.nom as 'disque_dur_nom',
    dd.prix as 'disque_dur_prix',
    dd.capacite_go as 'disque_dur_capacite_go',
    dd.fabricant as 'disque_dur_fabricant_id',
    (SELECT fabricant.nom from fabricant WHERE fabricant.id = dd.fabricant) as 'disque_dur_fabricant_nom',

    ordinateur.prix as 'ordinateur_prix',
    ordinateur.vendu as 'ordinateur_vendu',
    ordinateur.datetime_creation as 'ordinateur_datetime_creation',
    ordinateur.datetime_vendu as 'ordinateur_datetime_vendu'

FROM ordinateur,
     processeur p,
     carte_mere cm,
     memoire m,
     carte_graphique cg,
     disque_dur dd
WHERE ordinateur.processeur = p.id
  AND ordinateur.carte_mere = cm.id
  AND ordinateur.memoire = m.id
  AND ordinateur.carte_graphique = cg.id
  AND ordinateur.disque_dur = dd.id;