package com.service.impl;

import com.service.PersonManager;
import com.service.dto.Person;

import java.util.Observable;

public class PersonManagerImpl extends Observable implements PersonManager {
    @Override
    public void save(Person person) {
        System.out.println("in save : " + person.getName());
        setChanged();
        notifyObservers();
    }
}
