package com.ex.dictonary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Sign_in extends AppCompatActivity {
    private EditText ism,fism,oemail,opass1,opass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ism=findViewById(R.id.name);
        fism=findViewById(R.id.Surname);
        oemail=findViewById(R.id.email);
        opass1=findViewById(R.id.password1);
        opass2=findViewById(R.id.password2);

    }

    public void signin(View v){

        String opas1 = String.valueOf(opass1.getText());
        String opas2 = String.valueOf(opass2.getText());
        String oism = String.valueOf(ism.getText());
        String ofam = String.valueOf(fism.getText());
        String oeml= String.valueOf(oemail.getText());
        FirebaseFirestore dbd = FirebaseFirestore.getInstance();
        FirebaseAuth mAuth=FirebaseAuth.getInstance();

        if(opas1.length()>=5) {

            if (opas1.equals(opas2) && !oeml.isEmpty() && !oism.isEmpty()&& !ofam.isEmpty()) {
                mAuth.createUserWithEmailAndPassword(oeml,opas2)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)  {
                                if(task.isSuccessful()){

                                    opass1.setText("");
                                    opass2.setText("");
                                    ism.setText("");
                                    fism.setText("");
                                    oemail.setText("");

                                    String un = String.valueOf(mAuth.getCurrentUser().getUid());


                                    Dao d=new Dao();
                                    try {
                                        d.create_table(un);

                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }


                                    Map<String, Object> info = new HashMap<>();
                                    info.put("name", oism);
                                    info.put("familiya", ofam);
                                    info.put("email", oeml);

                                    dbd.collection("Information").document(un)
                                            .set(info)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    Intent i =new Intent(Sign_in.this,MainActivity.class);
                                                    startActivity(i);
                                                    Toast.makeText(Sign_in.this, "Succesfully", Toast.LENGTH_SHORT).show();
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {

                                                }
                                            });






                                }

                            }
                        });


            } else {
                Toast.makeText(Sign_in.this, "Please enter the necessary information correctly",
                        Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(Sign_in.this, "Your password must consist of at least 6 charactersy",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View s){
        Intent i =new Intent(Sign_in.this,MainActivity.class);
        startActivity(i);

    }
}