package chatbot.admin.controller;

import chatbot.admin.service.AdminService;

import java.util.Map;

public class AddStoreController implements chatbot.main.controller.Controller {

    @Override
    public String process(Map<String, Object> model) {
        AdminService adminService = new AdminService();

        String result = adminService.addStore(model);


        model.put("successMessage", result);
//        model.put("render", render);

        return "addStoreInfoForm";
    }
}
