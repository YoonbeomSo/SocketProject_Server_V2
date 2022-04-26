package chatbot.member.controller;

import chatbot.main.controller.Controller;
import chatbot.member.dao.MemberDao;
import chatbot.member.service.MemberService;

import java.util.Map;

// 회원가입 컨트롤러
public class MemberJoinController implements Controller {

    @Override
    public String process(Map<String, Object> model) {

        MemberService memberService = new MemberService(new MemberDao());

        boolean isJoined = memberService.join(model);
        if (isJoined) {
            model.put("successMessage", "회원가입이 완료되었습니다.");
            model.remove("errorMessage");
            model.remove("requestParam");
            model.put("forward", "memberForm");
            return "";
        }

        model.put("errorMessage", "이미 등록된 아이디 입니다.");
        model.remove("requestParam");
        model.put("forward", "memberJoinForm");
        return "";
    }
}
