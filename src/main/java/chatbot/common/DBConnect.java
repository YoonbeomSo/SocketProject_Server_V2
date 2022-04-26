package chatbot.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    final private static DBConnect db = new DBConnect();
    private Connection connection = null;

    final static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    final static String JDBC_URL = "jdbc:oracle:thin:@211.204.195.197:11521:direadb";
    //final static String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    final static String ORACLE_ID = "chatbot";
    final static String ORACLE_PASSWORD = "chatbot";

    private DBConnect() {

    }

    public static DBConnect getInstance() {
        return db;
    }

    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(JDBC_URL, ORACLE_ID, ORACLE_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
