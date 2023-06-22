package com.example.project_tow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView title;
    private Button start;
    private Animation top;
    private Animation bottom;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        title = findViewById(R.id.txtTitle);
        start = findViewById(R.id.btStart);

        top =  AnimationUtils.loadAnimation(this, R.drawable.top_text);
        bottom =  AnimationUtils.loadAnimation(this, R.drawable.bottom_buttun);

        title.setAnimation( top);
        start.setAnimation( bottom);

    }


    public void btnLogInOnClick(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}