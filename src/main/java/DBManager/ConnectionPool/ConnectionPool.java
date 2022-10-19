package DBManager.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {

    Connection getConnection() throws SQLException;
    boolean releaseConnection(Connection connection);
    String getUrl();
    String getUser();
    String getPass();

    int getConnectionPoolSize();
    int getUsedConnectionSize();

}
