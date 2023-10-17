package com.example.circassianwords_cardgame;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.circassianwords_cardgame.databinding.ActivityDictionaryViewBinding;
import java.util.ArrayList;
import androidx.appcompat.widget.SearchView;
public class DictionaryView extends AppCompatActivity {

    private ActivityDictionaryViewBinding binding;

    listAdapter listAdapter;
    ArrayList<listData> dataArrayList = new ArrayList<>();
    listData listData;

   // private Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //setContentView(R.layout.activity_dictionary_view);

        super.onCreate(savedInstanceState);

        binding = ActivityDictionaryViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int[] imageList = {R.drawable.bear, R.drawable.cat, R.drawable.dog, R.drawable.bee, R.drawable.chicken1, R.drawable.beaver1};
        String[] wordList = {"Bear", "Cat", "Dog", "Bee", "Chicken","Beaver"};
        String[] translationList = {"мышъэ" ,
                "кьэтыу" ,
                "Хьэ" ,
                "бжьэ" ,
                "кьэты","Псэхьэ"};
        for (int i = 0; i < wordList.length; i++){
            listData = new listData(imageList[i],wordList[i], translationList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new listAdapter(DictionaryView.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        Button backBtn = findViewById(R.id.backBtnDict);
        SearchView searchBar = findViewById(R.id.searchBar1);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Exit the app when the "Exit" button is clicked
                Intent intent = new Intent(DictionaryView.this, MenuActivity.class);
                startActivity(intent);
            }
        });
//        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                //for extra detail
//                Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
//                intent.putExtra("name", wordList[i]);
//                intent.putExtra("time", translationList[i]);
//                intent.putExtra("image", imageList[i]);
//                startActivity(intent);
//            }
//        });

    }
}