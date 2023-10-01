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
            Button btnExit = findViewById(R.id.btnExit);

            btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start the main game activity
                    Intent intent = new Intent(MenuActivity.this, MainActivity.class);
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
