package fixture;

import java.sql.Connection;
import java.sql.Statement;

import static dbtools.Dbtools.*;

public class Fixtures {
    public static void main(String[] args) {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        /* On vide la base de donnée */
        executeScript(maConnection, "./src/resources/sql/truncateTables.sql");


        /* On remplit la base de donnée */

        // 1. Fabricants
        executeScript(maConnection, "./src/resources/sql/populateFabricants.sql");

        // 2. Processeurs
        executeScript(maConnection, "./src/resources/sql/populateProcesseurs.sql");

        // 3. Memoires (Ram)
        executeScript(maConnection,"./src/resources/sql/populateMemoire.sql");

        // 4. Carte Graphiques
        executeScript(maConnection,"./src/resources/sql/populateCarteGraphique.sql");

        // 5. Carte Meres
        executeScript(maConnection,"./src/resources/sql/populateCarteMeres.sql");

        // 6. Disque Durs
        executeScript(maConnection,"./src/resources/sql/populateDisqueDurs.sql");


        libererConnexion(maConnection, stmt);
    }


}
