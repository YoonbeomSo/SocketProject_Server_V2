package chatbot.reservation.controller;

import chatbot.main.controller.Controller;
import chatbot.reservation.dto.AbleInfoDTO;
import chatbot.reservation.dto.ReservationInfoDTO;
import chatbot.reservation.service.ReservationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationPeopleUpdateController implements Controller {
    @Override
    public String process(Map<String, Object> model) {
        /*입력된 예약인원 등록*/
        ReservationService resService = new ReservationService();
        int result = resService.updatePeople(model);

        if(result == 0){
            model.put("errorMessage", "에러발생 : 예약인원 오류");
            model.remove("successMessage");
            return "reservationTimeUpdate";
        }else{
            model.put("successMessage", "예약인원 입력 성공");;
            model.remove("errorMessage");
        }
        return "reservationPeopleUpdate";
    }
}
