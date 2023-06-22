package com.example.project_tow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    private TextView name , dec;
    private ImageView image;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        name = findViewById(R.id.getName);
        dec = findViewById(R.id.getDes);
        image = findViewById(R.id.getImage);
        Intent intent = getIntent();
        String gName =intent.getStringExtra("name");
        String gDes = intent.getStringExtra("des");
        int gImage = intent.getIntExtra("image",0);

        name.setText(gName);
        dec.setText(gDes);
        image.setImageResource(gImage);
    }
}