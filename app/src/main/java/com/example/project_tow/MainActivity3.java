package com.example.project_tow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private RecyclerView recyclerView;

    private RecyclerView.Adapter adapter;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    private  ArrayList<ListItems> listitem ;

    //////mohtade////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager((getApplicationContext()));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
        Gson gson = new Gson();

        listitem = new ArrayList<>();
        ListItems item1 = new ListItems("Cat","Cats are good pets for domestication",R.drawable.cat);
        ListItems item2 = new ListItems("Cow","Cows are animals suitable for home breeding and have many benefits",R.drawable.cow);
        ListItems item3 = new ListItems("Dog","Dogs are pets and man's best friend",R.drawable.dog);
        ListItems item4 = new ListItems("Lion","The lion is a predator and is called the king of the jungle",R.drawable.lionn);
        ListItems item5 = new ListItems("Sheep","Sheep are animals suitable for home breeding and have a lot of benefits",R.drawable.sheep);
        ListItems item6 = new ListItems("Horse","The horse is an animal that is suitable for domestic breeding and is used for transportation",R.drawable.horse);
        listitem.add(item1);
        listitem.add(item2);
        listitem.add(item3);
        listitem.add(item4);
        listitem.add(item5);
        listitem.add(item6);

        String listAnimals = gson.toJson(listitem);
        editor.putString("123",listAnimals);
        editor.commit();

        MyAdapter adapter = new MyAdapter(this,listitem);
        recyclerView.setAdapter(adapter);
    }

}




