package chatbot.member.controller;

import chatbot.main.controller.Controller;

import java.util.HashMap;
import java.util.Map;

public class MemberJoinFormController implements Controller {

    @Override
    public String process(Map<String, Object> model) {

        Map<String, String> render = new HashMap<>();
        render.put("1", "아이디");
        render.put("2", "비밀번호");
        render.put("3", "이름");
        render.put("4", "핸드폰번호");
        model.put("render", render);

        return "memberJoinForm";
    }
}
