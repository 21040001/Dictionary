package com.ex.dictonary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.sql.SQLException;

public class Ana_screen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_screen);




    }

    public void add_dictionary(View v)throws SQLException {


        Intent i =new Intent(Ana_screen.this,adddicti.class);
        startActivity(i);


    }
    public void word_memorazation(View v)throws SQLException{
        Dao d=new Dao();


        Intent i =new Intent(Ana_screen.this,tanlov.class);
        String jami = "4";//d.say(username);
        i.putExtra("jami",jami);

        startActivity(i);
    }
    public void memorized_word(View v){

        Intent i =new Intent(Ana_screen.this,memorized.class);

        startActivity(i);
    }

    public void myaccount(MenuItem v){

        Intent i =new Intent(Ana_screen.this,My_account.class);

        startActivity(i);
    }

    public void ana_like(View v){

        Intent i =new Intent(Ana_screen.this,memorized.class);

        startActivity(i);
    }
    public void abtus(MenuItem m){
        Intent i =new Intent(Ana_screen.this,About_us.class);
        startActivity(i);
    }
}