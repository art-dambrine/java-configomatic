import java.sql.*;

import static dbtools.Dbtools.*;

public class TestConnexionBase {


    public static void main(String[] args) throws SQLException {

        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);
        libererConnexion(maConnection, stmt);

    }

}
