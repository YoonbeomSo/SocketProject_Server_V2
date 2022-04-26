package chatbot.admin.controller;

import chatbot.admin.service.AdminService;

import java.util.Map;

public class AddStoreController implements chatbot.main.controller.Controller {

    @Override
    public String process(Map<String, Object> model) {
        AdminService adminService = new AdminService();

        String render = adminService.addStore(model);

        model.put("render", render);

        return "addStoreInfoForm";
    }
}
