package com.ex.dictonary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_Screen extends AppCompatActivity {
    EditText femail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_screen);


    }
    public void send(View v){

        femail=findViewById(R.id.forgot_email);
        String email= String.valueOf(femail.getText());

        FirebaseAuth mAuth=FirebaseAuth.getInstance();



        if (!email.isEmpty()){

            mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Forgot_Screen.this, "Email sent.", Toast.LENGTH_SHORT).show();
                                femail.setText("");
                                Intent o= new Intent(Forgot_Screen.this,MainActivity.class);
                                startActivity(o);

                            }

                        }
                    });

        }else {
            Toast.makeText(Forgot_Screen.this, "Enter your email properly", Toast.LENGTH_SHORT).show();

        }


    }

    public void back_for(View v){
        Intent o= new Intent(Forgot_Screen.this,MainActivity.class);
        startActivity(o);
    }
}