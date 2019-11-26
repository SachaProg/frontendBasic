package com.frontend;

import com.frontend.controller.SaveController;
import com.frontend.controller.SavePersonController;
import com.service.PersonManager;
import com.service.UserManager;
import com.service.impl.PersonManagerImpl;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;

import java.util.Observable;
import java.util.Observer;

public class BasicUI extends VerticalLayout implements Observer {

    private final PersonManager personManager;
    private TextField userTF, passwordTF, nameTF, ageTF;
    private UserManager userManager;

    public BasicUI(UserManager userManager, PersonManager personManager){
        this.userManager = userManager;
        this.personManager = personManager;
        ((PersonManagerImpl)personManager).addObserver(this);
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
        addComponent(new Label("<hr/>", ContentMode.HTML));

        addComponent(nameTF = createNameTF());
        addComponent(ageTF = createAgeTF());
        addComponent(createSavePersonButton());
    }

    private Component createSavePersonButton() {
        Button button = new Button("Save Person");
        button.addClickListener(new SavePersonController(this, personManager));
        return button;
    }

    private TextField createNameTF() {
        return new TextField("Name");
    }

    private TextField createAgeTF() {
        return new TextField("Age");
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

    public TextField getNameTF() {
        return nameTF;
    }

    public void setNameTF(TextField nameTF) {
        this.nameTF = nameTF;
    }

    public TextField getAgeTF() {
        return ageTF;
    }

    public void setAgeTF(TextField ageTF) {
        this.ageTF = ageTF;
    }

    @Override
    public void update(Observable o, Object arg) {
        nameTF.clear();
        ageTF.clear();
    }
}
