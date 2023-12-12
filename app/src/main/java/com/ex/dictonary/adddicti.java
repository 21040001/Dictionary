package com.ex.dictonary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.sql.SQLException;

public class adddicti extends AppCompatActivity {
    private Intent get_intent;

    private EditText add_key,add_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddicti);

        add_key=findViewById(R.id.add_key);
        add_value=findViewById(R.id.add_value);



        Dao d =new Dao();

    }
    public void add(View v){
        get_intent=getIntent();
        FirebaseAuth mAuth=FirebaseAuth.getInstance();
        String username = mAuth.getCurrentUser().getUid();
        Dao d =new Dao();
        String a = String.valueOf(add_key.getText());
        String b = String.valueOf(add_value.getText());
        if(!a.isEmpty() && !b.isEmpty()){
        try {
            d.lugat_ekle(a,b,username);
            Toast.makeText(this, "Succesfully", Toast.LENGTH_SHORT).show();

            add_key.setText("");
            add_value.setText("");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                d.getDb().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        }else {
            Toast.makeText(this, "Please fill in the blanks correctly", Toast.LENGTH_SHORT).show();
        }
    }

    public void add_back(View v){
        Intent i = new Intent(adddicti.this,Ana_screen.class);
        startActivity(i);
    }
    public void add_like(View v){
        Intent i = new Intent(adddicti.this,memorized.class);
        startActivity(i);
    }
    public void myaccount(MenuItem v){

        Intent i =new Intent(adddicti.this,My_account.class);

        startActivity(i);
    }
    public void abtus(MenuItem m){
        Intent i =new Intent(adddicti.this,About_us.class);
        startActivity(i);
    }
}