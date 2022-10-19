package DBManager;

import DBManager.ConnectionPool.ConnectionPool;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.codegen.GenerationTool;
import org.jooq.impl.DSL;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {

    private SQLDialect  SQLdialect;

    ConnectionPool connectionPool;

    public DBManager(
                     ConnectionPool connectionPool,SQLDialect  SQLdialect  ) throws SQLException {
        this.connectionPool = connectionPool;
        this.SQLdialect = SQLdialect;
    }

    public Result<Record> getTable(TableLike<?> table) throws SQLException {
        Connection DBConnection = connectionPool.getConnection();
        getPoolStatistic();
        DSLContext context = DSL.using(DBConnection, SQLdialect);

        Result<Record> result = context.select()
                .from(table)
                .fetch();

        connectionPool.releaseConnection(DBConnection);
        getPoolStatistic();
        return result;
    }


    public static void createDBClasses(String config) throws Exception {
         GenerationTool.generate(
                 Files.readString(
                          Path.of(config)
                  )
          );
    }

    private void getPoolStatistic(){
        System.out.println("Connection pool size: " + connectionPool.getConnectionPoolSize());
        System.out.println("Used connections: " + connectionPool.getUsedConnectionSize());
    }


}
