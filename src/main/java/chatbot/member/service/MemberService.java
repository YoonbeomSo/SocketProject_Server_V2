package chatbot.member.service;

import chatbot.member.dto.MemberDTO;
import chatbot.member.dao.MemberDao;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class MemberService implements Service {

    private final MemberDao memberRepository;

    public MemberService(MemberDao memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Map<String, Object> model) {
        Gson gson = new Gson();
//        System.out.println(model.get("requestParam").getClass().getName());
//        System.out.println("1111 " + model.get("requestParam"));
//        System.out.println("1111 " + model.get("requestParam").getClass().getName());

        Map<String, String> requestParamMap = (Map<String, String>) model.get("requestParam");




//        Map<String, Object> test = gson.fromJson((String) model.get("requestParam"), HashMap.class);

//        System.out.println("mobile " + test.get("mobile"));

//
//        String jsonString = gson.toJson(model);
//
//        JsonElement jsonElement = JsonParser.parseString(jsonString);
//        JsonObject jsonObject = jsonElement.getAsJsonObject();
//        JsonObject requestParamObject = jsonObject.get("requestParam").getAsJsonObject();
//        String requestParamString = requestParamObject.getAsString();
//
//        Map<String, Object> requestParamMap = gson.fromJson(requestParamString, HashMap.class);

        MemberDTO member = new MemberDTO();
        member.setId((String) requestParamMap.get("id"));
        member.setPassword((String) requestParamMap.get("password"));
        member.setName((String) requestParamMap.get("name"));
        member.setMobile((String) requestParamMap.get("mobile"));


//        String memberJsonString = (String) model.get("requestParam");
//        System.out.println("memberJsonString = " + memberJsonString);
//        Gson gson = new Gson();
//        MemberDTO member = gson.fromJson(memberJsonString, MemberDTO.class);




        System.out.println("member.toString() = " + member.toString());

        memberRepository.save(member);
    }

}
