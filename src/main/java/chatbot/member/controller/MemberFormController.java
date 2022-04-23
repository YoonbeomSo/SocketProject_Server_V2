package chatbot.member.controller;

import chatbot.main.controller.Controller;

import java.util.Map;

public class MemberFormController implements Controller {

    @Override
    public String process(Map<String, Object> model) {
        // Map 출력
//        for (Map.Entry<String, Object> entry : model.entrySet()) {
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//            System.out.println(entry.getValue().getClass().getName());
//        }
        return "폼으로 가라";
    }

}
