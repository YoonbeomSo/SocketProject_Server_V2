//package chatbot.reservation.controller;
//
//import chatbot.common.HttpResponseCode;
//import chatbot.main.controller.Controller;
//import chatbot.reservation.service.ReservationService;
//import chatbot.reservation.service.SmsService;
//
//import java.util.Map;
//
//public class ReservationSmsController implements Controller {
//
//    @Override
//    public String process(Map<String, Object> model) {
//
//        SmsService smsService = new SmsService();
//
//        int responseCode = smsService.smsSend(model);
//        if (responseCode != HttpResponseCode.HTTP_ACCEPTED) {
//
//        } else {
//
//        }
//
//
//
//        return null;
//    }
//}
