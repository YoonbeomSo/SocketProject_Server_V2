package chatbot.main.controller;

import java.util.Map;

public interface Controller {

    /**
     * @param model DTO, screenName 등 담을 모델
     * @return renderScreenName - 클라이언트에서 화면 렌더링 시 필요한 이름
     */
    String process(Map<String, Object> model);

}
