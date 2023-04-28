package com.example.sqlite;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Declare global variable for readable code
    private final static int DB_VERSION = 1;
    private final static String DB_NAME = "msNews";
    private final static String TABLE_NAME = "news";
    private final static String KEY_IMAGE = "image";
    private final static String KEY_TITTLE = "tittle";
    private final static String KEY_DESC = "description";


    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + KEY_IMAGE + " INTEGER, "
                + KEY_TITTLE + " TEXT, "
                + KEY_DESC + " TEXT);";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    public void addData(News news){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IMAGE, news.getImage());
        values.put(KEY_TITTLE, news.getTittle());
        values.put(KEY_DESC, news.getDescription());


        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // Show All Data
    public List<News> allData(){
        List<News> newsList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){

            do{
                News data = new News();
                data.setImage(Integer.parseInt(cursor.getString(0)));
                data.setTittle(cursor.getString(1));
                data.setDescription(cursor.getString(2));
                newsList.add(data);
            }while (cursor.moveToNext());

        }

        db.close();
        return newsList;
    }
}
