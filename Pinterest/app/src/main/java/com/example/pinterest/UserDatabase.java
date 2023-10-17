package com.example.pinterest;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UserDatabase extends SQLiteOpenHelper {
    public static final String DatabaseName="app.db";
    public UserDatabase(Context con) {
        super(con,DatabaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user (username TEXT , email TEXT , phonenumber INTEGER , password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user ");
        onCreate(db);
    }
    public String instertData(String n1,String n2,String n3,String n4){
        SQLiteDatabase s=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("username",n1);
        values.put("email",n2);
        values.put("phonenumber",n3);
        values.put("password",n4);
        long re=s.insert("user",null,values);
        if (re==-1)
            return "Something Went Wrong";
        else {
            return "Successfully Registered";
        }
    }
    public ArrayList<User> getData(){
        ArrayList<User> arrayList=new ArrayList<User>();
        SQLiteDatabase s=this.getReadableDatabase();
        Cursor c=s.rawQuery("select * from User",null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            arrayList.add(new User(
                    c.getString(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3)
            ));
            c.moveToNext();
        }
        return arrayList;
    }
}