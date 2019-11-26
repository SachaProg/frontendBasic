package com;

import com.frontend.BasicUI;
import com.service.impl.PersonManagerImpl;
import com.service.impl.UserManagerImpl;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

public class MyVaadinApplication extends UI {

    @Override
    public void init(VaadinRequest request) {

        setContent(new BasicUI(new UserManagerImpl(), new PersonManagerImpl()));
    }

}
