package chatbot.reservation.dao;

import chatbot.common.DBConnect;
import chatbot.common.StoreDTO;
import chatbot.reservation.dto.AbleInfoDTO;
import chatbot.reservation.dto.ReservationInfoDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReservationDAO {

    final private DBConnect db;

    public ReservationDAO() {
        db = DBConnect.getInstance();
        con = db.getConnection();
    }


    private String sql = "";
    private PreparedStatement ps = null;
    private Connection con = null;
    private ResultSet rs = null;

//    public ReservationDAO(){
//        String url = "jdbc:oracle:thin:@localhost:1521:xe";
//        String user = "chatbot";
//        String password = "chatbot";
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            con = DriverManager.getConnection(url, user, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public List<StoreDTO> storeAll(){
        List<StoreDTO> storeListDto = new ArrayList<>();
        sql ="SELECT * FROM STORE";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                StoreDTO storeDto = new StoreDTO();
                storeDto.setStno(rs.getString("stno"));
                storeDto.setStName(rs.getString("stname"));
                storeListDto.add(storeDto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rs!=null) rs.close();
                if(ps!=null) ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return storeListDto;
    }

    public List<AbleInfoDTO> ableInfoSelectAll(String getStno){
        List<AbleInfoDTO> ableListDto = new ArrayList<>();
        sql ="SELECT * FROM ABLEINFO WHERE stno=? ORDER BY stno, abtime";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, getStno);
            rs = ps.executeQuery();

            while(rs.next()) {
                AbleInfoDTO ableDto = new AbleInfoDTO();
                ableDto.setStno(rs.getString("stno"));
                ableDto.setAbTime(rs.getInt("abtime"));
                ableDto.setAbPeople(rs.getInt("abpeople"));
                ableListDto.add(ableDto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rs!=null) rs.close();
                if(ps!=null) ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return ableListDto;
    }

    public AbleInfoDTO ableInfoSelect(String getStno, String getTime) {
        AbleInfoDTO ableDto = new AbleInfoDTO();
        sql ="SELECT * FROM ABLEINFO WHERE stno = ? and abtime = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, getStno);
            ps.setString(2, getTime);
            rs = ps.executeQuery();
            if(rs.next()){
                ableDto.setAbTime(rs.getInt("abtime"));
                ableDto.setAbPeople(rs.getInt("abpeople"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rs!=null) rs.close();
                if(ps!=null) ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return ableDto;
    }

    public int updateAbleInfo(String getStno,String strReqeustTime,String strNewAbPeople) {
        AbleInfoDTO ableDto = new AbleInfoDTO();
        sql ="UPDATE ABLEINFO SET abtime=?, abpeople=? WHERE stno=? AND abtime=?";
        int result = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, strReqeustTime);
            ps.setString(2, strNewAbPeople);
            ps.setString(3, getStno);
            ps.setString(4, strReqeustTime);
            result = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rs!=null) rs.close();
                if(ps!=null) ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

    public int insertResInfo(String mno, String stno, String resPeople, String sqlDate) {
        AbleInfoDTO ableDto = new AbleInfoDTO();
        sql ="INSERT INTO RESERVATIONINFO VALUES(?,?,?,?,RESERVATION_RESNO_SEQ.nextval)";
        int result = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sqlDate);
            ps.setString(2, resPeople);
            ps.setString(3, stno);
            ps.setString(4, mno);
            result = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rs!=null) rs.close();
                if(ps!=null) ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

    public StoreDTO storeSelectOne(String stno) {
        StoreDTO stoDto = new StoreDTO();
        sql ="SELECT * FROM STORE WHERE stno=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, stno);
            rs = ps.executeQuery();
            if(rs.next()){
                stoDto.setStName(rs.getString("stname"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rs!=null) rs.close();
                if(ps!=null) ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return stoDto;
    }
}
