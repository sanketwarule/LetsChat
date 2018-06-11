package com.androsys.snkt.letschat.chat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androsys.snkt.letschat.R;

public class ChatMessageViewHolder extends RecyclerView.ViewHolder {

    public TextView rightMsgTextView , leftMsgTextView;
    public LinearLayout leftMsgLayout , rightMsgLayout;

    public ChatMessageViewHolder(View itemView) {
        super(itemView);

        if(itemView!=null) {
            leftMsgLayout = itemView.findViewById(R.id.chat_left_msg_layout);
            rightMsgLayout = itemView.findViewById(R.id.chat_right_msg_layout);
            leftMsgTextView = itemView.findViewById(R.id.chat_left_msg_text_view);
            rightMsgTextView = itemView.findViewById(R.id.chat_right_msg_text_view);
        }
    }
}
