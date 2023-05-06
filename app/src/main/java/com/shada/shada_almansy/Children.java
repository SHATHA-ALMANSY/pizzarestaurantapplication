package com.shada.shada_almansy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Children extends AppCompatActivity {

    ListView listkids ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);

        listkids = (ListView) findViewById(R.id.list_kids);
        ArrayList<kids> value = new ArrayList<>();

        value.add(new kids("Adidas",70,R.drawable.f28));
        value.add(new kids("Nike",80,R.drawable.f216));
        value.add(new kids("Gucc",120,R.drawable.f24));
        value.add(new kids(" Kids",40,R.drawable.f211));
        value.add(new kids("Sport",90,R.drawable.f21));
        value.add(new kids("Shoes haues",15,R.drawable.f27));
        value.add(new kids("Adidas Mens",70,R.drawable.f214));

        kidAdapter menAdpter = new kidAdapter(this , R.layout.item_kid,value);

        listkids.setAdapter(menAdpter);


        listkids.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String url = "https://api.whatsapp.com/send?phone="+"+972567322105";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });



    }
    }
