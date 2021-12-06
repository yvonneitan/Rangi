package com.example.rangi;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import android.content.Context;
import android.content.ContentValues;
import android.graphics.Color;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String TABLE_NAME = "TABLE_NAME";
    public static final String COLUMN_ZERO_RGB = "column_one_RGB";
    public static final String COLUMN_ONE_NAME = "column_two_Name";


    public DatabaseHelper(@Nullable Context context){ //}, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "IWetMyPlants_SQLite_DataBase.db", null, 1);

    }

    // this is called the first time a database is accessed. The code here should create a new database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_Table_SQL_Statement= "CREATE TABLE "
                + TABLE_NAME + " ("
                + COLUMN_ZERO_RGB + " INTEGER, "
                + COLUMN_ONE_NAME + " TEXT)";

        sqLiteDatabase.execSQL(create_Table_SQL_Statement);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Replace old SQLite database with new SQLite database
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public long add_entry_to_DB (ColourObj col) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues content_values = new ContentValues();
        content_values.put(COLUMN_ZERO_RGB, col.getRGB());
        content_values.put(COLUMN_ONE_NAME, col.getName());
        long rowID = database.insert(TABLE_NAME, null, content_values);
        database.close();
        return rowID;
    }
    public ArrayList<ColourObj> get_all_from_DB () {

        ArrayList<ColourObj> returnList = new ArrayList<>();
        String SQLite_query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(SQLite_query, null);
        if (cursor.moveToFirst()) {

            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int rgbVal = Integer.parseInt(cursor.getString(2));


                ColourObj colourReturn = new ColourObj(name, rgbVal);

                returnList.add(colourReturn);

            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return returnList;
    }
    public ColourObj get(ColourObj col) {

        ArrayList<ColourObj> returnList = new ArrayList<>();
        String SQLite_query = "SELECT * FROM " + TABLE_NAME+ "WHERE COLUMN_ZERO_RGB=="+String.valueOf(col.getRGB());
        ColourObj colourReturn=new ColourObj();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(SQLite_query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int rgbVal = Integer.parseInt(cursor.getString(2));
                colourReturn.setName(name);
                colourReturn.setRGB(rgbVal);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return colourReturn;

    }

    }