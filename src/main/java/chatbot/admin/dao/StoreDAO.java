package chatbot.admin.dao;

import chatbot.common.DBConnect;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class StoreDAO {
    private static StoreDAO instance = new StoreDAO();
    private DBConnect db;


    public StoreDAO() {
        this.db = DBConnect.getInstance();
    }

    public static StoreDAO getInstance() {
        return instance;
    }

    public String insertStore(String stName) {

        Connection conn = db.getConnection();
        PreparedStatement ppst = null;
        String message = "입력한 [ " + stName + " ] 가게 제휴 등록 성공";
        try {
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
        Connection conn = db.getConnection();;
        ResultSet rs = null;
        String stNo;
        String message = stName + "Store 예약 시간 및 인원 입력 정보 저장 성공";
        try {
            Statement statement = conn.createStatement();
            for (Map.Entry<String, String> stringEntry : data.entrySet()
            ) {
                rs = statement.executeQuery("insert into ableinfo values(\n" +
                        "(select stno from store where stname='" + stName + "'" +
                        ")," + Integer.parseInt(stringEntry.getKey()) + "," + Integer.parseInt(stringEntry.getValue()) + ") ");
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
        Connection conn = db.getConnection();;
        ResultSet rs = null;
        Map<String, String> storeList = null;
        try {
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
        Connection conn = db.getConnection();
        ResultSet rs = null;
        Map<String, String> storeList = null;
        String message = "가게고유번호 "+stno+ " 정보가 삭제되었습니다.";
        try {
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
