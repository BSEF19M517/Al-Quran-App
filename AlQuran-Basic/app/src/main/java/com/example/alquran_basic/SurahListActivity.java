package com.example.alquran_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SurahListActivity extends AppCompatActivity {
    ListView surahList;
    DatabaseAccess databaseAccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_list);

        surahList = findViewById(R.id.surah_list);

        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        ArrayList<SurahInfo> surahInfoArrayList = databaseAccess.getSurahInfo();
        databaseAccess.close();
        SurahInfoAdapter surahInfoAdapter = new SurahInfoAdapter(SurahListActivity.this,surahInfoArrayList);
        surahList.setAdapter(surahInfoAdapter);
    }
}