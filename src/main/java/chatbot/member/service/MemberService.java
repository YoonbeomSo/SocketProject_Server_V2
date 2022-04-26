package chatbot.member.service;

import chatbot.member.dto.MemberDTO;
import chatbot.member.dao.MemberDao;
import com.google.gson.Gson;
import java.util.Map;

public class MemberService implements Service {

    private final MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public boolean join(Map<String, Object> model) {
        Gson gson = new Gson();
        Map<String, String> requestParamMap = (Map<String, String>) model.get("requestParam");

        MemberDTO member = new MemberDTO();
        member.setId(requestParamMap.get("id"));
        member.setPassword(requestParamMap.get("password"));
        member.setName(requestParamMap.get("name"));
        member.setMobile(requestParamMap.get("mobile"));

        System.out.println("member.toString() = " + member.toString());

        boolean isFinded = memberDao.findId(requestParamMap.get("id"));
        if (isFinded) {
            return false;
        }

        memberDao.save(member);
        return true;
    }

    @Override
    public boolean login(Map<String, Object> model) {
        Gson gson = new Gson();
        Map<String, String> requestParamMap = (Map<String, String>) model.get("requestParam");
        String requestId = requestParamMap.get("id");
        String requestPassword = requestParamMap.get("password");

        String dbPassword = memberDao.findMemberbyId(requestId).getPassword();

        if (requestPassword.equals(dbPassword)) {
            MemberDTO member = memberDao.findMemberbyId(requestId);
            String memberJsonString = gson.toJson(member);
            model.put("member", memberJsonString);
            return true;
        }

        return false;
    }

}
