package chatbot.admin.controller;

import chatbot.main.controller.Controller;

import java.util.HashMap;
import java.util.Map;

public class AdminFormController implements Controller {

    @Override
    public String process(Map<String, Object> model) {

        Map<String, String> render = new HashMap<>();
        render.put("1", "제휴가게 조회");
        render.put("2", "제휴가게 추가");
        render.put("3", "제휴가게 삭제");
        render.put("4", "종료");
        model.put("render", render);

        return "adminForm";
    }
}
