package com.androsys.snkt.letschat.chatlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androsys.snkt.letschat.R;
import com.androsys.snkt.letschat.app.OnItemClickListener;

public class ChatListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public OnItemClickListener listener;
    public TextView shubhNaam, timeStamp, msgContent, unReadMsgCount;
    public ImageView avtaar;

    public ChatListViewHolder(View itemView) {
        super(itemView);
        shubhNaam = itemView.findViewById(R.id.shubhnaamChatListTv);
        avtaar = itemView.findViewById(R.id.avtarchatlistlist);
        timeStamp = itemView.findViewById(R.id.timestampChatListTv);
        msgContent = itemView.findViewById(R.id.messageContentChatListTv);
        unReadMsgCount = itemView.findViewById(R.id.textView5);

        itemView.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (listener != null)
            listener.onItemClick(v, getAdapterPosition());
    }
}
