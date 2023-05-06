package com.shada.shada_almansy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Shop1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop1);

        //ImageView img1 = (ImageView) findViewById(R.id.image11);
        ImageView img2 = (ImageView) findViewById(R.id.image22);
        ImageView img3 = (ImageView) findViewById(R.id.image33);
        CardView card1 = (CardView)findViewById(R.id.card12);
        CardView cardchild = (CardView)findViewById(R.id.cardchild);
        CardView cardwom = (CardView)findViewById(R.id.cardwom);
        CardView cardwom2 = (CardView)findViewById(R.id.cardwom2);
        CardView cardkid = (CardView)findViewById(R.id.cardkid);

        cardwom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent xx =new Intent(Shop1.this,Women.class);
                startActivity(xx);
            }
        });
        cardwom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent xx =new Intent(Shop1.this,Women.class);
                startActivity(xx);
            }
        });

        cardchild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent xx =new Intent(Shop1.this,Children.class);
                startActivity(xx);
            }
        });
        cardkid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent xx =new Intent(Shop1.this,Children.class);
                startActivity(xx);
            }
        });

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent xx =new Intent(Shop1.this,mens.class);
                startActivity(xx);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent xx =new Intent(Shop1.this,Children.class);
                startActivity(xx);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent xx =new Intent(Shop1.this,Women.class);
                startActivity(xx);
            }
        });


//        img1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent xx =new Intent(Shop1.this,mens.class);
//                startActivity(xx);
//            }
//        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater n= getMenuInflater();
        n.inflate(R.menu.menu,menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.navwho:

                Intent c =new Intent(Shop1.this,who_we.class);
                startActivity(c);
                return true ;

            case R.id.navusag:

                Intent b =new Intent(Shop1.this,Usag_policy.class);
                startActivity(b);
                return true ;

            case R.id.navexit:
                AlertDialog gg=new AlertDialog.Builder(Shop1.this).create();
                gg.setTitle("Alhaty Store");
                gg.setMessage("Do you want to Exit ?");
                gg.setButton(Dialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gg.cancel();
                    } });
                gg.setButton(Dialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }});
                gg.show();

        }

        return super.onOptionsItemSelected(item);
    }
}