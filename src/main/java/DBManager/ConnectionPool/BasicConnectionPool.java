package DBManager.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasicConnectionPool implements ConnectionPool{

    private String url;
    private String user;
    private String pass;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 10;
    private static int MAX_TIME_OUT = 1 ;

    private BasicConnectionPool(String url, String user, String pass, List<Connection> connectionPool) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.connectionPool = connectionPool;
    }

    public static ConnectionPool create(String url,
                                             String user,
                                             String pass) throws SQLException {

        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for(int i = 0; i < INITIAL_POOL_SIZE; i ++){
            pool.add(createConnection(url,user,pass));
        }

        return new BasicConnectionPool(url, user, pass, pool);
    }

    private static Connection createConnection(String url,String user, String pass) throws SQLException {
        return DriverManager.getConnection(url,user,pass);
    }


    @Override
    public Connection getConnection() throws SQLException {
        if(connectionPool.isEmpty()){
            if(usedConnections.size() < INITIAL_POOL_SIZE){
                connectionPool.add(createConnection(this.url, this.user, this.pass));
            }else{
                throw new RuntimeException("No available connections! The pool is empty ");
            }
        }

        Connection connection = connectionPool
                                .remove(connectionPool.size() - 1);


        if(!connection.isValid(MAX_TIME_OUT)){
         connection = createConnection(this.url, this.user, this.pass);
        }

        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getUser() {
        return this.user;
    }

    @Override
    public String getPass() {
        return this.pass;
    }

    public static int getInitialPoolSize() {
        return INITIAL_POOL_SIZE;
    }

    public int getConnectionPoolSize(){
        return connectionPool.size();
    }

    public int getUsedConnectionSize(){
        return usedConnections.size();
    }

}
