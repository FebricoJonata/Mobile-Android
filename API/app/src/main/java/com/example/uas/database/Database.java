package com.example.uas.database;

import android.content.Context;

import com.example.uas.model.Notification;

import java.util.ArrayList;

public class Database {

    private static Database instance;
    private NotificationHelper notificationHelper;


    private Database (Context context){
        notificationHelper = new NotificationHelper(context);
    }

    public static Database getInstance(Context context){
        if(instance==null){
            synchronized (Database.class){
                if(instance==null){
                    instance = new Database(context);
                }
            }
        }
        return instance;
    }

    public void addNotification(String title, String body){
        notificationHelper.addNotification(title, body);
    }

    public ArrayList<Notification> getNotification(){
        return notificationHelper.getNotification();
    }

}
