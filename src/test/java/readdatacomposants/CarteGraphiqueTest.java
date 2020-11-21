package readdatacomposants;

import entity.CarteGraphique;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarteGraphiqueTest {
    @Test
    public void testFindOne() {
        assertEquals(1, testFindOneCG());
    }

    @Test
    public void testFetchAll() {
        assertEquals(1, testFetchAllCG());
    }

    private static int testFindOneCG() {
        CarteGraphique maCG = null;
        try {
            maCG = CarteGraphique.findOne(1);
            System.out.println(maCG.toString());
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }

    }

    private static int testFetchAllCG() {
        List<CarteGraphique> mesCG = new ArrayList<>();
        try {
            mesCG = CarteGraphique.fetchAll();
            for (CarteGraphique CG :
                    mesCG) {
                System.out.println(CG.toString());
            }
            return 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }

    }
}
