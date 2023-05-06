package com.shada.shada_almansy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class mens extends AppCompatActivity {
      ListView list_meeen ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens);

        list_meeen = (ListView) findViewById(R.id.list_meeen);
        ArrayList<men> values = new ArrayList<>();
        values.add(new men("Adidas Mens",70,R.drawable.men3));
        values.add(new men("Sport Mens",50,R.drawable.men2));
        values.add(new men("Nice Mens",90,R.drawable.men4));
        values.add(new men("Nice Mens",90,R.drawable.men1));
        values.add(new men("Nice Mens",90,R.drawable.men4));
        values.add(new men("Nice Mens",90,R.drawable.men5));
        values.add(new men("Nice Mens",90,R.drawable.men14));
        values.add(new men("Nice Mens",90,R.drawable.men13));
        values.add(new men("Nice Mens",90,R.drawable.lo));
        values.add(new men("Nice Mens",90,R.drawable.lb));
        values.add(new men("Nice Mens",90,R.drawable.ll));
        values.add(new men("Nice Mens",90,R.drawable.kk));
        values.add(new men("Nice Mens",90,R.drawable.men2));
        values.add(new men("Nice Mens",90,R.drawable.men13));
        values.add(new men("Nice Mens",90,R.drawable.men14));


        menAdpter adpter =new menAdpter(this,R.layout.item_men,values);
        list_meeen.setAdapter(adpter);

        list_meeen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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