package fixture;

import java.sql.*;

import static dbtools.Dbtools.*;

public class TestConnexionBase {


    public static void main(String[] args) throws SQLException {

        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        requeteEcritureBase(stmt, "INSERT INTO processeur (nom,fabriquant) VALUES('core i5',1)");

        ResultSet rs = requeteLectureBase(stmt, "SELECT * FROM processeur");

        affichageResultatConsole(rs);

        libererConnexion(maConnection, stmt);


    }

}
