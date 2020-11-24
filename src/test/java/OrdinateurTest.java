import entity.Ordinateur;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdinateurTest {
    @Test
    public void testAllOrdinateur(){
        assertEquals(1,testFetchAllOrdinateur());
    }

    private int testFetchAllOrdinateur() {
        List<Ordinateur> mesOrdinateurs;
        try {
            mesOrdinateurs = Ordinateur.fetchAll();
            for (Ordinateur ordi:
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
