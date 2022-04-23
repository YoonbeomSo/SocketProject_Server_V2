package chatbot.common;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;
import java.util.Map;

public class Screen {

    private static final Logger logger = LogManager.getLogger(Screen.class);

    private final String screenName;

    public Screen(String screenName) {
        this.screenName = screenName;
    }

    public void render(Map<String, Object> model, PrintWriter pw){
        String responseData = modelToJsonString(model);
        logger.debug("responseData : {}", responseData);
        pw.println(responseData);
        pw.flush();
    }

    // Map -> Json 문자열
    private String modelToJsonString(Map<String, Object> model) {
        Gson gson = new Gson();
        model.put("screenName", screenName);
        return gson.toJson(model);
    }
}
