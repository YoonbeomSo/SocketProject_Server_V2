package chatbot.admin.controller;

import java.util.HashMap;
import java.util.Map;

public class AddStoreFormController implements chatbot.main.controller.Controller {
    @Override
    public String process(Map<String, Object> model) {
        String render = "추가할 가게명을 입력해주세요.";
        model.put("render",render);
        return "addStore";
    }
}
