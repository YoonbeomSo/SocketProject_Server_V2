//package chatbot.reservation.controller;
//
//import chatbot.main.controller.Controller;
//import chatbot.reservation.dto.ReservationInfoDTO;
//import chatbot.reservation.service.ReservationService;
//import java.text.SimpleDateFormat;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ReservationListController implements Controller {
//    @Override
//    public String process(Map<String, Object> model) {
//
//        /*예약 가능 시간 및 인원 목록 반환*/
//        ReservationService resService = new ReservationService();
//        List<ReservationInfoDTO> resListDto = resService.resList(model);
//
//        Map<String, String> render = new HashMap<>();
////        for(ReservationInfoDTO resDto : resListDto) {
////            if(resDto.getErrorMSG().isEmpty()){
////                model.put("errorMessage", "에러발생 : 다시 입력해주세요");
////            }else {
////                //SQL.date -> String 변환
////                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh");
////                String sDate = fmt.format(resDto.getResDate());
////                render.put(sDate, resDto.getResPeople());
////                model.put("render", render);
////            }
////        }
//
//        return "reservationList";
//    }
//
//}
