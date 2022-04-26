package chatbot.reservation.controller;

import chatbot.main.controller.Controller;
import chatbot.reservation.dto.AbleInfoDTO;
import chatbot.reservation.service.ReservationService;

import java.util.HashMap;
import java.util.Map;

public class ReservationTimeUpdateController implements Controller {

    @Override
    public String process(Map<String, Object> model) {
        /*입력된 예약시간 조회*/
        ReservationService resService = new ReservationService();
        int result = resService.updateTime(model);
        System.out.println("result == "+result);
        if(result == 0){
            model.put("errorMessage", "에러발생 : 예약시간 입력 오류");
            model.remove("successMessage");
            return "reservationList";
        }else{
            model.put("successMessage", "예약시간 입력 성공");
            model.remove("errorMessage");
        }
        return "reservationTimeUpdate";
    }
}
