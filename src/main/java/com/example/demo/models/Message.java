package com.example.demo.models;

public class Message {

    protected boolean status;
    protected String mess;

    public Message(boolean status, String mess) {
        this.status = status;
        this.mess = mess;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
