package readdatacomposants;

import entity.Memoire;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemoireTest {

    @Test
    public void testFindOne() {
        assertEquals(1, testFindOneMemoire());
    }

    @Test
    public void testFetchAll() {
        assertEquals(1, testFetchAllMemoire());
    }

    private static int testFetchAllMemoire() {
        List<Memoire> mesMem = null;
        try {
            mesMem = Memoire.fetchAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }

        for (Memoire mem :
                mesMem) {
            System.out.println(mem.toString());
        }
        return 1;
    }

    private static int testFindOneMemoire() {
        Memoire mem = null;
        try {
            mem = Memoire.findOne(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
        System.out.println(mem.toString());
        return 1;
    }
}
