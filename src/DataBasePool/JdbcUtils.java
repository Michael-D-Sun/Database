package DataBasePool;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public static Connection getConnection() throws SQLException {
        Connection con = tl.get();
        if (con != null){
            return con;
        }
        else{
            return dataSource.getConnection();
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static void beginTransaction() throws SQLException {
        Connection con = tl.get();
        if(con != null){
            throw new RuntimeException("The transaction has been started. Cannot start again.");
        }
        con = getConnection();
        con.setAutoCommit(false);
        tl.set(con);
    }

    public static void commitTransaction() throws SQLException {
        Connection con = tl.get();
        if(con == null){
            throw new SQLException("The transaction is not started yet. Cannot commit");
        }
        con.commit();
        con.close();
        tl.remove();
    }

    public static void rollbackTransaction() throws SQLException {
        Connection con = tl.get();
        if(con == null){
            throw new SQLException("The transaction is not started yet.Cannot rollback");
        }
        con.rollback();
        con.close();
        tl.remove();
    }

    public static void releaseConnection(Connection connection) throws SQLException {
        Connection con = tl.get();
        if(con == null) connection.close();
        if(con != connection) connection.close();
    }
}
