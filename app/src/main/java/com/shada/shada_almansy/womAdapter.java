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

import java.util.ArrayList;

public class womAdapter extends ArrayAdapter<wom> {


    Context context ;
    int resource ;
    public womAdapter(@NonNull Context context, int resource, @NonNull ArrayList<wom> objects) {
        super(context, resource, objects);
        this.context=context ;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(resource , parent ,false);

        TextView tvname = (TextView) convertView.findViewById(R.id.tvname);
        TextView tvprice = (TextView) convertView.findViewById(R.id.tvprice);
        ImageView img = (ImageView) convertView.findViewById(R.id.img);

        wom currentmens = getItem(position);

        tvname.setText(currentmens.getName());
        tvprice.setText(String.valueOf(currentmens.getPrice() ));
        img.setImageResource(currentmens.getPic());



        return convertView;
    }
}
