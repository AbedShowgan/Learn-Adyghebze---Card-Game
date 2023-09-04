package com.example.circassianwords_cardgame;

public class Card {
    private int drawableResourceId;
    private boolean isFlipped;
    private int givenID;

    public Card(int drawableResourceId, int givenID) {
        this.drawableResourceId = drawableResourceId;
        this.isFlipped = false;
        this.givenID = givenID;
    }

    public int getDrawableResourceId() {
        return drawableResourceId;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void flip() {
        isFlipped = true;
    }


}