package com.androsys.snkt.letschat.chat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.androsys.snkt.letschat.R;

import java.util.ArrayList;
import java.util.List;

public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageViewHolder> {

    private List<ChatMessage> msgTextList = null;

    public ChatMessageAdapter(List<ChatMessage> msgTextList){
        this.msgTextList = msgTextList;
    }
    @NonNull
    @Override
    public ChatMessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatMessageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatMessageViewHolder holder, int position) {
        ChatMessage msgDto = this.msgTextList.get(position);
        // If the message is a received message.
        if (ChatMessage.MSG_TYPE_RECEIVED.equals(msgDto.getMsgType()))
        {
            // Show received message in left linearlayout.
            holder.leftMsgLayout.setVisibility(LinearLayout.VISIBLE);
            holder.leftMsgTextView.setText(msgDto.getMsgContent());
            // Remove left linearlayout.The value should be GONE, can not be INVISIBLE
            // Otherwise each iteview's distance is too big.
            holder.rightMsgLayout.setVisibility(LinearLayout.GONE);
        }
        // If the message is a sent message.
        else if (ChatMessage.MSG_TYPE_SENT.equals(msgDto.getMsgType()))
        {
            // Show sent message in right linearlayout.
            holder.rightMsgLayout.setVisibility(LinearLayout.VISIBLE);
            holder.rightMsgTextView.setText(msgDto.getMsgContent());
            // Remove left linearlayout.The value should be GONE, can not be INVISIBLE
            // Otherwise each iteview's distance is too big.
            holder.leftMsgLayout.setVisibility(LinearLayout.GONE);
        }
    }

    @Override
    public int getItemCount() {
        if(msgTextList==null)
        {
            msgTextList = new ArrayList<ChatMessage>();
        }
        return msgTextList.size();
    }

   /* public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView rightMsgTextView , leftMsgTextView;
        public LinearLayout leftMsgLayout , rightMsgLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            rightMsgTextView = itemView.findViewById(R.id.chat_right_msg_text_view);
            leftMsgTextView = itemView.findViewById(R.id.chat_left_msg_text_view);
            leftMsgLayout = itemView.findViewById(R.id.chat_left_msg_layout);
            rightMsgLayout = itemView.findViewById(R.id.chat_right_msg_layout);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
//            if (listener != null)
//                listener.onItemClick(v , getAdapterPosition());
        }
    } */
}
