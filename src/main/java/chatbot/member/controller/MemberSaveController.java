package chatbot.member.controller;

import chatbot.main.controller.Controller;

import java.util.Map;

public class MemberSaveController implements Controller {

    @Override
    public String process(Map<String, Object> model) {
        System.out.println("2번 선택했네~");
        return "storeList";
    }
}
