package com.frontend.controller;

import com.frontend.BasicUI;
import com.service.PersonManager;
import com.service.dto.Person;
import com.vaadin.ui.Button;

public class SavePersonController implements Button.ClickListener {

    private final BasicUI view;
    private final PersonManager personManager;

    public SavePersonController(BasicUI view, PersonManager personManager) {
        this.view = view;
        this.personManager = personManager;
    }

    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {
        System.out.println("in person click");

        String name = view.getNameTF().getValue();
        String age = view.getAgeTF().getValue();

        System.out.println("name : " + name + ", age : " + age);

        Person person = new Person();
        person.setName(name);
        person.setAge(age);

        personManager.save(person);

    }
}
