package com.example.kelvinlopeztorres.tcgshoppr;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class TournamentsTab extends Fragment {

    ImageButton ImgBtnYugioh;
    ImageButton ImgBtnMagic;
    ImageButton ImgBtnDbs;
    ImageButton ImgBtnPokemon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.tournaments_tab, container, false);

        ImgBtnYugioh = v.findViewById(R.id.imageButtonYugioh);
        ImgBtnYugioh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYugiohTournament();
            }
        });

        ImgBtnMagic = v.findViewById(R.id.imageButtonMagic);
        ImgBtnMagic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMagicTournament();
            }
        });

        ImgBtnDbs = v.findViewById(R.id.imageButtonDbs);
        ImgBtnDbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDbsTournament();
            }
        });

        ImgBtnPokemon = v.findViewById(R.id.imageButtonPokemon);
        ImgBtnPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPokemonTournament();
            }
        });

        return v;
    }

    void openYugiohTournament()
    {
        Intent intent = new Intent(getActivity(), YugiohTournament.class);
        startActivity(intent);

    }

    void openMagicTournament()
    {
        Intent intent = new Intent(getActivity(), MagicTournament.class);
        startActivity(intent);

    }

    void openDbsTournament()
    {
        Intent intent = new Intent(getActivity(), DbsTournament.class);
        startActivity(intent);

    }

    void openPokemonTournament()
    {
        Intent intent = new Intent(getActivity(), PokemonTournament.class);
        startActivity(intent);

    }
}
