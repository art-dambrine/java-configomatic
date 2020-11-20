import entity.Fabricant;
import entity.Readable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FabricantTest {
    public static void main(String[] args) {

        testFindOneFabricant();
        testFetchAllFabricants();

    }

    private static void testFindOneFabricant() {
        Fabricant fabricant = new Fabricant();

        try {
            System.out.println(fabricant.findOne(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void testFetchAllFabricants() {
        Fabricant fabricant = new Fabricant();
        List<Readable> mesFabricants = new ArrayList<>();

        try {
            mesFabricants = fabricant.fecthAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (Readable monFabricant : mesFabricants) System.out.println(monFabricant.toString());
    }
}
