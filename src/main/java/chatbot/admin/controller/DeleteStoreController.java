package chatbot.admin.controller;

import chatbot.admin.service.AdminService;

import java.util.Map;

public class DeleteStoreController implements chatbot.main.controller.Controller {
    @Override
    public String process(Map<String, Object> model) {
        AdminService adminService = new AdminService();
       // model.put("render", adminService.deleteStore((String) model.get("requestParam")));
        model.put("successMessage", adminService.deleteStore((String) model.get("requestParam")));

        return "deleteStoreResult";
    }
}
