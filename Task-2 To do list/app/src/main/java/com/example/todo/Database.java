package com.example.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String databaseName = "signuplogic.db";
    public Database(@Nullable Context context) {
        super(context,"signuplogic.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(email Text primary key,password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }
    public Boolean insertData(String email,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result = db.insert("users",null,contentValues);

        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean Email(String email){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from users where email=?",new String[]{email});

        if(cursor.getCount() >0){
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean Check(String email,String password){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from users where email=? and password=?",new String[]{email,password});

        if(cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }

}
