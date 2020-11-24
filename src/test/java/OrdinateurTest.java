import entity.Ordinateur;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdinateurTest {
    @Test
    public void testAllOrdinateur() {
        assertEquals(1, testFetchAllOrdinateur());
    }

    @Test
    public void testOneOrdinateur() {
        assertEquals(1, testFindOneOrdinateur());
    }

    private int testFindOneOrdinateur() {
        Ordinateur monOrdinateur;
        try {
            monOrdinateur = Ordinateur.findOne(1);
            System.out.println(monOrdinateur.toString());
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    private int testFetchAllOrdinateur() {
        List<Ordinateur> mesOrdinateurs;
        try {
            mesOrdinateurs = Ordinateur.fetchAll();
            for (Ordinateur ordi :
                    mesOrdinateurs) {
                System.out.println(ordi.toString());
            }
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }
}
