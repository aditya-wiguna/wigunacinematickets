package com.adityawiguna.wigunacinematickets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spJudul, spKelas, spInclude;
    EditText jumlah;
    ImageView imgView;
    Button book;

    ArrayList<String> aJudul = new ArrayList<>();
    ArrayList<String> aKelas = new ArrayList<>();
    ArrayList<String> aInclude = new ArrayList<>();

    String filmName, kelasType, included, grandjumlahh;
    Integer grandjumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUi();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        aJudul.add("Film 1");
        aJudul.add("Film 2");
        aJudul.add("Film 3");

        aKelas.add("Regular");
        aKelas.add("Executive");

        aInclude.add("No");
        aInclude.add("Popcorn + Minuman");


        ArrayAdapter<String> aJudulAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                aJudul);

        ArrayAdapter<String> aKelasAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                aKelas
        );

        ArrayAdapter<String> aIncludeAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                aInclude
        );

        spJudul.setAdapter(aJudulAdapter);
        spKelas.setAdapter(aKelasAdapter);
        spInclude.setAdapter(aIncludeAdapter);

        spJudul.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                filmName = aJudul.get(position);

                if (filmName.equals("Film 1")){
                    imgView.setBackgroundResource(R.drawable.mmv);
                } else if (filmName.equals("Film 2")){
                    imgView.setBackgroundResource(R.drawable.c3);
                } else if(filmName.equals("Film 3")){
                    imgView.setBackgroundResource(R.drawable.stm);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spKelas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                kelasType = aKelas.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spInclude.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                included = aInclude.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jumlah.getText().length() < 1){
                    jumlah.setError("Harap isikan jumlah tiket");
                } else {
                    grandjumlah = Integer.parseInt(jumlah.getText().toString());
                    if (grandjumlah < 1){
                        jumlah.setError("Anda harus minimal memesan satu tiket");
                    } else if(grandjumlah > 5){
                        jumlah.setError("Maaf anda hanya bisa memesan maksimal 5 tiket");
                    } else {
                        processBook();
                    }
                }

            }
        });



    }

    private void setupUi(){
        spJudul = (Spinner)findViewById(R.id.spJudul);
        spKelas = (Spinner)findViewById(R.id.spKelas);
        spInclude = (Spinner)findViewById(R.id.spInclude);
        jumlah = (EditText)findViewById(R.id.jumlah);
        imgView = (ImageView)findViewById(R.id.imgView);
        book = (Button)findViewById(R.id.book);
    }

    private void processBook(){
        grandjumlahh = jumlah.getText().toString();
        Intent openIntent = new Intent(MainActivity.this, TotalActivity.class);
        openIntent.putExtra("judul", String.valueOf(filmName));
        openIntent.putExtra("kelas", kelasType);
        openIntent.putExtra("include", included);
        openIntent.putExtra("jumlah", grandjumlahh);
        startActivity(openIntent);
    }

}
