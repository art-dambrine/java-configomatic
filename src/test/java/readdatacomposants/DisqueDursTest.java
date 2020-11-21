package readdatacomposants;

import entity.DisqueDur;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisqueDursTest {


    @Test
    public void testFindOne() {
        assertEquals(1, testFindOneDisqueDur());
    }

    @Test
    public void testFetchAll() {
        assertEquals(1, testFetchAllDisqueDur());
    }


    private int testFetchAllDisqueDur() {
        List<DisqueDur> mesDD = null;
        try {
            mesDD = DisqueDur.fetchAll();

            for (DisqueDur DD :
                    mesDD) {
                System.out.println(DD.toString());
            }

            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }


    }

    private static int testFindOneDisqueDur() {
        DisqueDur monDD = null;
        try {
            monDD = DisqueDur.findOne(1);
            System.out.println(monDD.toString());
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }


    }

}
