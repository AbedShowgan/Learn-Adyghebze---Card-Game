package com.example.circassianwords_cardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Switch;

public class settingsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button backMenuBtn = findViewById(R.id.backButton);
        Button resetBtn = findViewById(R.id.resetButton);

        Switch soundSwitch =  findViewById(R.id.soundSwitch);

        RadioButton verticalBtn =  findViewById(R.id.verticalRadioButton);
        RadioButton horizontalBtn =  findViewById(R.id.horizontalRadioButton);

        backMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Exit the app when the "Exit" button is clicked
                Intent intent = new Intent(settingsActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Turn off Sound
                soundSwitch.setChecked(false);
                verticalBtn.toggle();
                //Set Mode into "Vertical"
            }
        });
    }


}