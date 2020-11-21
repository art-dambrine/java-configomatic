package readdatacomposants;

import entity.Fabricant;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FabricantTest {
    @Test
    public void testFindOne() {
        assertEquals(1, testFindOneFabricant());
    }

    @Test
    public void testFetchAll() {
        assertEquals(1, testFetchAllFabricants());
    }

    private static int testFindOneFabricant() {

        try {
            System.out.println(Fabricant.findOne(1));
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    private static int testFetchAllFabricants() {

        List<Fabricant> mesFabricants = new ArrayList<>();

        try {
            mesFabricants = Fabricant.fetchAll();
            for (Fabricant monFabricant : mesFabricants) System.out.println(monFabricant.toString());
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }


    }
}
