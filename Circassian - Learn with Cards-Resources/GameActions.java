package com.example.circassianwords_cardgame;

import android.content.Intent;

public interface GameActions {

    //Reveals all cards
    abstract void showAll();
     abstract void  restart();
    abstract boolean isMatch(int drawable, int wordDrawable);


}
