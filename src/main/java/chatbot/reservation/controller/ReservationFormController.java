package chatbot.reservation.controller;

import chatbot.main.controller.Controller;
import chatbot.reservation.dto.ReservationInfoDTO;
import chatbot.reservation.service.ReservationService;

import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationFormController implements Controller {

    @Override
    public String process(Map<String, Object> model) {

        /*식당 목록 반환*/
        ReservationService resService = new ReservationService();
        List<ReservationInfoDTO> resListDto = resService.resStoreList();
        Map<String, String> render = new HashMap<>();

        for(ReservationInfoDTO resDto : resListDto) {
            if(resDto.getErrorMSG().isEmpty()){
                model.put("errorMessage", "에러발생 : 식당을 등록해주세요");
            }else {
                render.put(resDto.getStno(),resDto.getResPeople());
                model.put("render", render);
            }
        }
        return "reservationForm";
    }
}
