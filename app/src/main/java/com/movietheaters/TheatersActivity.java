package com.movietheaters;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TheatersActivity extends AppCompatActivity {
    ListView list_view;
    List<TheatersPojo> theatersPojos;
    ProgressDialog progressDialog;
    AllTheatersAdapter viewAllRecipiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theaters);
        getSupportActionBar().setTitle(" Theaters");


        theatersPojos = new ArrayList<>();

        list_view = (ListView) findViewById(R.id.list_view);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait data is being Loaded");
        progressDialog.show();
        Query query = FirebaseDatabase.getInstance().getReference("Theaters");
        query.addListenerForSingleValueEvent(valueEventListener);
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            progressDialog.dismiss();
            theatersPojos.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    TheatersPojo homeDataPojo = snapshot.getValue(TheatersPojo.class);
                    theatersPojos.add(homeDataPojo);
                }
                viewAllRecipiesAdapter = new AllTheatersAdapter(theatersPojos, TheatersActivity.this);
                list_view.setAdapter(viewAllRecipiesAdapter);

            } else {
                Toast.makeText(TheatersActivity.this, "No data Found", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            progressDialog.dismiss();

        }
    };
}
