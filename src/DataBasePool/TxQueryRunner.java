package DataBasePool;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TxQueryRunner extends QueryRunner {

    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        int[] result = super.batch(con, sql, params);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        T result = super.query(con, sql, rsh, params);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        T result = super.query(con, sql, rsh);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        int result = super.update(con, sql);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        int result = super.update(con, sql, param);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        int result = super.update(con, sql, params);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        T result = super.insert(con, sql, rsh);
        JdbcUtils.releaseConnection(con);
        return result;
    }


    @Override
    public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        T result = super.insertBatch(con, sql, rsh, params);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int execute(String sql, Object... params) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        int result = super.execute(con, sql, params);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> List<T> execute(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        List<T> result = super.execute(con, sql, rsh, params);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        T result = super.insert(con, sql, rsh, params);
        JdbcUtils.releaseConnection(con);
        return result;
    }
}
