
package dao;

import java.sql.*;
import java.util.*;

public interface EventDao<T> {
    
    void create(T object) throws SQLException;
    List<T> list() throws SQLException;
    
}
