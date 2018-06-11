package com.androsys.snkt.letschat.chatlist;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Chat implements Serializable {

    private Bitmap avtar;
    private String shubhNaam;
    private String messageContent;
    private String timeStamp;
    private String unReadMsgCount;

    public Chat(){}

    public Chat(Bitmap avtar, String shubhNaam, String messageContent, String timeStamp, String unReadMsgCount) {
        this.avtar = avtar;
        this.shubhNaam = shubhNaam;
        this.messageContent = messageContent;
        this.timeStamp = timeStamp;
        this.unReadMsgCount = unReadMsgCount;
    }

    public Bitmap getAvtar() {
        return avtar;
    }

    public void setAvtar(Bitmap avtar) {
        this.avtar = avtar;
    }

    public String getShubhNaam() {
        return shubhNaam;
    }

    public void setShubhNaam(String shubhNaam) {
        this.shubhNaam = shubhNaam;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUnReadMsgCount() {
        return unReadMsgCount;
    }

    public void setUnReadMsgCount(String unReadMsgCount) {
        this.unReadMsgCount = unReadMsgCount;
    }
}
