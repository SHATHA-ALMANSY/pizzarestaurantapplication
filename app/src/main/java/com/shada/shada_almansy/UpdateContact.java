package com.shada.shada_almansy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Currency;

public class UpdateContact extends AppCompatActivity {
    //   واجهة التحديث Uppdate هذه الواجهة عندما نضغط في اللست فيو على صنف تظهر لنا واجهة التحديث ويظهر لنا معلومات الصنف
    EditText t1,t2;
    int itemid;
    String Name;
    int Price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);
        Button update = (Button)findViewById(R.id.btnUpdate);
        t1=(EditText)findViewById(R.id.editName);
        t2=(EditText)findViewById(R.id.editPrice);

        Bundle bb=getIntent().getExtras();
         itemid=bb.getInt("ffd");

         dbContact c=new dbContact(UpdateContact.this);
        Cursor x=c.getshoesbyid(itemid);
        if (x.getCount() !=0)
        {
            t1.setText(x.getString(1));
            t2.setText(x.getString(2));
          //  Toast.makeText(UpdateContact.this,x.getString(1),Toast.LENGTH_LONG).show();

        }
      //  Toast.makeText(UpdateContact.this,itemid+"",Toast.LENGTH_LONG).show();
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbContact vv = new dbContact(UpdateContact.this);
                vv.updateshose(itemid,Name,Price);
            }
        });




        //
    }
    // بدنا نستدعي دالة القائمة مشان تظهر القائمة على واجهة التحديث للمدير

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // لتظهر القائمة نستدم الدوال الاتية :_

        getMenuInflater().inflate(R.menu.deletemenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    // هذة الدالة لعرض القائمة

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_delete:
      // هاي الدالة لتأكيد الحذف
                showAlert();

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlert() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Confirmation");
        alertBuilder.setMessage("Are You Sure ?");
        alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                dbContact db =new dbContact(UpdateContact.this);
                db.deleteShose(itemid);
        //  -----------------------------                  db.deleteShose();
            }
        });
        alertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        AlertDialog dialog= alertBuilder.create();
        //لاظهار الرسالة
        dialog.show();
    }

}