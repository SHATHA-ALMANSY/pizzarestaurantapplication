package com.shada.shada_almansy;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dbContact extends SQLiteOpenHelper {
    private static final String DB_NAME = "shadha.db";
    private static final int DB_VERSION = 1;


    public dbContact(Context context) { //CONSTRNCTION

        super(context, DB_NAME, null, DB_VERSION);
    }
      // يوجد ميثود اتنين للقاعدة البيانات
    @Override
    public void onCreate(SQLiteDatabase db) { // انشاء

        db.execSQL("create table if not exists shoes (id INTEGER primary key autoincrement ,name TEXT,price INTEGER )");
        db.execSQL("Create table if not exists users ( id INTEGER primary key , name TEXT , password TEXT)");
        db.execSQL("create Table if not Exists AdminCat1 (idcat1 INTEGER primary key ,Cat1name TEXT)");
        db.execSQL("create Table if not Exists items (iditem INTEGER primary key ,itemname TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists shoes");
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if Exists AdminCat1");
        db.execSQL("drop table if Exists items");

    }
    public void addusers (int id , String name ,String password){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues va = new ContentValues();
        va.put("id",id);
        va.put("name",name);
        va.put("password",password);
        db.insert("users",null,va);
        db.close();
    }

    public Cursor getdata (){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from users",null);
        cr.moveToFirst();
        return cr;
    }
    public boolean isvalid(int id, String password) {
        SQLiteDatabase bv = this.getReadableDatabase();
        Cursor cr = bv.rawQuery("select * from users where id=" + id + " and password='" + password + "' ", null);
        cr.moveToFirst();
        if (cr.getCount() != 0) {
            return true;
        } else {
            return false;
        }
    }



    public  void addshoes (String name ,int price)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("price",price);
        db.insert("shoes",null,cv);
        db.close();
    }



           public Cursor getshoes(){

            SQLiteDatabase db= this.getReadableDatabase();
             Cursor x=db.rawQuery("select * from shoes",null);
               x.moveToFirst();
               return  x;
               }

               public  Cursor getshoesbyid(int i)
               {
                   SQLiteDatabase db= this.getReadableDatabase();
                   Cursor x=db.rawQuery("select * from shoes where id="+i,null);
                   x.moveToFirst();
                   return  x;
               }


     public void deleteShose (int i){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("delete from shoes where id="+i);

     }

     public void  updateshose (int y, String name ,int price){
         SQLiteDatabase db =this.getWritableDatabase();
         db.execSQL("Update shoes set name="+name+", price ="+price+" where id="+y);
     }



    public void AddAdminCat1(int idcat1 ,String Cat1name){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues va =new ContentValues();
        va.put("idcat1",idcat1);
        va.put("Cat1name",Cat1name);
        db.insert("AdminCat1",null,va);
        db.close();
    }
    public Cursor getdataAdminCat1(){
        SQLiteDatabase bv =this.getReadableDatabase();
        Cursor cr =bv.rawQuery("select * from AdminCat1",null);
        cr.moveToFirst();
        return cr;
    }

    public boolean isvalidCat1name(int idcat1 ,String Cat1name){
        SQLiteDatabase bv =this.getReadableDatabase();
        Cursor cr =bv.rawQuery("select * from AdminCat1 where idcat1="+idcat1+" and Cat1name='"+Cat1name+"' ",null);
        cr.moveToFirst();
        if(cr.getCount() !=0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public void Additems(int iditem ,String itemname){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues va =new ContentValues();
        va.put("iditem",iditem);
        va.put("itemname",itemname);
        db.insert("items",null,va);
        db.close();
    }
    public Cursor getdataitems(){
        SQLiteDatabase bv =this.getReadableDatabase();
        Cursor cr =bv.rawQuery("select * from items",null);
        cr.moveToFirst();
        return cr;
    }

    public boolean isvaliditems(int iditem ,String itemname){
        SQLiteDatabase bv =this.getReadableDatabase();
        Cursor cr =bv.rawQuery("select * from items where iditem="+iditem+" and itemname='"+itemname+"' ",null);
        cr.moveToFirst();
        if(cr.getCount() !=0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }


    @SuppressLint("Range")
    public void Add_AdminCat1 (String Cat1name )
    {
        int maxid=0;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor u=db.rawQuery("select IFNULL (max (idcat1),0) as idc from AdminCat1  ",null);

        if (u.getCount()!=0)
        {
            u.moveToFirst();
            maxid=Integer.parseInt(u.getString(u.getColumnIndex("idc")));
        }


        u.close();
        SQLiteDatabase b=this.getWritableDatabase();
        ContentValues v=new ContentValues();
        v.put("idcat1",maxid+1);
        v.put("Cat1name",Cat1name);

        b.insert("AdminCat1  ",null,v);
        b.close();
    }

    @SuppressLint("Range")
    public void Add_items (String itemname )
    {
        int maxid=0;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor u=db.rawQuery("select IFNULL (max (iditem),0) as idm from items ",null);

        if (u.getCount()!=0)
        {
            u.moveToFirst();
            maxid=Integer.parseInt(u.getString(u.getColumnIndex("idm")));
        }


        u.close();
        SQLiteDatabase b=this.getWritableDatabase();
        ContentValues v=new ContentValues();
        v.put("id",maxid+1);
        v.put("itemname",itemname);

        b.insert("items ",null,v);
        b.close();
    }

}