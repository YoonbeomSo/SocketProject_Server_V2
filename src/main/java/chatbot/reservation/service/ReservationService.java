package chatbot.reservation.service;

import chatbot.common.StoreDTO;
import chatbot.reservation.dao.ReservationDAO;
import chatbot.reservation.dto.AbleInfoDTO;
import chatbot.reservation.dto.ReservationInfoDTO;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReservationService {
    private Map<String, String> reservationInfo = new HashMap<>();
    /*예약 선택 식당 리스트 전송 로직*/
    public List<StoreDTO> resStoreList(){
        ReservationDAO resDao = new ReservationDAO();
        List<StoreDTO> storeListDto = resDao.storeAll();
        if(storeListDto == null){
            return null;
        }
        return storeListDto;
    }

    /*예약 가능 시간 및 인원수 조회 로직*/
    public List<AbleInfoDTO> ableList(Map<String, Object> model) {
        String getStno = (String) model.get("requestParam");
        ReservationDAO resDao = new ReservationDAO();
        List<AbleInfoDTO> ableListDto = resDao.ableInfoSelectAll(getStno);
        if(ableListDto == null){
            return null;
        }else{
            //modul등록
            reservationInfo.put("stno",getStno);
            StoreDTO stoDto = resDao.storeSelectOne(getStno);
            reservationInfo.put("stname",stoDto.getStName());
            model.put("reservationInfo",reservationInfo);
        }
        return ableListDto;
    }


    public int updateTime(Map<String, Object> model){
        //1.able table 에서 abtime을 가져온다
        Map<String, String> data = (Map<String, String>)model.get("reservationInfo");
        String getStno = data.get("stno");
        ReservationDAO resDao = new ReservationDAO();
        List<AbleInfoDTO> ableListDto = resDao.ableInfoSelectAll(getStno);

        //2.client가 입력한 시간의 오류를 검사한다
        int result=0;
        String strReqeustTime = (String) model.get("requestParam");
        int requestTime = Integer.parseInt(strReqeustTime);
        System.out.println(requestTime+"12312312313");
        for(AbleInfoDTO able : ableListDto){
            if(able.getAbTime() == requestTime){
                result=1;
            }
        }
        //3.modul에 등록
        if(result!=0){
            String stName = data.get("stname");
            reservationInfo.put("stno",getStno);
            reservationInfo.put("stname",stName);
            reservationInfo.put("restime",strReqeustTime);
            model.put("reservationInfo",reservationInfo);
        }
        return result;
    }


    public int updatePeople(Map<String, Object> model) {
        //1.able table 에서 abPeople을 가져온다
        Map<String, String> data = (Map<String, String>)model.get("reservationInfo");
        String getStno = data.get("stno");
        String strReqeustTime = data.get("restime");
        ReservationDAO resDao = new ReservationDAO();
        AbleInfoDTO albeDto = resDao.ableInfoSelect(getStno, strReqeustTime);
        int abPeople = albeDto.getAbPeople();
        String strRequestPeople = (String) model.get("requestParam");
        int requestPeople = Integer.parseInt(strRequestPeople);
        int newAbPeople = abPeople - requestPeople;
        String strNewAbPeople = Integer.toString(newAbPeople);
        //2.client가 입력한 인원의 오류를 검사한다
        int result;
        if (requestPeople <= 0 ||  newAbPeople < 0) {
            result=0;
        }else{
            //3.오류검증이 끝나면 잔여인원 삭제 후 ABLEINFO 테이블로 등록한다.
            result = resDao.updateAbleInfo(getStno,strReqeustTime,strNewAbPeople);
        }
        if(result == 1){
            //4.마지막으로 ABLEINFO테이블에 등록되었다면 ReservationInfo에 Insert한다.
            result = this.insertResInfo(model, strRequestPeople);
        }
        return result;
    }

    private int insertResInfo(Map<String, Object> model, String strRequestPeople) {

        int result=0;
        //MNO
        Map<String, String> memData = (Map<String, String>)model.get("member");
        String mno = memData.get("mno");
//        String mno = "1";
        //STNO
        Map<String, String> resData = (Map<String, String>)model.get("reservationInfo");
        String stno = resData.get("stno");

        //RESPEOPLE
        String resPeople = strRequestPeople;

        //RESDATE
        String resTime = resData.get("restime");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        String sqlDate = sdf.format(c1.getTime())+" "+resTime;

        //등록
        ReservationDAO resDao = new ReservationDAO();
        result = resDao.insertResInfo(mno,stno,resPeople,sqlDate);

        if(result == 1) {
            //model 등록
            String stName = resData.get("stname");
            String restime = resData.get("restime");

            reservationInfo.put("resdate",sqlDate);
            reservationInfo.put("stno",stno);
            reservationInfo.put("stname",stName);
            reservationInfo.put("restime",restime);
            reservationInfo.put("respeople",resPeople);

            model.put("reservationInfo",reservationInfo);
        }

        return result;
    }



}




