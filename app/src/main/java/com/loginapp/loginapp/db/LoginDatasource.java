package com.loginapp.loginapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.loginapp.loginapp.model.Registration;

/**
 * Created by Shyam_2 on 12/18/2016.
 */

public class LoginDatasource {

    SQLiteOpenHelper dbhelper;
    SQLiteDatabase database;

    public LoginDatasource(Context context){
        dbhelper = new LoginOpenHelper(context);
    }

    public void open(){
        database = dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    //Insert the data into Registration table

    public Registration create(Registration registration){
        ContentValues values = new ContentValues();
        values.put(LoginOpenHelper.COLUMN_EMAIL,registration.getEmail());
        values.put(LoginOpenHelper.COLUMN_PASSWORD,registration.getPassword());
        values.put(LoginOpenHelper.COLUMN_MOBILE,registration.getMobile());

        long insertId = database.insert(LoginOpenHelper.TABLE_REGISTRATION,null,values);
        registration.setRegId(insertId);
        return registration;
    }

    public boolean checkLogin(String uname, String pwd){
        boolean loggedIn = false;
        String query = "SELECT * FROM "+LoginOpenHelper.TABLE_REGISTRATION +" where email==\""+uname + "\" and password==\""+pwd+"\"";
        Cursor cursor = database.rawQuery(query,null);

        if(cursor.getCount()>0){
            loggedIn = true;
        }

        return loggedIn;
    }
}
