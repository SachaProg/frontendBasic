package com.frontend.controller;

import com.frontend.BasicUI;
import com.service.UserManager;
import com.service.dto.User;
import com.vaadin.ui.Button;

public class SaveController implements Button.ClickListener {

    private final BasicUI basicUI;
    private UserManager userManager;

    public SaveController(BasicUI basicUI, UserManager userManager) {
        this.basicUI = basicUI;
        this.userManager = userManager;
    }

    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {
        System.out.println(clickEvent);
        System.out.println(basicUI.getUserTF().getValue());
        System.out.println(basicUI.getPasswordTF().getValue());

        User dto = new User();
        dto.setUsername(basicUI.getUserTF().getValue());
        dto.setPassword(basicUI.getPasswordTF().getValue());

        userManager.checkUser(dto);
    }
}
