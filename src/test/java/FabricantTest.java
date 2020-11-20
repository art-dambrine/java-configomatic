import entity.Fabricant;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static entity.Fabricant.getAllFabricants;

public class FabricantTest {
    public static void main(String[] args) {

        List<Fabricant> mesFabricants = null;

        try {
            mesFabricants = new ArrayList<>(getAllFabricants());
        } catch (SQLException throwables) {
            System.out.println("Erreur dans le chargement de la liste de fabricants.");
            throwables.printStackTrace();
        }

        for (Fabricant monFabricant : mesFabricants) System.out.println(monFabricant.toString());
    }
}
