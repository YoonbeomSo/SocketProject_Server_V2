package chatbot.admin.controller;

import chatbot.admin.service.AdminService;
import chatbot.main.controller.Controller;

import java.util.Map;

public class LookStoreController implements Controller {
    @Override
    public String process(Map<String, Object> model) {
        model.remove("successMessage");
        AdminService adminService = new AdminService();
        model.put("render", adminService.lookStore());


        return "lookStore";
    }
}
