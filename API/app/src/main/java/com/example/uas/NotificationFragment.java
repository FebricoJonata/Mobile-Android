package com.example.uas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.uas.adapter.ItemAdapter;
import com.example.uas.adapter.NotificationAdapter;
import com.example.uas.database.Database;
import com.example.uas.model.Notification;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;


public class NotificationFragment extends Fragment {
    RecyclerView notification_rv;

    NotificationAdapter notificationAdapter;

    ArrayList<Notification> notifications = new ArrayList<>();

    Database db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        notification_rv = view.findViewById(R.id.notification_rv);
        notification_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        db = Database.getInstance(getContext());
        notifications = db.getNotification();
        notificationAdapter = new NotificationAdapter(notifications);
        notification_rv.setAdapter(notificationAdapter);
        return view;
    }
}