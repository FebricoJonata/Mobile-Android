package com.example.uas.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.uas.model.Notification;

import java.util.ArrayList;

public class NotificationHelper{

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public NotificationHelper(Context context){
        dbHelper = new DatabaseHelper(context);
    }

    public void addNotification(String title, String body){
        db = dbHelper.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("body", body);
        db.insert("notifications", null, values);
        db.close();
    }

    public ArrayList<Notification> getNotification(){
        db = dbHelper.getReadableDatabase();
        ArrayList<Notification> notifications = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from notifications", null);
        while(cursor.moveToNext()){
            Notification notification = new Notification(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            notifications.add(notification);
        }
        cursor.close();
        db.close();
        return notifications;
    }
}
