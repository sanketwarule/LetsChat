package com.androsys.snkt.letschat.chat;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.androsys.snkt.letschat.R;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerViewChat;
    private EditText typeMsgEt;
    private ImageButton sendMsgBtn;
    private ChatMessageAdapter chatMessageAdapter;
    private List<ChatMessage> msgList = new ArrayList<>();
    private View view;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chat, container, false);
        return view;
    }

    @NonNull
    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        initialization(view);
    }

    private void initialization(View view) {
        recyclerViewChat = view.findViewById(R.id.recyclerviewchat);
        typeMsgEt = view.findViewById(R.id.messageEditText);
        sendMsgBtn = view.findViewById(R.id.send_button);
        sendMsgBtn.setOnClickListener(this);
        chatMessageAdapter = new ChatMessageAdapter(msgList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewChat.setLayoutManager(layoutManager);
        recyclerViewChat.setItemAnimator(new DefaultItemAnimator());

        ChatMessage msgDto = new ChatMessage(ChatMessage.MSG_TYPE_RECEIVED, "hello" , false);
        msgList.add(msgDto);

        recyclerViewChat.setAdapter(chatMessageAdapter);

        // Create the data adapter with above data list.


        // Set data adapter to RecyclerView.


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_button:
                String msgContent = typeMsgEt.getText().toString();
                if (!TextUtils.isEmpty(msgContent)) {
                    // Add a new sent message to the list.
                    ChatMessage msgDto = new ChatMessage(ChatMessage.MSG_TYPE_SENT, msgContent, true);
                    msgList.add(msgDto);

                    int newMsgPosition = msgList.size() - 1;

                    // Notify recycler view insert one new data.
                    chatMessageAdapter.notifyItemInserted(newMsgPosition);
                    // Scroll RecyclerView to the last message.
                    recyclerViewChat.scrollToPosition(newMsgPosition);
                    // Empty the input edit text box.
                    typeMsgEt.setText("");
                }
                break;
        }
    }
}
