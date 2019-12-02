package com.example.kelvinlopeztorres.tcgshoppr;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;

public class YugiohTournament extends AppCompatActivity {

    private ListView mListView;
    private DatabaseReference mDatabase;
    private final ArrayList<Card> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        setTitle("Yugioh Tournaments");

        mListView = (ListView) findViewById(R.id.listView);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        final CustomListAdapter adapter = new CustomListAdapter(this, R.layout.yugioh_tournament,list, R.id.YugiohcardTitle, R.id.YugiohcardBody);
        mListView.setAdapter(adapter);

        mDatabase.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Object f = dataSnapshot.getKey();
                String si = String.valueOf(f);

                Log.d("Entro", si);
                if (si.equals("Tournament Yugioh")){

                    Object body;
                    Object title;

                    Object key;

                    for (DataSnapshot ds : dataSnapshot.getChildren()){

                        key   =  ds.getKey();
                        body = ds.child("Date").getValue();
                        title = ds.child("Info").getValue();

                        String sKey = String.valueOf(key);
                        String sBody = String.valueOf(body);
                        String sTitle = String.valueOf(title);


                        Log.d("SNAPDB: ", sKey);
                        Log.d("SNAPDB: ", sBody);
                        Log.d("SNAPDB: ", sTitle);

                        list.add(new Card( sTitle, sBody));
                        adapter.notifyDataSetChanged();
                    }

                    Collections.reverse(list);
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
