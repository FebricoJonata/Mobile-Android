package com.example.uas.FCM;

import android.nfc.Tag;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.uas.database.Database;
import com.example.uas.database.NotificationHelper;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;
import java.util.Map;

public class FCMNotification extends FirebaseMessagingService {

    Database db;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        System.out.println("Test");
        System.out.println("Title : " + message.getNotification().getTitle());
        System.out.println("Body  : " + message.getNotification().getBody());
        String title = message.getNotification().getTitle();
        String body  = message.getNotification().getBody();
        db = Database.getInstance(this);
        db.addNotification(title, body);
        System.out.println("SUKSES");
    }



}
