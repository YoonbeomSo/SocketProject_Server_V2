package chatbot.main.server;

import chatbot.common.Screen;
import chatbot.main.controller.Controller;
import chatbot.member.controller.*;
import chatbot.reservation.controller.ReservationFormController;
import chatbot.reservation.controller.ReservationListController;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatbotServerThread extends Thread {

    private static final Logger logger = LogManager.getLogger(ChatbotServerThread.class);

    private final Socket socket;
    private final Map<String, Controller> controllerMap = new HashMap<>();

    public ChatbotServerThread(Socket socket) {
        this.socket = socket;

        // 클라이언트가 처음 접속했을 때
        controllerMap.put("memberForm", new MemberFormController());
        // 클라이언트가 1. 로그인 2. 회원가입 목록에서 1번을 선택했을 때
        controllerMap.put("memberLoginForm", new MemberLoginFormController());
        // 클라이언트가 1. 로그인 2. 회원가입 목록에서 2번을 선택했을 때
        controllerMap.put("memberJoinForm", new MemberJoinFormController());

        // 클라이언트가 회원가입 진행 시
        // 1. 아이디, 2. 비밀번호, 3. 이름, 4. 핸드폰번호 차례로 입력 했을 때
        controllerMap.put("memberJoin", new MemberJoinController());

        // TODO 클라이언트가 로그인 진행 시 로그인 로직 처리해야 함
        controllerMap.put("memberLogin", new MemberLoginController());


        // 클라이언트 로그인 완료 시 식당목록 보여줌
        controllerMap.put("reservationForm", new ReservationFormController());

        // 클라이언트가 식당 선택 시 시간 및 인원 보여줌
        controllerMap.put("reservationList", new ReservationListController());
    }

    @Override
    public void run() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter pw = new PrintWriter(socket.getOutputStream())) {

            while (true) {
                String receivedJsonString = br.readLine();
                System.out.println("ChatbotServerThread.run");
                logger.debug("receivedJsonString : {}", receivedJsonString);
                Gson gson = new Gson();

                JsonElement element = JsonParser.parseString(receivedJsonString);
                if (!element.isJsonObject()) {
                    System.out.println("ChatbotServerThread.run");
                    logger.error("올바르지 않은 json 형식 : {}", receivedJsonString);
                    pw.println("올바른 Json 형식이 아닙니다. - " + receivedJsonString);
                    pw.flush();
                    return;
                }

                // Json 문자열 -> Map
                Map<String, Object> model = gson.fromJson(receivedJsonString, HashMap.class);
                model.forEach((key, value) -> logger.debug(key + " : " + value));

                Object route = model.get("route");
                if (route == null) {
                    logger.error("route is null");
                    pw.println("route 값이 없습니다.");
                    pw.flush();
                    return;
                }
                logger.debug("route : {}", route);

                Controller controller = controllerMap.get((String)route);
                if (controller == null) {
                    logger.error("요청 컨트롤러 없음 : {}", route);
                    pw.println("요청 Controller 가 없습니다. - " + route);
                    pw.flush();
                    return;
                }

                String screenName = controller.process(model);

                String forward = (String) model.get("forward");
                if (forward != null) {
                    controller = controllerMap.get(forward);
                    screenName = controller.process(model);
                }

                System.out.println("ChatbotServerThread.run");
                logger.debug("screenName : {}", screenName);
                model.forEach((key, value) -> logger.debug(key + " : " + value));

                Screen screen = new Screen(screenName);
                screen.render(model, pw);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("쓰레드 끝남..");
        }


    }
}
