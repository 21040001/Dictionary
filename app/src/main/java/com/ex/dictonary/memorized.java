package com.ex.dictonary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class memorized extends AppCompatActivity {
    private Intent get_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorized);

        ListView l=findViewById(R.id.listmemo);

        SimpleAdapter adapter;

        List<Map<String, String>> list;

        String Mauth=FirebaseAuth.getInstance().getUid();
        Dao d=new Dao();
        list=d.getlist(Mauth);

        String[] f = {"item1", "item2"};
        int[] t = {R.id.item1, R.id.item2};

        adapter=new SimpleAdapter(this,list,R.layout.listlayout,f,t);

        l.setAdapter(adapter);

    }


    public void memorized_back(View v){
        Intent i=new Intent(memorized.this,Ana_screen.class);
        startActivity(i);
    }
    public void myaccount(MenuItem v){

        Intent i =new Intent(memorized.this,My_account.class);

        startActivity(i);
    }
    public void abtus(MenuItem m){
        Intent i =new Intent(memorized.this,About_us.class);
        startActivity(i);
    }
}