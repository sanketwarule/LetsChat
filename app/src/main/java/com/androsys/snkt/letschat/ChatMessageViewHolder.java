package com.androsys.snkt.letschat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChatMessageViewHolder extends RecyclerView.ViewHolder {

    public TextView rightMsgTextView , leftMsgTextView;
    public LinearLayout leftMsgLayout , rightMsgLayout;

    public ChatMessageViewHolder(View itemView) {
        super(itemView);

        if(itemView!=null) {
            leftMsgLayout = (LinearLayout) itemView.findViewById(R.id.chat_left_msg_layout);
            rightMsgLayout = (LinearLayout) itemView.findViewById(R.id.chat_right_msg_layout);
            leftMsgTextView = (TextView) itemView.findViewById(R.id.chat_left_msg_text_view);
            rightMsgTextView = (TextView) itemView.findViewById(R.id.chat_right_msg_text_view);
        }
    }
}
