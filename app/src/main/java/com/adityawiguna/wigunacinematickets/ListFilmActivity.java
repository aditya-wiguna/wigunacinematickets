package com.adityawiguna.wigunacinematickets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListFilmActivity extends AppCompatActivity {

    ListView lvFilm;

    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_film);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvFilm = (ListView)findViewById(R.id.lvFilm);

        list.add("Film 1");
        list.add("Film 2");
        list.add("Film 3");

        ArrayAdapter<String> listFilmAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                list
        );

        lvFilm.setAdapter(listFilmAdapter);

        lvFilm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String film = list.get(position);
                Intent openIntent = new Intent(ListFilmActivity.this, FilmActivity.class);
                openIntent.putExtra("film", film);
                startActivity(openIntent);
            }
        });

    }
}
