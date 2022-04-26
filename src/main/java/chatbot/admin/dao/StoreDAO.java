package chatbot.admin.dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class StoreDAO {
    private static StoreDAO instance = new StoreDAO();

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private StoreDAO() {
    }

    public static StoreDAO getInstance() {
        return instance;
    }

    public String insertStore(String stName) {
        //String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection conn = null;
        PreparedStatement ppst = null;
        String message = "입력한 [ " + stName + " ] 가게 제휴 등록 성공";
        try {
            // Class.forName(driver);
            conn = DriverManager.getConnection(url, "chatbot", "chatbot");
            ppst = conn.prepareStatement("insert into store values(store_stno_seq.nextval, ?)");
            ppst.setString(1, stName);
            ppst.executeUpdate();
            ppst.close();
            conn.close();
        } catch (SQLException e) {
            message = "입력한 [ " + stName + " ] 가게 제휴 등록 실패";
            e.printStackTrace();
        }
        return message;
    }

    public String insertStoreInfo(String stName, Map<String, String> data) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection conn = null;
        ResultSet rs = null;
        String stNo;
        //PreparedStatement ppst = null;
        String message = stName + "Store 예약 시간 및 인원 입력 정보 저장 성공";
        try {
            conn = DriverManager.getConnection(url, "chatbot", "chatbot");
            Statement statement = conn.createStatement();
            /*ppst = conn.prepareStatement("insert into ableinfo values(\n" +
                    "(select stno from store where stname=" + stName +
                    "), ?,?) ");*/
            for (Map.Entry<String, String> stringEntry : data.entrySet()
            ) {
                rs = statement.executeQuery("insert into ableinfo values(\n" +
                        "(select stno from store where stname='" + stName + "'" +
                        ")," + Integer.parseInt(stringEntry.getKey()) + "," + Integer.parseInt(stringEntry.getValue()) + ") ");

                /*ppst.setString(1, stringEntry.getKey());
                ppst.setString(2, stringEntry.getValue());
                ppst.executeUpdate();*/

            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            message = stName + "예약 시간 및 인원 입력 정보 저장 실패";
            e.printStackTrace();
        }
        return message;
    }

    public Map<String, String> getStoreList() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection conn = null;
        ResultSet rs = null;
        Map<String, String> storeList = null;
        try {
            conn = DriverManager.getConnection(url, "chatbot", "chatbot");
            Statement statement = conn.createStatement();
            rs = statement.executeQuery("select * from store");

            if (rs.next()) {
                storeList = new HashMap<>();
                do {
                    storeList.put(rs.getString("stno"),
                            rs.getString("stname"));
                } while (rs.next());
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return storeList;
    }

    public String deleteStoreInfo(String stno) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection conn = null;
        ResultSet rs = null;
        Map<String, String> storeList = null;
        String message = "가게고유번호 "+stno+ " 정보가 삭제되었습니다.";
        try {
            conn = DriverManager.getConnection(url, "chatbot", "chatbot");
            Statement statement = conn.createStatement();
            rs = statement.executeQuery("delete from ableinfo where stno=" + stno);
            rs = statement.executeQuery("delete from reservationinfo where stno=" + stno);
            rs = statement.executeQuery("delete from store where stno=" + stno);
            rs.close();
            conn.close();
        } catch (SQLException e) {
            message = "가게고유번호 "+stno+ " 정보가 정상적으로 삭제되지않았습니다.";
            e.printStackTrace();
        }
        return message;
    }
}
