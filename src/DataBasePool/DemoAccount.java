package DataBasePool;

import org.junit.Test;

import java.sql.SQLException;

public class DemoAccount {
    private AccountDao dao = new AccountDao();

    @Test
    public void serviceMethod() throws SQLException {
        try{
            JdbcUtils.beginTransaction();

            dao.update("zs", -100);
            dao.update("ls", 100);

            JdbcUtils.commitTransaction();
        } catch (SQLException e) {

            try {
                JdbcUtils.rollbackTransaction();
            }catch(SQLException e1){
                throw new RuntimeException(e1);
            }
            throw new RuntimeException(e);
        }
    }
}
