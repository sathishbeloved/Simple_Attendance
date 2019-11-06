package com.beloved.attendance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.text.NoCopySpan;
import android.view.View;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DBname = "Students.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "COURSE";
    public static final String COL_4 = "DATE";
    public static final String COL_5 = "ATTENDANCE";



    public DBHelper( Context context) {

        super(context, DBname , null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(   "create table "+TABLE_NAME +"(ID TEXT,NAME text,COURSE text,DATE text,ATTENDANCE TEXT)"     );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insert_data(String idp,String namep, String coursep,String datep, String attendancep){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,idp);
        contentValues.put(COL_2, namep);
        contentValues.put(COL_3, coursep);
        contentValues.put(COL_4,datep);
        contentValues.put(COL_5, attendancep);

        long res = db.insert(TABLE_NAME, null, contentValues);
        if (res == -1)
            return false;
        else
            return true;

    }




    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );
        return res;
    }

    public boolean uplateData(String idp,String namep,String coursep,String datep, String attendancep){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,idp);
        contentValues.put(COL_2, namep);
        contentValues.put(COL_3, coursep);
        contentValues.put(COL_4,datep);
        contentValues.put(COL_5, attendancep);
        db.update(TABLE_NAME,contentValues,"ID = ?",new  String[] {idp});
        return true;
    }


    public int delete_data(String idp){
        SQLiteDatabase db = this.getWritableDatabase();

        int j = db.delete(TABLE_NAME,"ID = ?",new  String[] {idp});
        return j;
    }

}


