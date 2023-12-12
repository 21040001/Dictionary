package com.ex.dictonary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText email,psswrd;
    private CheckBox check;
    private SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.emailgir);
        psswrd=findViewById(R.id.passworgir);

        check=findViewById(R.id.checkbox);

        preference = this.getSharedPreferences("com.ex.dictonary", Context.MODE_PRIVATE);

        email.setText(preference.getString("username",null));
        psswrd.setText(preference.getString("password",null));

    }
    public void log_in(View s){
        String aemail= String.valueOf(email.getText());
        String apsswrd= String.valueOf(psswrd.getText());
        FirebaseAuth mAuth =FirebaseAuth.getInstance();
        if (!aemail.isEmpty() && !apsswrd.isEmpty()){
            if (check.isChecked()) {

                preference.edit().putString("username", aemail).apply();
                preference.edit().putString("password", apsswrd).apply();
                Toast.makeText(this, "basari", Toast.LENGTH_SHORT).show();
            }
        mAuth.signInWithEmailAndPassword(aemail,apsswrd)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            Intent i =new Intent(MainActivity.this,Ana_screen.class);
                            startActivity(i);
                        }

                    }
                });
        }else{
            Toast.makeText(this, "Username or Password area is empty!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void forgot_password(View v){

        Intent i=new Intent(MainActivity.this,Forgot_Screen.class);
        startActivity(i);
    }
    public void sign_in(View v){

        Intent i=new Intent(MainActivity.this,Sign_in.class);
        startActivity(i);
    }
}