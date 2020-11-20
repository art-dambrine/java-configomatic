import entity.Fabricant;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FabricantTest {
    public static void main(String[] args) {

        testFindOneFabricant();
        testFetchAllFabricants();

    }

    private static void testFindOneFabricant() {

        try {
            System.out.println(Fabricant.findOne(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void testFetchAllFabricants() {

        List<Fabricant> mesFabricants = new ArrayList<>();

        try {
            mesFabricants = Fabricant.fecthAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (Fabricant monFabricant : mesFabricants) System.out.println(monFabricant.toString());
    }
}
