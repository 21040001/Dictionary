package com.ex.dictonary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.sql.SQLException;
import java.util.Random;

public class amemorazation_screen extends AppCompatActivity {
    private CardView a_var, b_var, c_var;
    private TextView boshliq, variant1, variant2, variant3;
    private String f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amemorazation_screen);


        boshliq = findViewById(R.id.boshliquz);
        variant1 = findViewById(R.id.variant1uz);
        variant2 = findViewById(R.id.variant2uz);
        variant3 = findViewById(R.id.variant3uz);
        a_var = findViewById(R.id.a_varuz);
        b_var = findViewById(R.id.b_varuz);
        c_var = findViewById(R.id.c_varuz);


        a_var.setCardBackgroundColor(Color.WHITE);
        b_var.setCardBackgroundColor(Color.WHITE);

        c_var.setCardBackgroundColor(Color.WHITE);


        Dao d = new Dao();


        String u = FirebaseAuth.getInstance().getCurrentUser().getUid();


        try {

            int jami = Integer.parseInt(d.say(u));

            if (!(jami == 0)) {
                Random rand = new Random();

                int var = rand.nextInt(2);





                boshliq.setText(d.chaqirboshliquz(u));

                f = (String) boshliq.getText();


                String javob = d.chaqirtogrivariantuz(u, f);
                String variant_1 = d.chaqir_variant_uz(u);
                String variant_2 = d.chaqir_variant_uz(u);


                if (var == 0) {
                    variant1.setText(javob);
                    variant2.setText(variant_1);
                    variant3.setText(variant_2);
                } else if (var == 1) {
                    variant1.setText(variant_1);
                    variant2.setText(javob);
                    variant3.setText(variant_2);
                } else {
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
        } finally {
            try {
                d.getDb().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void amemorazation_back(View v) {
        Intent i = new Intent(amemorazation_screen.this, Ana_screen.class);
        startActivity(i);
    }


    public void memouz(View v) throws SQLException {
        Dao d = new Dao();
        String u = FirebaseAuth.getInstance().getCurrentUser().getUid();
        d.durumeng(u, (String) boshliq.getText());

        a_var.setCardBackgroundColor(Color.WHITE);
        b_var.setCardBackgroundColor(Color.WHITE);
        c_var.setCardBackgroundColor(Color.WHITE);

        try {

            int jami = Integer.parseInt(d.say(u));

            if (!(jami == 0)) {
                Random rand = new Random();

                int var = rand.nextInt(2);
                Toast.makeText(this, String.valueOf(var), Toast.LENGTH_SHORT).show();




                boshliq.setText(d.chaqirboshliquz(u));

                f = (String) boshliq.getText();


                String javob = d.chaqirtogrivariantuz(u, f);
                String variant_1 = d.chaqir_variant_uz(u);
                String variant_2 = d.chaqir_variant_uz(u);


                if (var == 0) {
                    variant1.setText(javob);
                    variant2.setText(variant_1);
                    variant3.setText(variant_2);
                } else if (var == 1) {
                    variant1.setText(variant_1);
                    variant2.setText(javob);
                    variant3.setText(variant_2);
                } else {
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
        } finally {
            try {
                d.getDb().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void nextuz(View v)throws SQLException{

        Dao d = new Dao();


        a_var.setCardBackgroundColor(Color.WHITE);
        b_var.setCardBackgroundColor(Color.WHITE);

        c_var.setCardBackgroundColor(Color.WHITE);
        String u=FirebaseAuth.getInstance().getCurrentUser().getUid();



        try {

            int jami= Integer.parseInt(d.say(u));

            if (!(jami == 0)) {
                Random rand = new Random();

                int var = rand.nextInt(2);



                boshliq.setText(d.chaqirboshliquz(u));

                f= (String) boshliq.getText();


                String javob = d.chaqirtogrivariantuz(u, f);
                String variant_1 = d.chaqir_variant_uz(u);
                String variant_2 = d.chaqir_variant_uz(u);


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

    public void var_a_uz(View v)throws SQLException{

        String u =FirebaseAuth.getInstance().getCurrentUser().getUid();
        String text= (String) variant1.getText();
        String textbosh= (String) boshliq.getText();
        Dao d=new Dao();
        String dg=d.chaqirtogrivariantuz(u,textbosh);
        if (text.equalsIgnoreCase(dg)){
            a_var.setCardBackgroundColor(Color.GREEN);
            b_var.setCardBackgroundColor(Color.WHITE);
            c_var.setCardBackgroundColor(Color.WHITE);
        }
        else{
            a_var.setCardBackgroundColor(Color.RED);
        }

}

    public void var_b_uz(View v)throws SQLException{
        String u =FirebaseAuth.getInstance().getCurrentUser().getUid();
        String text= (String) variant2.getText();
        String textbosh= (String) boshliq.getText();
        Dao d=new Dao();
        String dg=d.chaqirtogrivariantuz(u,textbosh);
        if (text.equalsIgnoreCase(dg)){
            b_var.setCardBackgroundColor(Color.GREEN);
            a_var.setCardBackgroundColor(Color.WHITE);
            c_var.setCardBackgroundColor(Color.WHITE);
        }
        else{
            b_var.setCardBackgroundColor(Color.RED);
        }


    }
    public void var_c_uz(View v)throws SQLException{
        String u =FirebaseAuth.getInstance().getCurrentUser().getUid();
        String text= (String) variant3.getText();
        String textbosh= (String) boshliq.getText();
        Dao d=new Dao();
        String dg=d.chaqirtogrivariantuz(u,textbosh);
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

        Intent i =new Intent(amemorazation_screen.this,My_account.class);

        startActivity(i);
    }

    public void amemorztn_like(View v){

        Intent i =new Intent(amemorazation_screen.this,memorized.class);

        startActivity(i);
    }
    public void abtus(MenuItem m){
        Intent i =new Intent(amemorazation_screen.this,About_us.class);
        startActivity(i);
    }
}