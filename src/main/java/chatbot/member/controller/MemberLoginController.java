package chatbot.member.controller;

import chatbot.main.controller.Controller;
import chatbot.member.dao.MemberDao;
import chatbot.member.service.MemberService;

import java.util.Map;

public class MemberLoginController implements Controller {

    @Override
    public String process(Map<String, Object> model) {

        MemberService memberService = new MemberService(new MemberDao());



        return null;
    }

}
