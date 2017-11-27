package com.adityawiguna.wigunacinematickets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class FilmActivity extends AppCompatActivity {

    TextView tvJudul, tvRilis, tvGenre, tvMenit, tvSinopsis;
    ImageView imgView;

    String JudulFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvJudul = (TextView)findViewById(R.id.judul);
        tvRilis = (TextView)findViewById(R.id.rilis);
        tvGenre = (TextView)findViewById(R.id.genre);
        tvMenit = (TextView)findViewById(R.id.menit);
        tvSinopsis = (TextView)findViewById(R.id.storyLine);
        imgView = (ImageView)findViewById(R.id.imgView);

        Intent myIntent = getIntent();

        JudulFilm = myIntent.getStringExtra("film");

        if (JudulFilm.equals("Film 1")){
            imgView.setImageResource(R.drawable.mmv);
            tvJudul.setText("Film 1");
            tvGenre.setText("Komedi");
            tvMenit.setText("190 Menit");
            tvSinopsis.setText(R.string.sinopsis);
            tvRilis.setText("Agustus 2017");

        } else if(JudulFilm.equals("Film 2")){
            imgView.setImageResource(R.drawable.c3);
            tvJudul.setText("Film 2");
            tvGenre.setText("Komedi, Kartun");
            tvMenit.setText("120 Menit");
            tvSinopsis.setText(R.string.sinopsis1);
            tvRilis.setText("Agustus 2017");
        } else if(JudulFilm.equals("Film 3")){
            imgView.setImageResource(R.drawable.stm);
            tvJudul.setText("Film 3");
            tvGenre.setText("Komedi, Kartun");
            tvMenit.setText("90 Menit");
            tvSinopsis.setText(R.string.sinopsis2);
            tvRilis.setText("Agustus 2017");
        }


    }
}
