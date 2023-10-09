package com.example.circassianwords_cardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//
//public class listDataActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_data);
//    }
//}


public class listData {
    String word, translation;
    int ingredients, desc;
    int image;
    public listData(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }
}