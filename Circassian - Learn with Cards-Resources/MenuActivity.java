package com.example.circassianwords_cardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;



public class MenuActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu);

            Button btnPlay = findViewById(R.id.btnPlay);
            Button btnDictionary = findViewById(R.id.btnDictionary);
            Button btnSettings = findViewById(R.id.btnSettings);
            Button btnExit = findViewById(R.id.btnExitFromApp);

            btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start the main game activity
                    Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            btnDictionary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start the main game activity
                    Intent intent = new Intent(MenuActivity.this, DictionaryView.class);
                    startActivity(intent);
                }
            });

            btnSettings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Exit the app when the "Exit" button is clicked
                    Intent intent = new Intent(MenuActivity.this, settingsActivity.class);
                    startActivity(intent);
                }
            });
            btnExit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Exit the app when the "Exit" button is clicked
                    finish();
                }
            });
        }
    }
