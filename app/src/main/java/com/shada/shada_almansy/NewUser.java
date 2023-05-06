package com.shada.shada_almansy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        Button save =(Button) findViewById(R.id.btnsave);
        final EditText name1= (EditText) findViewById(R.id.textname);
        final EditText id1= (EditText) findViewById(R.id.textid1);
        final  EditText password1= (EditText) findViewById(R.id.textpassword1);

        getdata();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  dbContact da = new dbContact(NewUser.this);
                da.addusers(Integer.parseInt(id1.getText().toString()),name1.getText().toString(),password1.getText().toString());
                Toast.makeText(NewUser.this,"Added successfully",Toast.LENGTH_LONG).show();
            }
        });
    }


    public  void  getdata (){
        dbContact db =new dbContact(NewUser.this);
        Cursor c =db.getdata();
        if(c.getCount() !=0){
           // Toast.makeText(NewUser.this,c.getString(c.getColumnIndex("name")),Toast.LENGTH_LONG).show();
            while ( ! c.isAfterLast())
            {
                Toast.makeText(NewUser.this,c.getString(1),Toast.LENGTH_LONG).show();
                c.moveToNext();
            }
        }
    }


}