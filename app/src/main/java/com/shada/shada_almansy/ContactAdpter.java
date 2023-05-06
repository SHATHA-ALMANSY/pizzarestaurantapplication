package com.shada.shada_almansy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ContactAdpter extends ArrayAdapter<Contact> {
    Context cntext;
    int resource;
    public ContactAdpter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.cntext=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(cntext).inflate(resource,parent,false);
        TextView tvName=(TextView) convertView.findViewById(R.id.tvname);
        TextView tvPrice=(TextView) convertView.findViewById(R.id.tvprice);

        Contact currentContact = getItem(position);
        tvName.setText(currentContact.getName());
        tvPrice.setText(String.valueOf( currentContact.getPrice()));

        return convertView;
    }
}
