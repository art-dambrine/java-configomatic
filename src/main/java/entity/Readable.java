package entity;

import java.sql.SQLException;
import java.util.List;

public interface Readable {

    List<Readable> fecthAll() throws SQLException;

    Readable findOne(int id) throws SQLException;
}
