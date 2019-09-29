package com.cskaoyan.service;

import com.cskaoyan.bean.User;
import com.cskaoyan.exception.AccountTooShort;
import com.cskaoyan.exception.PwdTooShort;

public interface MyService {
    boolean register(User user);

    boolean login(User user) throws AccountTooShort, PwdTooShort;
}
