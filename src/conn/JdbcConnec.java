package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnec {

    private static JdbcConnec jdConnec;

    private Connection connection;

    private final String url = "jdbc:mysql://localhost:3306/student";
    private final String user = "root";
    private final String pass = "2406";

    private JdbcConnec() {
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static JdbcConnec getInstance() {
        if (jdConnec == null) {
            synchronized (JdbcConnec.class) {
                if (jdConnec == null) {
                    jdConnec = new JdbcConnec();
                }
            }
        }
        return jdConnec;
    }

    public Connection getConn() {
        return connection;
    }

}