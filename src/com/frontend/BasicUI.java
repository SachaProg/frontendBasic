package com.frontend;

import com.frontend.controller.SaveController;
import com.service.UserManager;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;

public class BasicUI extends VerticalLayout {

    private TextField userTF, passwordTF;
    private UserManager userManager;

    public BasicUI(UserManager userManager){
        this.userManager = userManager;
        init();
    }

    private void init(){
        addComponent(new Label("Hello, world!"));
        addComponent(new Label("Hello, world!" +
                " 1"));
        addComponent(new Label("Hello, world 2!"));

        addComponent(new Label("<hr/>", ContentMode.HTML));

        addComponent(userTF = createUsernameTF());
        addComponent(passwordTF = createPasswordTF());

        addComponent(createSaveButton());
    }

    private TextField createPasswordTF() {
        TextField tf = new PasswordField("Password");
        tf.setRequiredIndicatorVisible(true);
        return tf;
    }

    public TextField getUserTF() {
        return userTF;
    }

    public TextField getPasswordTF() {
        return passwordTF;
    }

    private Component createSaveButton() {
        Button button = new Button("Save");
        button.addClickListener(new SaveController(this, userManager));
        return button;
    }

    private TextField createUsernameTF() {
        TextField tf = new TextField("Username");
        tf.setRequiredIndicatorVisible(true);
        return tf;

    }
}
