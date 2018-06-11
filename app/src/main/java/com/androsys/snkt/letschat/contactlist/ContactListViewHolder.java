package com.androsys.snkt.letschat.contactlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androsys.snkt.letschat.R;
import com.androsys.snkt.letschat.app.OnItemClickListener;

public class ContactListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView name;
    public ImageView image;
    public OnItemClickListener listener;

    public ContactListViewHolder(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.contactNameTV);
        image = itemView.findViewById(R.id.contactImage);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onItemClick(v, getAdapterPosition());
        }
    }
}
