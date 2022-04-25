package chatbot.member.controller;

import chatbot.main.controller.Controller;
import chatbot.member.dao.MemberDao;
import chatbot.member.service.MemberService;

import java.util.Map;

// 삭제 필요, MemberJoinController 대체
public class MemberSaveController implements Controller {

    @Override
    public String process(Map<String, Object> model) {

        MemberService memberService = new MemberService(new MemberDao());
        memberService.join(model);

        model.put("successMessage", "회원가입이 완료되었습니다.");
        return "memberForm";
    }
}
