package com.ex.dictonary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class About_us_uz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us_uz);
    }
    public void en (View v){
        Intent i= new Intent(About_us_uz.this,About_us.class);
        startActivity(i);
    }
    public void aboutuz_back(View v){
        Intent i =new Intent(About_us_uz.this,Ana_screen.class);
        startActivity(i);
    }

    public void instagramuz(View v){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/itimus_academy/"));
        startActivity(browserIntent);
    }
    public void youuz(View v){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCtxypCLZEd8v3AoUu-xZS4w"));
        startActivity(browserIntent);
    }
    public void telegramuz(View v){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/itimusacademy"));
        startActivity(browserIntent);
    }
}