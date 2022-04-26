package chatbot.admin.controller;

import java.util.Map;

public class DeleteStoreFormController implements chatbot.main.controller.Controller {
    @Override
    public String process(Map<String, Object> model) {

        model.put("render", "삭제할 가게번호를 입력해주세요.");
        return "deleteStoreForm";
    }
}
