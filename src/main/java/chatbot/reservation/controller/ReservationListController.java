package chatbot.reservation.controller;

import chatbot.main.controller.Controller;
import chatbot.reservation.dto.AbleInfoDTO;
import chatbot.reservation.dto.ReservationInfoDTO;
import chatbot.reservation.service.ReservationService;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationListController implements Controller {
    @Override
    public String process(Map<String, Object> model) {

        /*예약 가능 시간 및 인원 목록 반환*/
        ReservationService resService = new ReservationService();
        List<AbleInfoDTO> ableListDto = resService.ableList(model);
        Map<Integer, Integer> render = new HashMap<>();

        if(ableListDto == null){
            model.put("errorMessage", "에러발생 : 예약 가능 정보 없음");
            return "reservationForm";
        }
        for(AbleInfoDTO ableDto : ableListDto) {
            int ableTime = ableDto.getAbTime();
            int ablePeople = ableDto.getAbPeople();
            render.put(ableTime, ablePeople);
        }
        model.put("render", render);

        return "reservationList";
    }

}
