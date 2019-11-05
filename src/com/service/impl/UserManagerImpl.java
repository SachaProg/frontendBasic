package com.service.impl;

import com.service.UserManager;
import com.service.dto.User;

public class UserManagerImpl implements UserManager {

    @Override
    public boolean checkUser(User dto) {
        return dto.getUsername().equals(dto.getPassword());
    }
}
