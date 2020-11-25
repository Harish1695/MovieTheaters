package com.movietheaters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TheatersActivity extends AppCompatActivity {
    ListView list_view;
    List<TheatersPojo> theatersPojos;
    ProgressDialog progressDialog;
    AllTheatersAdapter allTheatersAdapter;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theaters);
        getSupportActionBar().setTitle(" Theaters");


        theatersPojos = new ArrayList<>();

        db = FirebaseFirestore.getInstance();
        progressDialog = new ProgressDialog(this);

        list_view = (ListView) findViewById(R.id.list_view);


        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait data is being Loaded");
        progressDialog.show();
        getdata();

    }
public void getdata(){
    db.collection("Theaters")
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            TheatersPojo homeDataPojo = document.toObject(TheatersPojo.class);
                            theatersPojos.add(homeDataPojo);
                        }
                        allTheatersAdapter = new AllTheatersAdapter(theatersPojos, TheatersActivity.this);
                        list_view.setAdapter(allTheatersAdapter);

                    }
                    else {
                        Log.w("TAG", "Error getting documents.", task.getException());
                    }
                }
            });
}

}
