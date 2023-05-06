package com.shada.shada_almansy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Admin2 extends AppCompatActivity {
    ListView ContactAdmin;
    Button btnAdd ;
      /// لاستدعاء لكلاس يءجب علينا تعريفه
    dbContact db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);
        ContactAdmin = (ListView) findViewById(R.id.ContactAdmin);
        btnAdd=(Button) findViewById(R.id.btnAdd);

        db=new dbContact(Admin2.this);


        ArrayList<Contact> contacts=new ArrayList<Contact>();

        Cursor x=db.getshoes();
        if (x.getCount()!=0)
        {
            while (! x.isAfterLast()) {
                contacts.add(new Contact(x.getString(1), x.getInt(2),x.getInt(0)));
            x.moveToNext();
            }
        }
      /* contacts.add(new Contact("Adidass",70));
        contacts.add(new Contact("Shose",120));
        contacts.add(new Contact("Naike",90));
        contacts.add(new Contact("Adidass",70));
        contacts.add(new Contact("Adidass",70));
        contacts.add(new Contact("Adidass",70));
        contacts.add(new Contact("Adidass",70));*/
// اتصال على ملف الكونتاكت ادبتر مشان تظهر قائمة اللست فيو
       // ContactAdpter contactAdpter=new ContactAdpter(this,R.layout.item_admin,contacts);
      //  ContactAdmin.setAdapter(contactAdpter);
        shadha adp=new shadha(contacts);

        ContactAdmin.setAdapter(adp);
       //  حدث للزر عن الانتقال لواجهة المدير التي تضيف الاصناف
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Admin2.this,AddContact.class);
                startActivity(intent);
            }
        });
        // لتحويلها الى واجهة التحديث


    }


    public  class shadha extends BaseAdapter{

        ArrayList<Contact>cc=new ArrayList<Contact>();

        public shadha (ArrayList<Contact> ff){
            this.cc=ff;
        }



        @Override
        public int getCount() {
            return cc.size();
        }

        @Override
        public Object getItem(int position) {
            return cc.get(position).Name;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inf=getLayoutInflater();
            View v=inf.inflate(R.layout.item_admin,null);
            TextView t1=(TextView)v. findViewById(R.id.tvname);
            TextView t2=(TextView)v. findViewById(R.id.tvprice);
            t1.setText(cc.get(position).Name);
            t2.setText(cc.get(position).Price+"");
            LinearLayout xx=(LinearLayout) v.findViewById(R.id.linearshazha);
            xx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent xxx=new Intent(Admin2.this,UpdateContact.class);
                    Bundle b=new Bundle();
                    b.putInt("ffd",cc.get(position).id);
                    xxx.putExtras(b);
                    startActivity(xxx);
                }
            });


            return v;
        }
    }

}