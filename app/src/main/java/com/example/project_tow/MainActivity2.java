package com.example.project_tow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    public static final String NAME = "NAME";
    public static final String PASS = "PASS";
    public static final String FLAG = "FLAG";
    private EditText edtname, edtPass;
    private CheckBox chk;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setUpSheradPrefs();
        setUpViews();
        checkPrefs();
    }

    private void checkPrefs() {
        Boolean flag = prefs.getBoolean(FLAG,false);
        if(flag){
            String name = prefs.getString(NAME,"");
            String pass = prefs.getString(PASS,"");
            edtname.setText(name);
            edtPass.setText(pass);
            chk.setChecked(true);
        }
    }

    private void setUpViews() {
        edtname = findViewById(R.id.username);
        edtPass = findViewById(R.id.password);
        chk = findViewById(R.id.forgot);
    }

    private void setUpSheradPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    public void btnLogInOnClick(View view) {
        String name = edtname.getText().toString();
        String pass = edtPass.getText().toString();
        if(chk.isChecked()){
            editor.putString(NAME,name);
            editor.putString(PASS,pass);
            editor.putBoolean(FLAG,true);
            editor.commit();
        }
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }
}