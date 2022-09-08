package com.example.alquran_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityRV extends AppCompatActivity {
    Button mainSurah, mainPara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rv);

        mainSurah = findViewById(R.id.btn_surah_main_rv);
        mainPara = findViewById(R.id.btn_para_main_rv);

        mainPara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityRV.this, ParaListActivityRV.class);
                startActivity(intent);
            }
        });

        mainSurah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityRV.this,SurahListActivityRV.class);
                startActivity(intent);
            }
        });
    }
}