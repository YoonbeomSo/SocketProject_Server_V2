package chatbot.reservation.service;

import chatbot.common.StoreDTO;
import chatbot.reservation.dao.ReservationDAO;
import chatbot.reservation.dto.ReservationInfoDTO;

import java.util.List;
import java.util.Map;


public class ReservationService {

    /*예약 선택 식당 리스트 전송 로직*/
    public List<ReservationInfoDTO> resStoreList(){
        ReservationDAO resDao = new ReservationDAO();
        List<ReservationInfoDTO> resListDto = resDao.reservationInfoAll();
        if(resListDto == null){
            ReservationInfoDTO resDto = new ReservationInfoDTO();
            resDto.setErrorMSG("errorMessage");
            resListDto.add(resDto);
        }
        return resListDto;
    }

    /*예약 가능 시간 및 인원수 조회 로직*/
    public List<ReservationInfoDTO> resList(Map<String, Object> model) {
        String getData = (String) model.get("requestParam");

        ReservationDAO resDao = new ReservationDAO();
        List<StoreDTO> storeListDto = resDao.storeAll();
        String stName;
        String stNo = null;
        List<ReservationInfoDTO> resListDto = null;
        for (StoreDTO StoreDto : storeListDto) {
            if (getData.equals(StoreDto.getStno())) {
                stName = StoreDto.getStName();
                stNo = StoreDto.getStno();
                resListDto = resDao.reservationInfoSelect(stNo);
            } else {
                ReservationInfoDTO resDto = new ReservationInfoDTO();
                resDto.setErrorMSG("errorMessage");
                resListDto.add(resDto);
            }
        }
        return resListDto;
    }
}



//    //예약 등록 로직
//    public void resRegistration(){
//
//    }

