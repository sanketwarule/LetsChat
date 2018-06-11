package com.androsys.snkt.letschat.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.androsys.snkt.letschat.R;
import com.androsys.snkt.letschat.chat.ChatMessage;
import com.androsys.snkt.letschat.chat.ChatMessageViewHolder;
import com.androsys.snkt.letschat.chatlist.Chat;
import com.androsys.snkt.letschat.chatlist.ChatListViewHolder;
import com.androsys.snkt.letschat.contactlist.Contact;
import com.androsys.snkt.letschat.contactlist.ContactListViewHolder;

import java.util.List;

public class CustomRecylerViewAdapter extends RecyclerView.Adapter {

    private final static int TYPE_CHAT = 0;
    private final static int TYPE_CONTACT = 1;
    private final static int TYPE_CHAT_MESSAGE = 2;
    private String TAG = getClass().getSimpleName();
    private Layout layout;

    private List<Object> objectList;
    private OnItemClickListener listener;

    public CustomRecylerViewAdapter(List<Object> objectList) {
        this.objectList = objectList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {

            case TYPE_CHAT:
                return new ChatListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item_row, parent, false));

            case TYPE_CONTACT:
                return new ContactListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_row_contact_list, parent, false));

            case TYPE_CHAT_MESSAGE:
                return new ChatMessageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_view, parent, false));

            default:
                return new ChatListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item_row, parent, false));

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = holder.getItemViewType();

        switch (viewType) {
            case TYPE_CHAT:
                Chat chat = (Chat) objectList.get(position);
                ChatListViewHolder holderChatList = (ChatListViewHolder) holder;

                holderChatList.listener = listener;         // for binding the listener from chatlistview holder to adapter

                if (chat.getAvtar() != null) {
                    holderChatList.avtaar.setImageBitmap(chat.getAvtar());
                } else {
                    holderChatList.avtaar.setImageResource(R.mipmap.ic_launcher_round);
                }
                holderChatList.shubhNaam.setText(chat.getShubhNaam());
                holderChatList.msgContent.setText(chat.getMessageContent());
                holderChatList.timeStamp.setText(chat.getTimeStamp());
                holderChatList.unReadMsgCount.setText(chat.getUnReadMsgCount());
                break;

            case TYPE_CONTACT:
                Contact contact = (Contact) objectList.get(position);
                ContactListViewHolder holderContactList = (ContactListViewHolder) holder;

                holderContactList.listener = listener;
                holderContactList.name.setText(contact.getShubhnaam());
                if (contact.getAvtar() == null) {
                    holderContactList.image.setImageResource(R.mipmap.ic_launcher_round);
                }
                break;

            case TYPE_CHAT_MESSAGE:

                ChatMessageViewHolder holderChatMessage = (ChatMessageViewHolder) holder;
                ChatMessage chatMessage = (ChatMessage) this.objectList.get(position);

                // If the message is a received message.
                if (ChatMessage.MSG_TYPE_RECEIVED.equals(chatMessage.getMsgType())) {
                    // Show received message in left linearlayout.
                    holderChatMessage.leftMsgLayout.setVisibility(LinearLayout.VISIBLE);
                    holderChatMessage.leftMsgTextView.setText(chatMessage.getMsgContent());
                    // Remove left linearlayout.The value should be GONE, can not be INVISIBLE
                    // Otherwise each iteview's distance is too big.
                    holderChatMessage.rightMsgLayout.setVisibility(LinearLayout.GONE);
                }
                // If the message is a sent message.
                else if (ChatMessage.MSG_TYPE_SENT.equals(chatMessage.getMsgType())) {
                    // Show sent message in right linearlayout.
                    holderChatMessage.rightMsgLayout.setVisibility(LinearLayout.VISIBLE);
                    holderChatMessage.rightMsgTextView.setText(chatMessage.getMsgContent());
                    // Remove left linearlayout.The value should be GONE, can not be INVISIBLE
                    // Otherwise each iteview's distance is too big.
                    holderChatMessage.leftMsgLayout.setVisibility(LinearLayout.GONE);
                }

                break;

            default:
                Log.d(TAG, "dafault");
                break;
        }

    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (objectList.get(position) instanceof Chat) {
            return TYPE_CHAT;
        } else if (objectList.get(position) instanceof Contact) {
            return TYPE_CONTACT;
        } else if (objectList.get(position) instanceof ChatMessage) {
            return TYPE_CHAT_MESSAGE;
        }
        return TYPE_CHAT;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
