package com.loginapp.loginapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Shyam_2 on 12/18/2016.
 */

public class LoginOpenHelper extends SQLiteOpenHelper {

    public static final String LOGCAT = "LOGIN";

    public static final String DATABASE_NAME = "Loin.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_REGISTRATION = "registration";
    public static final String COLUMN_ID = "regid";
    public static final String COLUMN_EMAIL ="email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_MOBILE = "mobile";

    public static final String TABLE_CREATE = "CREATE TABLE "+ TABLE_REGISTRATION + "("+
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_EMAIL + " TEXT, "+
            COLUMN_PASSWORD + " TEXT, "+
            COLUMN_MOBILE + " TEXT"+
            ")";

    public LoginOpenHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_REGISTRATION);
    }
}
