package com.example.uas.FCM;

import androidx.annotation.NonNull;

import com.example.uas.database.Database;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;
import java.util.Map;

public class FCMNotification extends FirebaseMessagingService {

    Database db;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        String title = message.getNotification().getTitle();
        String body  = message.getNotification().getBody();
        db = Database.getInstance(this);
        db.addNotification(title, body);
    }

}
