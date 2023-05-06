package com.shada.shada_almansy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        EditText id2= (EditText) findViewById(R.id.textid2);
        EditText password2= (EditText) findViewById(R.id.textpassword2);
        Button login =(Button) findViewById(R.id.btnlogin);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Intent c=new Intent(LogIn.this,Shop1.class);
//                startActivity(c);


             /*   if(id2.getText().toString().equals(""))
                {
                    id2.setError("هذا الحقل مطلوب ");
                    return;

                }
                if(password2.getText().toString().equals(""))
                {
                    password2.setError("هذا الحقل مطلوب ");
                    return;

                }
               dbContact bb=new dbContact(LogIn.this);
               if( bb.isvalid(Integer.parseInt(id2.getText().toString()),password2.getText().toString())==true){
                   Intent c=new Intent(LogIn.this,Shop1.class);
                   startActivity(c);
               }
               else{
                    Toast.makeText(LogIn.this,"الرجاء التأكد من رقم الهوية وكلمة المرور",Toast.LENGTH_LONG).show();
               }*/
//
//            }
//        });
    }
}