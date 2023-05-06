package com.shada.shada_almansy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Women extends AppCompatActivity {

    ListView listwomean ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women);

            listwomean = (ListView) findViewById(R.id.list_womean);
//        ImageView imgewom = (ImageView)findViewById(R.id.imagewome) ;
//        imgewom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = "https://api.whatsapp.com/send?phone="+"+972567322105";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });

            ArrayList<wom> values = new ArrayList<>();
            values.add(new wom("Adidas",70,R.drawable.f23));
            values.add(new wom("Nike",70,R.drawable.f26));
            values.add(new wom("Gucc",70,R.drawable.f215));
            values.add(new wom("Sport",70,R.drawable.f215));
            values.add(new wom("Womean",70,R.drawable.f22));
            values.add(new wom("Shoes haues",70,R.drawable.f212));
            values.add(new wom("Adidas Mens",70,R.drawable.f213));
            values.add(new wom("Adidas Mens",70,R.drawable.f26));
//            values.add(new wom("Adidas Mens",70,R.drawable.w10));
//            values.add(new wom("Adidas Mens",70,R.drawable.w12));
//            values.add(new wom("Adidas Mens",70,R.drawable.w11));
//            values.add(new wom("Adidas Mens",70,R.drawable.w9));
//            values.add(new wom("Adidas Mens",70,R.drawable.w13));


            womAdapter menAdpter = new womAdapter(this , R.layout.item_womean,values);

            listwomean.setAdapter(menAdpter);

            listwomean.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
