package com.example.alquran_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mainSurah, mainPara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainSurah = findViewById(R.id.btn_surah_main);
        mainPara = findViewById(R.id.btn_para_main);

        mainPara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ParaListActivity.class);
                startActivity(intent);
            }
        });

        mainSurah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SurahListActivity.class);
                startActivity(intent);
            }
        });
    }
}