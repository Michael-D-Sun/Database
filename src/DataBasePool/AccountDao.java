package DataBasePool;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class AccountDao {
    public static void update(String name, double money) throws SQLException {
        QueryRunner qr = new TxQueryRunner();
        String sql = "update account set balance=balance+? where name=?";
        Object[] params = {money, name};
        qr.update(sql, params);
    }

    @Test
    public void test() throws SQLException {
        update("zs", 100);
    }
}
