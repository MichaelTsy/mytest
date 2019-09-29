package com.cskaoyan.service;

import com.cskaoyan.bean.User;
import com.cskaoyan.exception.AccountTooShort;
import com.cskaoyan.exception.PwdTooShort;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements MyService{
    public boolean register(User user) {
        //暂时不与Dao层交互
        return true;
    }

    public boolean login(User user) throws AccountTooShort, PwdTooShort {

        if(user.getEmail().length()<5) throw new AccountTooShort("异常了","账户过短");
        if(user.getPassword().length()<5) throw new PwdTooShort("异常了","密码过短");
        //暂时不与Dao层交互
        if(!"admin".equals(user.getEmail())||!"admin".equals(user.getPassword())) {
            //将user对象的字段置空，这样在controller层加入session的user实例的eamil字段为空，可以被interceptor挡获
            user.setEmail(null);
            user.setPassword(null);
            return false;
        }
        return true;
    }
}
