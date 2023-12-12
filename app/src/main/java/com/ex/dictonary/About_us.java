package com.ex.dictonary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class About_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    public void uz(View v){
        Intent i =new Intent(About_us.this,About_us_uz.class);
        startActivity(i);
    }
    public void aboutus_back(View v){
        Intent i =new Intent(About_us.this,Ana_screen.class);
        startActivity(i);
    }
    public void instagram(View v){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/itimus_academy/"));
        startActivity(browserIntent);
    }
    public void you(View v){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCtxypCLZEd8v3AoUu-xZS4w"));
        startActivity(browserIntent);
    }
    public void telegram(View v){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/itimusacademy"));
        startActivity(browserIntent);
    }
}