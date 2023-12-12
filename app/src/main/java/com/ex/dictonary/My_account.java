package com.ex.dictonary;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.sql.SQLException;

public class My_account extends AppCompatActivity {

    ImageView IVPreviewImage;
    int SELECT_PICTURE = 200;
    private TextView ism,familiya,soni, soni12,gmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        IVPreviewImage=findViewById(R.id.resm);



        FirebaseAuth mAuth=FirebaseAuth.getInstance();
        String un=mAuth.getCurrentUser().getUid();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        gmail=findViewById(R.id.email12);
        ism=findViewById(R.id.ism12);
        familiya=findViewById(R.id.familiya12);
        soni=findViewById(R.id.soni);
        soni12=findViewById(R.id.soni12);

        Dao d =new Dao();
        try {
            soni.setText(d.say(un));
            soni12.setText(d.say12(un));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }






        DocumentReference docRef = db.collection("Information").document(un);

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()){
                                    DocumentSnapshot doc = task.getResult();
                                    if (doc.exists()) {
                                        String a= (String) doc.get("name");

                                        String b= (String) doc.getData().get("familiya");
                                        String c= (String) doc.getData().get("email");

                                        ism.setText(a);
                                        familiya.setText(b);
                                        gmail.setText(c);
                                    } else {

                                    }
                                } else {

                                }
                                }


                        });







    }

    public void back_acc(View v){
        Intent i =new Intent(My_account.this,Ana_screen.class);
        startActivity(i);
    }

    public void rasmqosh(View v) {

        IVPreviewImage = findViewById(R.id.resm);


        // handle the Choose Image button to trigger
        // the image chooser function
        IVPreviewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });
    }

    // this function is triggered when
    // the Select Image Button is clicked
    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    IVPreviewImage.setImageURI(selectedImageUri);
/*
                    String un=FirebaseAuth.getInstance().getCurrentUser().getUid();

                    FirebaseStorage str=FirebaseStorage.getInstance();
                    str.getReference().child(String.valueOf(selectedImageUri));*/

                }
            }
        }
    }}
