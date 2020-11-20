import entity.Processeur;

import java.sql.SQLException;

public class ProcesseurTest {
    public static void main(String[] args) {
    Processeur processeur = new Processeur();
        try {
            System.out.println(processeur.findOne(1).toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
