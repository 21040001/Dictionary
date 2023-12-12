package com.ex.dictonary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Random;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.sql.SQLException;

public class memorazation_screen extends AppCompatActivity {
    private Intent get_intent;

    private CardView a_var,b_var,c_var;
    private TextView boshliq,variant1,variant2,variant3;
    private String f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorazation_screen);

        boshliq = findViewById(R.id.boshliq);
        variant1 = findViewById(R.id.variant1);
        variant2 = findViewById(R.id.variant2);
        variant3 = findViewById(R.id.variant3);
        a_var=findViewById(R.id.a_var);
        b_var=findViewById(R.id.b_var);
        c_var=findViewById(R.id.c_var);


        a_var.setCardBackgroundColor(Color.WHITE);
        b_var.setCardBackgroundColor(Color.WHITE);

        c_var.setCardBackgroundColor(Color.WHITE);


        Dao d = new Dao();
        get_intent = getIntent();


        String u=FirebaseAuth.getInstance().getCurrentUser().getUid();



        try {

            int jami= Integer.parseInt(d.say(u));

            if (!(jami == 0)) {
                Random rand = new Random();

                int var = rand.nextInt(2);









                boshliq.setText(d.chaqirboshliqeng(u));
                f= (String) boshliq.getText();


 

                String javob = d.chaqirtogrivarianteng(u, f);
                String variant_1 = d.varianteng(u);
                String variant_2 = d.varianteng(u);


                if(var==0){
                    variant1.setText(javob);
                    variant2.setText(variant_1);
                    variant3.setText(variant_2);
                } else if (var==1) {
                    variant1.setText(variant_1);
                    variant2.setText(javob);
                    variant3.setText(variant_2);
                }else{
                    variant1.setText(variant_1);
                    variant2.setText(variant_2);
                    variant3.setText(javob);
                }

            } else {
                boshliq.setText("Click the next button to start");
                variant1.setText("A");
                variant2.setText("B");
                variant3.setText("C");
                Toast.makeText(this, "Please first enter your dictionary from the lugat input section", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                d.getDb().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }



    public void memorazation_back(View v){
        Intent i= new Intent(memorazation_screen.this,Ana_screen.class);
        startActivity(i);

    }

    public void memo(View v)throws SQLException{
        Dao d= new Dao();
        String u=FirebaseAuth.getInstance().getCurrentUser().getUid();
        d.durumeng(u, (String) boshliq.getText());

        a_var.setCardBackgroundColor(Color.WHITE);
        b_var.setCardBackgroundColor(Color.WHITE);
        c_var.setCardBackgroundColor(Color.WHITE);

        try {

            int jami= Integer.parseInt(d.say(u));

            if (!(jami == 0)) {
                Random rand = new Random();

                int var = rand.nextInt(2);


                boshliq.setText(d.chaqirboshliqeng(u));

                f= (String) boshliq.getText();


                String javob = d.chaqirtogrivarianteng(u, f);
                String variant_1 = d.varianteng(u);
                String variant_2 = d.varianteng(u);


                if(var==0){
                    variant1.setText(javob);
                    variant2.setText(variant_1);
                    variant3.setText(variant_2);
                } else if (var==1) {
                    variant1.setText(variant_1);
                    variant2.setText(javob);
                    variant3.setText(variant_2);
                }else{
                    variant1.setText(variant_1);
                    variant2.setText(variant_2);
                    variant3.setText(javob);
                }

            } else {
                boshliq.setText("Click the next button to start");
                variant1.setText("A");
                variant2.setText("B");
                variant3.setText("C");
                Toast.makeText(this, "Please first enter your dictionary from the lugat input section", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                d.getDb().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }}




    public void nexteng(View v)throws SQLException{
        /*Intent i;
        i = new Intent(memorazation_screen.this,memorazation_screen.class);
        startActivity(i);*/
        Dao d = new Dao();
        get_intent = getIntent();

        a_var.setCardBackgroundColor(Color.WHITE);
        b_var.setCardBackgroundColor(Color.WHITE);

        c_var.setCardBackgroundColor(Color.WHITE);
        String u=FirebaseAuth.getInstance().getCurrentUser().getUid();



        try {

            int jami= Integer.parseInt(d.say(u));

            if (!(jami == 0)) {
                Random rand = new Random();

                int var = rand.nextInt(2);



                    boshliq.setText(d.chaqirboshliqeng(u));

                    f= (String) boshliq.getText();


                String javob = d.chaqirtogrivarianteng(u, f);
                String variant_1 = d.varianteng(u);
                String variant_2 = d.varianteng(u);


                if(var==0){
                    variant1.setText(javob);
                    variant2.setText(variant_1);
                    variant3.setText(variant_2);
                } else if (var==1) {
                    variant1.setText(variant_1);
                    variant2.setText(javob);
                    variant3.setText(variant_2);
                }else{
                    variant1.setText(variant_1);
                    variant2.setText(variant_2);
                    variant3.setText(javob);
                }

            } else {
                boshliq.setText("Click the next button to start");
                variant1.setText("A");
                variant2.setText("B");
                variant3.setText("C");
                Toast.makeText(this, "Please first enter your dictionary from the lugat input section", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                d.getDb().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void var_a(View v)throws SQLException{

        String u =FirebaseAuth.getInstance().getCurrentUser().getUid();
        String text= (String) variant1.getText();
        String textbosh= (String) boshliq.getText();
        Dao d=new Dao();
        String dg=d.chaqirtogrivarianteng(u,textbosh);
        if (text.equalsIgnoreCase(dg)){
            a_var.setCardBackgroundColor(Color.GREEN);
            b_var.setCardBackgroundColor(Color.WHITE);
            c_var.setCardBackgroundColor(Color.WHITE);
        }
        else{
                a_var.setCardBackgroundColor(Color.RED);
    }





    }
    public void var_b(View v)throws SQLException{
        String u =FirebaseAuth.getInstance().getCurrentUser().getUid();
        String text= (String) variant2.getText();
        String textbosh= (String) boshliq.getText();
        Dao d=new Dao();
        String dg=d.chaqirtogrivarianteng(u,textbosh);
        if (text.equalsIgnoreCase(dg)){
            b_var.setCardBackgroundColor(Color.GREEN);
            a_var.setCardBackgroundColor(Color.WHITE);
            c_var.setCardBackgroundColor(Color.WHITE);
        }
        else{
            b_var.setCardBackgroundColor(Color.RED);
        }

    }
    public void var_c(View v)throws SQLException{
        String u =FirebaseAuth.getInstance().getCurrentUser().getUid();
        String text= (String) variant3.getText();
        String textbosh= (String) boshliq.getText();
        Dao d=new Dao();
        String dg=d.chaqirtogrivarianteng(u,textbosh);
        if (text.equalsIgnoreCase(dg)){
            c_var.setCardBackgroundColor(Color.GREEN);
            b_var.setCardBackgroundColor(Color.WHITE);
            a_var.setCardBackgroundColor(Color.WHITE);
        }
        else{
            c_var.setCardBackgroundColor(Color.RED);
        }
    }
    public void myaccount(MenuItem v){

        Intent i =new Intent(memorazation_screen.this,My_account.class);

        startActivity(i);
    }
    public void memorztn_like(View v){

        Intent i =new Intent(memorazation_screen.this,memorized.class);

        startActivity(i);
    }
    public void abtus(MenuItem m){
        Intent i =new Intent(memorazation_screen.this,About_us.class);
        startActivity(i);
    }
}