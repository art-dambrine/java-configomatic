import entity.Processeur;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcesseurTest {
    public static void main(String[] args) {

        testFindOneProcesseur();

        testFetchAllProcesseurs();

    }

    private static void testFetchAllProcesseurs() {
        List<Processeur> mesProcesseurs = new ArrayList<>();
        try {
            mesProcesseurs = Processeur.fecthAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (Processeur processeur :
                mesProcesseurs) {
            System.out.println(processeur.toString());
        }
    }

    private static void testFindOneProcesseur() {
        try {
            System.out.println(Processeur.findOne(1).toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
