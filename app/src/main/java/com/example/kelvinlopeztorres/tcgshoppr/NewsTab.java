package com.example.kelvinlopeztorres.tcgshoppr;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;

public class NewsTab  extends Fragment {

    private ListView mListView;
    private DatabaseReference mDatabase;
    private final ArrayList<Card> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.listview_layout, container, false);

        mListView = (ListView) v.findViewById(R.id.listView);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        final CustomListAdapter adapter = new CustomListAdapter(getActivity(), R.layout.activity_main,list, R.id.cardTitle, R.id.cardBody);
        mListView.setAdapter(adapter);

        mDatabase.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Object f = dataSnapshot.getKey();
                String si = String.valueOf(f);

                Log.d("Entro", si);
                if (si.equals("News")){

                    Object body;
                    Object title;

                    Object key;

                    for (DataSnapshot ds : dataSnapshot.getChildren()){

                        key   =  ds.getKey();
                        body = ds.child("Body").getValue();
                        title = ds.child("Title").getValue();

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
        return v ;
    }
}
