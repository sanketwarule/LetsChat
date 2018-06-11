package com.androsys.snkt.letschat.contactlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.androsys.snkt.letschat.R;
import com.androsys.snkt.letschat.app.OnItemClickListener;

import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListViewHolder> {

    private List<Contact> contactList;
    private OnItemClickListener listener;

    public ContactListAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_row_contact_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactListViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.listener = listener;
        holder.name.setText(contact.getShubhnaam());
        if (contact.getAvtar() == null) {
            holder.image.setImageResource(R.mipmap.ic_launcher_round);
        }
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
