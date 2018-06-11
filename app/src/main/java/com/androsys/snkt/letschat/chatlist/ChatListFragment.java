package com.androsys.snkt.letschat.chatlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androsys.snkt.letschat.R;
import com.androsys.snkt.letschat.app.CustomRecylerViewAdapter;
import com.androsys.snkt.letschat.app.OnItemClickListener;
import com.androsys.snkt.letschat.chat.ChatActivity;

import java.util.ArrayList;
import java.util.List;

public class ChatListFragment extends Fragment implements OnItemClickListener {

    private View view;
    private RecyclerView recyclerView;
    private List<Object> chatList = new ArrayList();
//    private CustomAdapterRecycler adapterRecycler;

    private CustomRecylerViewAdapter adapterRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return view = inflater.inflate(R.layout.fragment_chat_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialization(view);
    }

    private void initialization(View view) {
        recyclerView = view.findViewById(R.id.recyclerviewchatlist);
//        adapterRecycler = new CustomAdapterRecycler(chatList);

        adapterRecycler = new CustomRecylerViewAdapter(chatList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterRecycler);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        prepareChatListData();
        adapterRecycler.setOnItemClickListener(this);
    }

    private void prepareChatListData() {

        Chat chat = new Chat(null,"Sanket","Hiii","5:56 pm","1");
        chatList.add(chat);

        chat = new Chat(null,"Snehaprabha","Hiii sanket","5:59 pm","1");
        chatList.add(chat);

        chat = new Chat(null,"Ajay","what?","6:06 pm","1");
        chatList.add(chat);

        chat = new Chat(null,"Ganesh","what About u?","6:00 pm","1");
        chatList.add(chat);

        chat = new Chat(null,"Vikas","heyyyy","6:16 pm","1");
        chatList.add(chat);

        chat = new Chat(null,"Dipali","hello","6:02 pm","1");
        chatList.add(chat);

        chat = new Chat(null,"Bharat","nothing","7:56 pm","1");
        chatList.add(chat);

        chat = new Chat(null,"Tanmay","kasa ahes","7:06 pm","1");
        chatList.add(chat);

        chat = new Chat(null,"Bhushan","Hiii there","7:36 pm","1");
        chatList.add(chat);

        adapterRecycler.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(View view, int position) {
        Log.d("chatfrag "," view : "+view.getId()+" position : "+position);
        Chat chat = (Chat) chatList.get(position);
        Toast.makeText(getActivity() , chat.getShubhNaam() , Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getActivity(), ChatActivity.class);
        intent.putExtra("chat", chat);
        startActivity(intent);

    }
}
