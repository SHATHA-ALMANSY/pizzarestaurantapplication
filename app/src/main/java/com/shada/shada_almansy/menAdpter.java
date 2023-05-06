package com.shada.shada_almansy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class menAdpter extends ArrayAdapter {

    Context context;
    int resource;
    public menAdpter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(resource,parent , false);
        TextView avname = (TextView) convertView.findViewById(R.id.avname);
        TextView avprice2 = (TextView) convertView.findViewById(R.id.avprice2);
        ImageView img2= (ImageView) convertView.findViewById(R.id.img2);

        men currentmen = (men) getItem(position);
        avname.setText(currentmen.getName());
        avprice2.setText(String.valueOf(currentmen.getPrice()));
        img2.setImageResource(currentmen.getPic());


        return convertView;
    }
}
