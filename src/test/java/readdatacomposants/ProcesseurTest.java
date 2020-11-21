package readdatacomposants;

import entity.Processeur;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcesseurTest {
    @Test
    public void testFindOne() {
        assertEquals(1, testFindOneProcesseur());
    }

    @Test
    public void testFetchAll() {
        assertEquals(1, testFetchAllProcesseurs());
    }

    private static int testFetchAllProcesseurs() {
        List<Processeur> mesProcesseurs = new ArrayList<>();
        try {
            mesProcesseurs = Processeur.fetchAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
        for (Processeur processeur :
                mesProcesseurs) {
            System.out.println(processeur.toString());
        }
        return 1;
    }

    private static int testFindOneProcesseur() {
        try {
            System.out.println(Processeur.findOne(1).toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }

        return 1;
    }
}
