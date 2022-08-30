package com.example.alquran_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ParaListActivity extends AppCompatActivity {
    ListView paraList;
    DatabaseAccess databaseAccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_list);

        paraList = findViewById(R.id.para_list);

        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        ArrayList<ParaInfo> paraInfoArrayList = databaseAccess.getParaInfo();
        databaseAccess.close();
        ParaInfoAdapter paraInfoAdapter = new ParaInfoAdapter(ParaListActivity.this,paraInfoArrayList);
        paraList.setAdapter(paraInfoAdapter);
    }
}