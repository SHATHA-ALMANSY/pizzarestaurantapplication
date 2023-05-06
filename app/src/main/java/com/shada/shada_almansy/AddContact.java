package com.shada.shada_almansy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class AddContact extends AppCompatActivity {

  EditText editName , editPrice;
  Button btnConfirm;
  ImageView imgAdd ;
//  Button imagebutton ;
//  int requestcode_camera = 100 ;
  // قمنا بتعريفها للقيام من خلالها بتمرير البيانات عند الضغط على الزر
  dbContact db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        editName=(EditText) findViewById(R.id.editName);
        editPrice=(EditText) findViewById(R.id.editPrice);
        btnConfirm=(Button) findViewById(R.id.btnConfirm);
        imgAdd = (ImageView)findViewById(R.id.imgadd);

//        if(ContextCompat.checkSelfPermission(AddContact.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
//
//            ActivityCompat.requestPermissions(AddContact.this,new String[]{
//                    Manifest.permission.CAMERA
//            },requestcode_camera);
//        }

        db=new dbContact(AddContact.this);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                int price =Integer.parseInt(editPrice.getText().toString());

                db.addshoes(name,price);
                Toast.makeText(AddContact.this,"تمت الاضافة بنجاح",Toast.LENGTH_LONG).show();
            }
        });

//        imagebutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent obj = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(obj,requestcode_camera);
//            }
//        });




    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//
//        if(requestCode==requestcode_camera){
//            Bitmap img = (Bitmap)data.getExtras().get("data");
//            imgAdd.setImageBitmap(img);
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
}