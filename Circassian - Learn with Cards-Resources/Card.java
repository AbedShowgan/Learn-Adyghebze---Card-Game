package com.example.circassianwords_cardgame;

public class Card {
    private int drawableResourceId;
    private boolean isFlipped;
    private int givenID;
    private int partnerID; // id of drawble matching
    public Card(int drawableResourceId, int givenID, int partnerID) {
        this.drawableResourceId = drawableResourceId;
        this.isFlipped = false;
        this.givenID = givenID;this.partnerID = partnerID;
    }

    public int getDrawableResourceId() {
        return drawableResourceId;
    }
    public int getID() {
        return givenID;
    }
    public int getPartnerID() {
        return partnerID;
    }
    public boolean isFlipped() {
        return isFlipped;
    }
    public boolean compareID( Card card2){
        if(card2 !=null){
            return this.getID()%10 == card2.getID() %10;
        }
        return false;
    }

    public boolean comparePartnerID( Card card2){
        if(card2 !=null){
            return this.getPartnerID()==card2.getDrawableResourceId() ||this.getDrawableResourceId()==card2.getPartnerID();
        }
        return false;
    }
    public void flip() {
        isFlipped = true;
    }


}