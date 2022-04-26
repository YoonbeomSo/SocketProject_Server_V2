package chatbot.reservation.controller;

import chatbot.common.StoreDTO;
import chatbot.main.controller.Controller;
import chatbot.reservation.dto.ReservationInfoDTO;
import chatbot.reservation.service.ReservationService;

import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationFormController implements Controller {

    @Override
    public String process(Map<String, Object> model) {
        System.out.println("찍히나");
        /*식당 목록 반환*/
        ReservationService resService = new ReservationService();
        List<StoreDTO> storeListDto = resService.resStoreList();
        Map<String, String> render = new HashMap<>();
        if(storeListDto == null){
            model.put("errorMessage", "에러발생 : 식당 정보 없음");
            model.remove("successMessage");
            return "reservationForm";
        }
        for(StoreDTO storeDto : storeListDto) {
            render.put(storeDto.getStno(),storeDto.getStName());
        }

        model.put("service",resService);
        model.put("render", render);

        return "reservationForm";
    }
}
