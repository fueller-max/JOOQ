import DBManager.ConnectionPool.BasicConnectionPool;
import DBManager.ConnectionPool.ConnectionPool;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConnectionPoolTest {

 @Test
 public  void callSQLConnectionConnectionPool() throws SQLException {

  ConnectionPool connectionPool = BasicConnectionPool
                          .create("jdbc:mysql://localhost:3306/skillbox",
                                  "root",
                                  "ft232rl");

  Assert.assertTrue(connectionPool.getConnection().isValid(1));
 }

 @Test
 public void reachMaximumConnectionsShouldThrowRuntimeException() throws SQLException {

  ConnectionPool connectionPool = BasicConnectionPool
          .create("jdbc:mysql://localhost:3306/skillbox",
                  "root",
                  "ft232rl");

  List<Connection> connections = new ArrayList<>();


  Assert.assertThrows(RuntimeException.class,
          () -> {
                  for(int i = 0; i <BasicConnectionPool.getInitialPoolSize()  + 1 ; i++ )
                   {
                     connections.add(connectionPool.getConnection());
                   }
                 }
                 );

 }

}
