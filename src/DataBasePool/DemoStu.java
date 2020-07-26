package DataBasePool;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DemoStu {
    @Test
    public void beanList() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from t_stu";
        List<Stu> stuList = qr.query(sql, new BeanListHandler<Stu>(Stu.class));
        System.out.println(stuList);
    }

    @Test
    public void mapResult() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from t_stu where sid=?";
        Object[] params = {1001};
        Map map = qr.query(sql, new MapHandler(), params);
        System.out.println(map);
    }

    @Test
    public void mapList() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from t_stu";
        List<Map<String, Object>> map = qr.query(sql, new MapListHandler());
        System.out.println(map);
    }

    @Test
    public void saclar() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select count(*) from t_stu";
        Object obj = qr.query(sql, new ScalarHandler());
        System.out.println(obj);
    }

}
