package com.shada.shada_almansy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin1);

        final String idname ="999" ;
        final  String password="123";


        EditText id =(EditText) findViewById(R.id.textid2);
        EditText pass =(EditText) findViewById(R.id.textpassword2);
        Button adm=(Button) findViewById(R.id.btnAdmin);
        adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id.getText().toString().equals(""))
                {
                    id.setError("هذا الحقل مطلوب ");
                    return;

                }
                if(pass.getText().toString().equals(""))
                {
                    pass.setError("هذا الحقل مطلوب ");
                    return;

                }
                if(id.getText().toString().equals(idname) && pass.getText().toString().equals(password))
                {
                    //Toast.makeText(Admin1.this," أهلا وسهلا بك ",Toast.LENGTH_LONG) .show();

                    Intent nn=new Intent(Admin1.this,Admin2.class);
                    startActivity(nn);
                }


                else {
                    Toast.makeText(Admin1.this," محاولة دخول خاطئة ",Toast.LENGTH_LONG) .show();
                }
            }
        });

    }
}