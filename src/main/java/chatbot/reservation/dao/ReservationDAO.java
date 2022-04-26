package chatbot.reservation.dao;

import chatbot.common.StoreDTO;
import chatbot.reservation.dto.ReservationInfoDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ReservationDAO {
    private String sql = "";
    private PreparedStatement ps = null;
    private Connection con = null;
    private ResultSet rs = null;

    public ReservationDAO(){
//        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String url = "jdbc:oracle:thin:@211.204.195.197:11521:direadb";
        String user = "chatbot";
        String password = "chatbot";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ReservationInfoDTO> reservationInfoAll(){
        List<ReservationInfoDTO> resListDto = new ArrayList<>();
        ReservationInfoDTO resDto = new ReservationInfoDTO();
        int result = 0;
        sql ="SELECT * FROM RESERVATIONINFO";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                resDto.setRespeople(rs.getString("respeople"));
                resDto.setResdate(String.valueOf(rs.getDate("resdate")));
                resListDto.add(resDto);
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
        return resListDto;
    }

    public List<StoreDTO> storeAll(){
        List<StoreDTO> storeListDto = new ArrayList<>();
        StoreDTO storeDto = new StoreDTO();
        int result = 0;
        sql ="SELECT * FROM STORE";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
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


    public List<ReservationInfoDTO> reservationInfoSelect(String stNo) {
        List<ReservationInfoDTO> storeListDto = new ArrayList<>();
        ReservationInfoDTO resDto = new ReservationInfoDTO();
        int result = 0;
        sql ="SELECT * FROM RESERVATIONINFO WHERE = ? ORDER BY resdate";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, stNo);
            rs = ps.executeQuery();
            while(rs.next()){
                resDto.setResdate(String.valueOf(rs.getDate("resdate")));
                resDto.setRespeople(rs.getString("respeople"));
                storeListDto.add(resDto);
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



//    public List<ReservationInfoDTO> ScheduleAll(String storeName) {
//        List<ReservationInfoDTO> resListDto = new ArrayList<>();
//
//
//        return resListDto;
//    }
}
