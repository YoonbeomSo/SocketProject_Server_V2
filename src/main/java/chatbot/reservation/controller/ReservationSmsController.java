package chatbot.reservation.controller;
import chatbot.common.HttpResponseCode;
import chatbot.main.controller.Controller;
import chatbot.reservation.service.SmsService;
import com.google.gson.Gson;

import java.util.Map;

public class ReservationSmsController implements Controller {

    @Override
    public String process(Map<String, Object> model) {

        Gson gson = new Gson();
        System.out.println("확인: " + gson.toJson(model));



        SmsService smsService = new SmsService();

        int responseCode = smsService.smsSend(model);
        if (responseCode != HttpResponseCode.HTTP_ACCEPTED) {
            model.put("errorMessage", "문자 발송 서비스에 장애가 발생했습니다. 예약은 진행되었으니 관리자에게 문의 바랍니다.");
        } else {
            model.put("successMessage", "문자 발송이 완료되었습니다. 서비스를 종료합니다.");
        }

        return "Disconnect";
    }
}
