package chatbot.admin.controller;

import chatbot.admin.service.AdminService;

import java.util.Map;

public class AddStoreInfoController implements chatbot.main.controller.Controller {

    @Override
    public String process(Map<String, Object> model) {
        AdminService adminService = new AdminService();
        model.put("render", adminService.addStoreInfo(model));
        return "addStoreResult";
    }
}
