
package dao;

import java.sql.*;

public interface UserDao<T, K> {
    
    void create(T object) throws SQLException;
    T read (K object) throws SQLException;
    
}
