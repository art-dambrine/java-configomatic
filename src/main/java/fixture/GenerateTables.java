package fixture;

import java.sql.Connection;
import java.sql.Statement;

import static dbtools.Dbtools.*;

public class GenerateTables {

    public static void main(String[] args) {

        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        /* On cree les tables de notre base de donnée */
        executeScript(maConnection, "./src/resources/sql/generateTables.sql");

        libererConnexion(maConnection, stmt);
    }
}
