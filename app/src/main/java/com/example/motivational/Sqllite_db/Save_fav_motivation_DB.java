package com.example.motivational.Sqllite_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Save_fav_motivation_DB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "fav_List.db";
    private static final String TABLE_NAME = "fav_list_table";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "Fav_image_id";


    public Save_fav_motivation_DB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT,Fav_image_id TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String fav_motivation) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, fav_motivation);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("SELECT * FROM " +TABLE_NAME,null);
        return res;
    }

    public int deleteData(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int no=sqLiteDatabase.delete(TABLE_NAME,"Fav_image_id=?",new String[] {id});
        return no;
    }
}
