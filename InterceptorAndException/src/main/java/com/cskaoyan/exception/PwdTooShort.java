package com.cskaoyan.exception;

public class PwdTooShort extends Exception {
    String userMsg;
    public PwdTooShort(String message,String userMsg){
        super(message);
        this.userMsg=userMsg;
    }

    public String getUserMsg() {
        return userMsg;
    }

    public void setUserMsg(String userMsg) {
        this.userMsg = userMsg;
    }
}
