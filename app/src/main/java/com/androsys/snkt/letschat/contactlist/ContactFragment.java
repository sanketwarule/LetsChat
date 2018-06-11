package com.androsys.snkt.letschat.contactlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class ContactFragment extends Fragment implements OnItemClickListener {

    private View view;
    private RecyclerView recyclerViewContact;
//    private ContactListAdapter adapter;

    private CustomRecylerViewAdapter adapter;
    private List<Object> contactList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return view = inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialization(view);
    }

    private void initialization(View view) {
        recyclerViewContact = view.findViewById(R.id.recyclerviewcontactlist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewContact.setLayoutManager(layoutManager);
        recyclerViewContact.setItemAnimator(new DefaultItemAnimator());
        recyclerViewContact.addItemDecoration(new DividerItemDecoration(recyclerViewContact.getContext(), DividerItemDecoration.VERTICAL));
        prepareChatListData();
        adapter = new CustomRecylerViewAdapter(contactList);
        adapter.setOnItemClickListener(this);
        recyclerViewContact.setAdapter(adapter);

    }

    private void prepareChatListData() {
        Contact contact = new Contact(null, "Sanket");
        contactList.add(contact);

        contact = new Contact(null, "Snehaprabha");
        contactList.add(contact);

        contact = new Contact(null, "Ajay");
        contactList.add(contact);

        contact = new Contact(null, "Ganesh");
        contactList.add(contact);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), ((Contact) contactList.get(position)).getShubhnaam(), Toast.LENGTH_SHORT).show();
        Contact contact = (Contact) contactList.get(position);
        Intent intent = new Intent(getActivity(), ChatActivity.class);
        intent.putExtra("contact", contact);
        startActivity(intent);
    }
}
