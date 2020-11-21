package readdatacomposants;

import entity.CarteMere;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarteMereTest {
    @Test
    public void testFindOne() {
        assertEquals(1,testFindOneCM());
    }

    @Test
    public void testFetchAll() {
        assertEquals(1,testFetchAllCM());
    }

    private static int testFetchAllCM() {
        List<CarteMere> mesCM = null;

        try {
            mesCM = CarteMere.fetchAll();
            for (CarteMere CM :
                    mesCM) {
                System.out.println(CM.toString());
            }
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }

    }

    private static int testFindOneCM() {
        CarteMere maCM = null;

        try {
            maCM = CarteMere.findOne(1);
            System.out.println(maCM.toString());
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }


    }
}
