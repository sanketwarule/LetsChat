package com.androsys.snkt.letschat.model;

public class ChatMessage {
    public final static String MSG_TYPE_SENT = "MSG_TYPE_SENT";

    public final static String MSG_TYPE_RECEIVED = "MSG_TYPE_RECEIVED";

    // Message content.
    private String msgContent;

    // Message type.
    private String msgType;

    private boolean myMessage;

    public ChatMessage(String msgType, String msgContent , boolean myMessage) {
        this.msgType = msgType;
        this.msgContent = msgContent;
        this.myMessage = myMessage;
    }

    public boolean getMyMessage(){
        return myMessage;
    }

    public void setMyMessage(boolean myMessage){
        this.myMessage = myMessage;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
