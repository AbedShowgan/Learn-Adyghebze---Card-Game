package com.example.circassianwords_cardgame;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
    public class listAdapter extends ArrayAdapter<listData> {
        public listAdapter(@NonNull Context context, ArrayList<listData> dataArrayList) {
            super(context, R.layout.list_data, dataArrayList);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
            listData listData = getItem(position);
            if (view == null){
                view = LayoutInflater.from(getContext()).inflate(R.layout.list_data, parent, false);
            }
            ImageView listImage = view.findViewById(R.id.listImage);
            TextView listWord = view.findViewById(R.id.listWord);
            TextView listTranslation = view.findViewById(R.id.listTranslation);
            listImage.setImageResource(listData.image);
            listWord.setText(listData.word);
            listTranslation.setText(listData.translation);
            return view;
        }
    }

