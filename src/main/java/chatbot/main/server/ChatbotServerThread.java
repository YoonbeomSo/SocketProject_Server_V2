package chatbot.main.server;

import chatbot.admin.controller.*;
import chatbot.common.Screen;
import chatbot.main.controller.Controller;
import chatbot.member.controller.*;
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

        controllerMap.put("memberForm", new MemberFormController());
        controllerMap.put("memberLoginForm", new MemberLoginFormController());

        controllerMap.put("memberJoinForm", new MemberJoinFormController());
        controllerMap.put("memberJoin", new MemberJoinController());


        controllerMap.put("memberLogin", new MemberLoginController());
        controllerMap.put("memberSave", new MemberSaveController());

        controllerMap.put("adminForm", new AdminFormController());

        controllerMap.put("lookStore",new LookStoreController());
        controllerMap.put("addStoreForm", new AddStoreFormController());
        controllerMap.put("deleteStore",new DeleteStoreController());
        controllerMap.put("addStore", new AddStoreController());
        controllerMap.put("addStoreInfo", new AddStoreInfoController());
        controllerMap.put("deleteStoreForm",new DeleteStoreFormController());
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
