package com.ex.dictonary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class tanlov extends AppCompatActivity {

    private Intent get_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanlov);
    }
    public void enuz(View v){

        get_intent=getIntent();

        String jami=get_intent.getStringExtra("jami");
        Intent i =new Intent(tanlov.this,memorazation_screen.class);

        i.putExtra("jami",jami);
        startActivity(i);
    }
    public void uzen(View v){

        Intent i =new Intent(tanlov.this,amemorazation_screen.class);

        startActivity(i);
    }
    public void tanlov_back(View v){
        Intent i = new Intent(tanlov.this,Ana_screen.class);
        startActivity(i);
    }
    public void myaccount(MenuItem v){

        Intent i =new Intent(tanlov.this,My_account.class);

        startActivity(i);
    }
    public void abtus(MenuItem m){
        Intent i =new Intent(tanlov.this,About_us.class);
        startActivity(i);
    }
}