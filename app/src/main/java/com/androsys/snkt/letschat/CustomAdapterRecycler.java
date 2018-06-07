package com.androsys.snkt.letschat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androsys.snkt.letschat.model.Chat;

import java.util.List;

public class CustomAdapterRecycler extends RecyclerView.Adapter<CustomAdapterRecycler.MyViewHolder> {

    private List<Chat> chatList;
    private OnItemClickListener listener;

    public CustomAdapterRecycler(List<Chat> chatList) {
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item_row , parent , false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Chat chat = chatList.get(position);

        if (chat.getAvtar() != null){
            holder.avtaar.setImageBitmap(chat.getAvtar());
        }
        else {
            holder.avtaar.setImageResource(R.mipmap.ic_launcher_round);
        }
        holder.shubhNaam.setText(chat.getShubhNaam());
        holder.msgContent.setText(chat.getMessageContent());
        holder.timeStamp.setText(chat.getTimeStamp());
        holder.unReadMsgCount.setText(chat.getUnReadMsgCount());

    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView shubhNaam , timeStamp , msgContent , unReadMsgCount;
        public ImageView avtaar;

        public MyViewHolder(View itemView) {
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
            listener.onItemClick(v , getAdapterPosition());
        }
    }


}
