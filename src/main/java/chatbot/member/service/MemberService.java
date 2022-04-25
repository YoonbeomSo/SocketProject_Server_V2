package chatbot.member.service;

import chatbot.member.dto.MemberDTO;
import chatbot.member.dao.MemberDao;
import com.google.gson.Gson;
import java.util.Map;

public class MemberService implements Service {

    private final MemberDao memberRepository;

    public MemberService(MemberDao memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Map<String, Object> model) {
        Gson gson = new Gson();
        Map<String, String> requestParamMap = (Map<String, String>) model.get("requestParam");

        MemberDTO member = new MemberDTO();
        member.setId((String) requestParamMap.get("id"));
        member.setPassword((String) requestParamMap.get("password"));
        member.setName((String) requestParamMap.get("name"));
        member.setMobile((String) requestParamMap.get("mobile"));

        System.out.println("member.toString() = " + member.toString());

        memberRepository.save(member);
    }

}
