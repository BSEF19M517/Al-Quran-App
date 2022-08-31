package com.example.alquran_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class TranslationActivity extends AppCompatActivity {
    TextView textView1, textView2, textView3,textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        Intent intent = getIntent();
        String ayahText = intent.getStringExtra("ayah");
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        ArrayList<String> translationArrayList = databaseAccess.getTranslation(ayahText);
        databaseAccess.close();

        textView1 = findViewById(R.id.translation_1);
        textView2 = findViewById(R.id.translation_2);
        textView3 = findViewById(R.id.translation_3);
        textView4 = findViewById(R.id.translation_4);

        textView1.setText(translationArrayList.get(0));
        textView2.setText(translationArrayList.get(1));
        textView3.setText(translationArrayList.get(2));
        textView4.setText(translationArrayList.get(3));

    }
}