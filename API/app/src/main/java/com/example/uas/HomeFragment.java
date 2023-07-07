package com.example.uas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.JsonToken;
import android.util.JsonWriter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.uas.adapter.ItemAdapter;
import com.example.uas.model.Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView item_rv;
    ItemAdapter item_adapter;
    ArrayList<Item> items = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_home, container, false);
       item_rv = view.findViewById(R.id.item_rv);

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        String url = "https://jsonplaceholder.typicode.com/posts";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0; i<response.length(); i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Item item = new Item(jsonObject.getInt("id"), jsonObject.getString("title"), jsonObject.getString("body"));
                        items.add(item);
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
                item_adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Info ", error.toString());
            }
        });

        requestQueue.add(jsonArrayRequest);
       item_rv.setLayoutManager(new LinearLayoutManager(getContext()));
       item_adapter = new ItemAdapter(items);
       item_rv.setAdapter(item_adapter);


       return view;
    }

}