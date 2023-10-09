package com.example.circassianwords_cardgame;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.example.circassianwords_cardgame.databinding.ActivityDictionaryViewBinding;

public class DictionaryView extends AppCompatActivity {

    private ActivityDictionaryViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      //  binding = ActivityDictionaryViewBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_dictionary_view);

    }
}