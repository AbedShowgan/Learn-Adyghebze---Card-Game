package com.example.circassianwords_cardgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //var to synchronize turns , 0 for images and 1 for words
    static int lastTurn = 0;
    static int startClickCount = 0;

    TextView tv_Score;
    TextView tv_Hello;
    Button exit;
    Button sol;
    ImageView iv11, iv12, iv13, iv21, iv22, iv23, iv31, iv32, iv33, iv41, iv42, iv43;

    //red for words, blue for images
    Integer[] cards = {101, 102, 103, 201, 202, 203, 301, 302, 303, 401, 402, 403};
    ArrayList<Card> classCards = new ArrayList<>();

    Integer[] redImages = {101, 102, 103, 201, 202, 203};
    Integer[] blueWords = { 301, 302, 303, 401, 402, 403};

    int image11, image12, image13, image21, image22, image23, image31, image32, image33, image41, image42, image43;
    ArrayList<Integer> images;
    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNum = 1;
   // int turn = 1;
    int playerPoints = 0;
    ArrayList<ImageView> imArr;
    HashMap<Integer, Integer> combos = new HashMap<Integer, Integer>();

    HashMap<Integer, Card> drawbleToCard = new HashMap<Integer, Card>();

    HashMap<Integer, Integer> intToCard = new HashMap<Integer, Integer>();
  //  int cpuPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Assign Fields
        tv_Score = (TextView) findViewById(R.id.tv_Score);
        images = new ArrayList<>();

        images.add(image11);
        images.add(image12);
        images.add(image13);


        images.add(image21);
        images.add(image22);
        images.add(image23);

        images.add(image31);
        images.add(image32);
        images.add(image33);

        images.add(image41);
        images.add(image42);
        images.add(image43);
        tv_Hello = (TextView) findViewById(R.id.tv_Hello);
        iv11 = (ImageView) findViewById(R.id.iv_11);
        iv12 = (ImageView) findViewById(R.id.iv_12);
        iv13 = (ImageView) findViewById(R.id.iv_13);

        iv21 = (ImageView) findViewById(R.id.iv_21);
        iv22 = (ImageView) findViewById(R.id.iv_22);
        iv23 = (ImageView) findViewById(R.id.iv_23);

        iv31 = (ImageView) findViewById(R.id.iv_31);
        iv32 = (ImageView) findViewById(R.id.iv_32);
        iv33 = (ImageView) findViewById(R.id.iv_33);

        iv41 = (ImageView) findViewById(R.id.iv_41);
        iv42 = (ImageView) findViewById(R.id.iv_42);
        iv43 = (ImageView) findViewById(R.id.iv_43);

        imArr =  new ArrayList<>();

        imArr.add(iv11);
        imArr.add(iv12);
        imArr.add(iv13);

        imArr.add(iv21);
        imArr.add(iv22);
        imArr.add(iv23);

        imArr.add(iv31);
        imArr.add(iv32);
        imArr.add(iv33);

        imArr.add(iv41);
        imArr.add(iv42);
        imArr.add(iv43);
        //set Cards
        setCards();


        /////REAL!!!!//////
//        //set tags to images
//        setTags();
//        //set card Images
//        setImages();
//        //set hashMap
//        setMap();
        /////REAL!!!!//////


        //Collections.shuffle(Arrays.asList(cards));

        Collections.shuffle(Arrays.asList(blueWords));
        Collections.shuffle(Arrays.asList(redImages));
        tv_Hello.setBackgroundColor(Color.WHITE);
        //set red,blue cardBacks;
        // flipOnFrontAll();




  /////TESTT!!!!//////
        //set tags to images
        setTags();
        //set card Images
        setImages();
        //set hashMap
        setMap();
        //set map of ints to cards: Example- 101 --> image11
        setIntToCard();
        /////TESTT!!!!//////

        showAll2();

         exit= (Button) findViewById(R.id.exit);
        //problem with button, this is the exit button function
        sol= (Button) findViewById(R.id.solution);
        sol.setText("Start");
        sol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            //    showAll();
                if(startClickCount == 0){
                    flipOnFrontAll();
                    startClickCount++;
                    sol.setText("Solution");
                }
                else if(startClickCount == 1){
                    startClickCount++;
                    showAll();
                    sol.setText("Play Again");
                    //finish();
                //    checkFinished();
                  //  restart();
                }
                else if(startClickCount == 2){

                    restart();
                }
               // Toast.makeText(MainActivity.this, "This article is about Buttons in Android!", Toast.LENGTH_SHORT).show();
            }
        });
        exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
                Toast.makeText(MainActivity.this, "This article is about Buttons in Android!", Toast.LENGTH_SHORT).show();
            }
        });




        //sET cLICK lISTERNERS
        iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = (String) view.getTag();
               // System.out.println("STR Tag is: " + tag);
                if (tag != null) {
                    int theCard = Integer.parseInt(tag);
                    doStuff(iv11, theCard);
                }
            }
        });
        iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = (String) view.getTag();
          //      System.out.println("STR Tag is: " + tag);
                if (tag != null) {
                    int theCard = Integer.parseInt(tag);
                    doStuff(iv12, theCard);
                }
            }
        });

        iv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = (String) view.getTag();
           //     System.out.println("STR Tag is: " + tag);
                if (tag != null) {
                    int theCard = Integer.parseInt(tag);
                    doStuff(iv13, theCard);
                }
            }
        });

        iv21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = (String) view.getTag();
                System.out.println("STR Tag is: " + tag);
                if (tag != null) {
                    int theCard = Integer.parseInt(tag);
                    doStuff(iv21, theCard);
                }
            }
        });

        iv22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = (String) view.getTag();
           //     System.out.println("STR Tag is: " + tag);
                if (tag != null) {
                    int theCard = Integer.parseInt(tag);
                    doStuff(iv22, theCard);
                }
            }
        });

        iv23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = (String) view.getTag();
          //      System.out.println("STR Tag is: " + tag);
                if (tag != null) {
                    //which card in image view from 0-11 (positions)
                    int theCard = Integer.parseInt(tag);
                    doStuff(iv23, theCard);
                }
            }
        });

        iv31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = (String) view.getTag();
      //         System.out.println("STR Tag is: " + tag);
                if (tag != null) {
                    int theCard = Integer.parseInt(tag);
                    doStuff(iv31, theCard);
                }
            }
        });

        iv32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = (String) view.getTag();
          //      System.out.println("STR Tag is: " + tag);
                if (tag != null) {
                    int theCard = Integer.parseInt(tag);
                    doStuff(iv32, theCard);
                }
            }
        });

        iv33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = (String) view.getTag();
             //   System.out.println("STR Tag is: " + tag);
                if (tag != null) {
                    int theCard = Integer.parseInt(tag);
                    doStuff(iv33, theCard);
                }
            }
        });

        iv41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = (String) view.getTag();
           //     System.out.println("STR Tag is: " + tag);
                if (tag != null) {
                    int theCard = Integer.parseInt(tag);
                    doStuff(iv41, theCard);
                }
            }
        });

        iv42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = (String) view.getTag();
          //      System.out.println("STR Tag is: " + tag);
                if (tag != null) {
                    int theCard = Integer.parseInt(tag);
                    doStuff(iv42, theCard);
                }
            }
        });

        iv43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = (String) view.getTag();
          //      System.out.println("STR Tag is: " + tag);
                if (tag != null) {
                    int theCard = Integer.parseInt(tag);
                    doStuff(iv43, theCard);
                }
            }
        });
    }
    //function that DOESSTUFF when u click on card.
    //@param: ImageView: iv11-iv43
    //@param: card: int, 0-11
    private void doStuff(ImageView iv, int card) {
        try{
            //tmp is used to
            int tmp = 0;
          //  System.out.println("Card is : " + card);
            //forgot to assign variable
            tmp = card;
            if(card > 5){
                //gotta normalize card int so we can access the red/blue arrays
             //   System.out.println("Card is : " + card);
              //  tmp = card-5;
                tmp = card-6; //11-6 = 5
            }
            //System.out.println("TMP IS: " + tmp);
            //if card less than 300, we set images of regular animals
            if(cards[card] < 300 && lastTurn == 0){
                lastTurn = 1;
                if (redImages[tmp] == 101) {
                    System.out.println("setting Image num 11" );
                    iv.setImageResource(image11);
                } else if (redImages[tmp] == 102) {
                    System.out.println("setting Image num 12" );
                    iv.setImageResource(image12);
                } else if (redImages[tmp] == 103) {
                    System.out.println("setting Image num 13" );
                    iv.setImageResource(image13);
                } else if (redImages[tmp] == 201) {
                    System.out.println("setting Image num 14" );
                    iv.setImageResource(image21);
                } else if (redImages[tmp] == 202) {
                    System.out.println("setting Image num 15" );
                    iv.setImageResource(image22);
                } else if (redImages[tmp] == 203) {
                    System.out.println("setting Image num 16" );
                    iv.setImageResource(image23);
                }
            }
            //if card more than 300, we set images of words
            else if(cards[card]  > 300 && lastTurn == 1){
                lastTurn = 0;
                if (blueWords[tmp] == 301) {
                    iv.setImageResource(image31);
                } else if (blueWords[tmp] == 302) {
                    iv.setImageResource(image32);
                } else if (blueWords[tmp] == 303) {
                    iv.setImageResource(image33);
                }

                else if (blueWords[tmp] == 401) {
                    iv.setImageResource(image41);
                }

                else if (blueWords[tmp] == 402) {
                    iv.setImageResource(image42);
                }

                else if (blueWords[tmp] == 403) {
                    iv.setImageResource(image43);
                }
            }

        }
        catch(Exception e){
            System.out.println(" MESSAGE:            " + e.getMessage());;
        }

//RECHECK THIS AREA //////////////////////////////////
        //Check image selected and save in tmp
        if (cardNum == 1 && cards[card] < 300) {
          //  firstCard = cards[card];
            int tmp = 0;
            if(card > 5){
                tmp = card-6;
            }
            //choose Image
            firstCard = redImages[card];
            ///?????
//            if (firstCard > 200) {
//                firstCard = firstCard - 100;
//            }
            cardNum = 2;
            clickedFirst = card;
            iv.setEnabled(false);
        } else if (cardNum == 2 && cards[card] > 300) {
          //  secondCard = cards[card];
            int tmp = 0;
            if(card > 5){
                tmp = card-6;
            }
            //Choose Word
            secondCard = blueWords[tmp];
            ///?????
//            if (secondCard > 200) {
//                secondCard = secondCard - 100;
//            }
            cardNum = 1;
            clickedSecond = card;
            iv11.setEnabled(false);
            iv12.setEnabled(false);
            iv13.setEnabled(false);
            iv21.setEnabled(false);
            iv22.setEnabled(false);
            iv23.setEnabled(false);
            iv31.setEnabled(false);
            iv32.setEnabled(false);
            iv33.setEnabled(false);
            iv41.setEnabled(false);
            iv42.setEnabled(false);
            iv43.setEnabled(false);
            Handler cardHandler = new Handler();
            cardHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check if selected images are CORRECT
                    calculate();
                }
            }, 1000);
        }
    }


//    private int getTagInt(String s){
//        try{
//            return Integer.parseInt((String) s);
//       // }
//      //  if(s!=null){
//          //  return Integer.parseInt((String) s);
////        }
////        else{
//
//        }
//        catch(Exception e){
//            return 0;
//        }
//    }

//    private void calculate() {
//        //If images r equal remove and increase points by 1
//     //   if (firstCard == secondCard) {
//            if (clickedFirst == 0) {
//                iv11.setVisibility(View.INVISIBLE);
//            } else if (clickedFirst == 1) {
//                iv12.setVisibility(View.INVISIBLE);
//            } else if (clickedFirst == 2) {
//                iv13.setVisibility(View.INVISIBLE);
//            } else if (clickedFirst == 3) {
//                iv21.setVisibility(View.INVISIBLE);
//            } else if (clickedFirst == 4) {
//                iv22.setVisibility(View.INVISIBLE);
//            } else if (clickedFirst == 5) {
//                iv23.setVisibility(View.INVISIBLE);
//            } else if (clickedFirst == 6) {
//                iv31.setVisibility(View.INVISIBLE);
//            } else if (clickedFirst == 7) {
//                iv32.setVisibility(View.INVISIBLE);
//            } else if (clickedFirst == 8) {
//                iv33.setVisibility(View.INVISIBLE);
//            } else if (clickedFirst == 9) {
//                iv41.setVisibility(View.INVISIBLE);
//            } else if (clickedFirst == 10) {
//                iv42.setVisibility(View.INVISIBLE);
//            } else if (clickedFirst == 11) {
//                iv43.setVisibility(View.INVISIBLE);
//            }
//
//            if (clickedSecond == 0) {
//                iv11.setVisibility(View.INVISIBLE);
//            } else if (clickedSecond == 1) {
//                iv12.setVisibility(View.INVISIBLE);
//            } else if (clickedSecond == 2) {
//                iv13.setVisibility(View.INVISIBLE);
//            } else if (clickedSecond == 3) {
//                iv21.setVisibility(View.INVISIBLE);
//            } else if (clickedSecond == 4) {
//                iv22.setVisibility(View.INVISIBLE);
//            } else if (clickedSecond == 5) {
//                iv23.setVisibility(View.INVISIBLE);
//            } else if (clickedSecond == 6) {
//                iv31.setVisibility(View.INVISIBLE);
//            } else if (clickedSecond == 7) {
//                iv32.setVisibility(View.INVISIBLE);
//            } else if (clickedSecond == 8) {
//                iv33.setVisibility(View.INVISIBLE);
//            } else if (clickedSecond == 9) {
//                iv41.setVisibility(View.INVISIBLE);
//            } else if (clickedSecond == 10) {
//                iv42.setVisibility(View.INVISIBLE);
//            } else if (clickedSecond == 11) {
//                iv43.setVisibility(View.INVISIBLE);
//
//            }
//            //CALCULATE HERE IF ITS TRUE, IF NOT SET THEM TO VISIBLE AGAIN
//
////        if(isMatch(cards[clickedFirst],cards[clickedSecond])){
////            playerPoints++;
////        }
//        if(isMatch(getImageResource(clickedFirst),getImageResource(clickedSecond))){
//            playerPoints++;
//        }
//
//                tv_Score.setText("Score: " + playerPoints);
//
//
//                iv11.setEnabled(true);
//            iv12.setEnabled(true);
//            iv13.setEnabled(true);
//
//            iv21.setEnabled(true);
//            iv22.setEnabled(true);
//            iv23.setEnabled(true);
//
//            iv31.setEnabled(true);
//            iv32.setEnabled(true);
//            iv33.setEnabled(true);
//
//            iv41.setEnabled(true);
//            iv42.setEnabled(true);
//            iv43.setEnabled(true);
//            //Check if game is finished
//            checkFinished();
//    }



    private void calculate() {
       // if (cardNum == 2) {
            int firstDrawable = getImageResource2(clickedFirst);
            int secondDrawable = getImageResource2(clickedSecond);

            if (isMatch2(firstDrawable, secondDrawable)) {
                // The drawables match, so you can perform your logic here (e.g., increase points, hide cards).
                            if (clickedFirst == 0) {
                iv11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv23.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                iv33.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                iv41.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                iv42.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                iv43.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                iv11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv23.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                iv33.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                iv41.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                iv42.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                iv43.setVisibility(View.INVISIBLE);

            }

                playerPoints++;
                tv_Score.setText("Score: " + playerPoints);
                System.out.println("player points in calc hit");

                // Implement your logic to hide or perform other actions on matching cards here.
                // For example, you can set the visibility of the matching image views to INVISIBLE.

                // Check if the game is finished
                checkFinished();
            } else {
                // The drawables do not match, so you can perform your logic here (e.g., flip the cards back).
                // Implement your logic to flip the cards back or perform other actions on non-matching cards here.
                // For example, you can reset the image resource of the non-matching image views.

                // Reset the image resources of non-matching image views
                System.out.println("reset in calc hit");
                resetImageViews(imArr.get(clickedFirst),0);
                resetImageViews(imArr.get(clickedSecond),1);
            }

            // Reset cardNum and enable all cards for the next turn
            cardNum = 1;
            enableAllCards(true);
        }
  //  }
            //0 for red, 1 for blue
    private void resetImageViews(ImageView imageView,int color) {
        // Replace the following lines with the appropriate logic for resetting non-matching cards.
        // For example, set the image resource to a default card back image resource.
        if(color==0){
            imageView.setImageResource(R.drawable.red);
        }
        else{
            imageView.setImageResource(R.drawable.blue); // Replace 'card_back' with your default card image.
        }

    }
    //function to check if Game is Over
    private void checkFinished(){
        boolean finished = true;
    for(int i=0; i < imArr.size();i++){
        if(imArr.get(i).getVisibility()!=View.INVISIBLE){
            finished = false;
        }
    }
    if(finished){
        System.out.println("GAME IS FINISHED!!!!!!! \n");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setMessage("Congratulations!. Score: " + playerPoints).setCancelable(false).setPositiveButton("NEW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }).setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    }

    private void restart(){


            System.out.println("GAME IS FINISHED!!!!!!! \n");
            //AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            //alertDialogBuilder.setMessage("Congratulations!. Score: " + playerPoints).setCancelable(false).setPositiveButton("NEW", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
            startClickCount = 0;
                   // sol.setText("Play Again");
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
               // }
//            }).setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    finish();
//                }
//            });
            //AlertDialog alertDialog = alertDialogBuilder.create();
          //  alertDialog.show();
    }


    //Shows image behind card
private void showAll(){
//        for(int i = 0; i < imArr.size();i++){
//            imArr.get(i).setImageResource(images.get(i));
//        }

    //if card less than 300, we set images of regular animals

            iv11.setImageResource(image11);
            iv12.setImageResource(image12);
            iv13.setImageResource(image13);

    iv21.setImageResource(image21);
    iv22.setImageResource(image22);
    iv23.setImageResource(image23);

    iv31.setImageResource(image31);
    iv32.setImageResource(image32);
    iv33.setImageResource(image33);

    iv41.setImageResource(image41);
    iv42.setImageResource(image42);
    iv43.setImageResource(image43);
}



    //Shows image behind card
    private void showAll2(){
        for(int i = 0; i < imArr.size();i++){
            if(i < 6){
                imArr.get(i).setImageResource(intToCard.get(redImages[i]));
            }
            else if(i >= 6){
                imArr.get(i).setImageResource(intToCard.get(blueWords[i-6]));
            }
        }
    }


        //Function to set Images
        private void setImages(){
        //10-20 Animal Cards
        image11 = R.drawable.bear;

        image12 = R.drawable.beaver1;
        image13 = R.drawable.bee;

        image21 = R.drawable.cat;
        image22 = R.drawable.chicken1;
        image23 = R.drawable.dog;

        //30-40 text cards
//        image31 = R.drawable.elephant;
//        image32 = R.drawable.giraffe;
//        image33 = R.drawable.goat;
//
//
//        image41 = R.drawable.grasshopper;
//        image42 = R.drawable.lion;
//        image43 = R.drawable.monkey;
            image31 = R.drawable.bear_word;
            image32 = R.drawable.beaver_word;
            image33 = R.drawable.bee_card;


            image41 = R.drawable.cat_word;
            image42 = R.drawable.chicken_word;
            image43 = R.drawable.dog_word;

    }


    private void flipOnFrontAll(){
        //Images
        iv11.setImageResource(R.drawable.red);
        iv12.setImageResource(R.drawable.red);
        iv13.setImageResource(R.drawable.red);

        iv21.setImageResource(R.drawable.red);
        iv22.setImageResource(R.drawable.red);
        iv23.setImageResource(R.drawable.red);


        //WORDS
        iv31.setImageResource(R.drawable.blue);
        iv32.setImageResource(R.drawable.blue);
        iv33.setImageResource(R.drawable.blue);


        iv41.setImageResource(R.drawable.blue);
        iv42.setImageResource(R.drawable.blue);
        iv43.setImageResource(R.drawable.blue);
    }
    //Function to set Tags
    private void setTags(){

        //Set Image Tags

        //red images 0-5
        iv11.setTag("0");
        iv12.setTag("1");
        iv13.setTag("2");

        iv21.setTag("3");
        iv22.setTag("4");
        iv23.setTag("5");
        //blue words
        iv31.setTag("6");
        iv32.setTag("7");
        iv33.setTag("8");

        iv41.setTag("9");
        iv42.setTag("10");
        iv43.setTag("11");

    }
    private void setMap(){
        combos.put(R.drawable.bear,R.drawable.bear_word);
        combos.put(R.drawable.beaver1,R.drawable.beaver_word);
        combos.put(R.drawable.bee,R.drawable.bee_card);
        combos.put(R.drawable.cat,R.drawable.cat_word);
        combos.put(R.drawable.chicken1,R.drawable.chicken_word);
        combos.put(R.drawable.dog,R.drawable.dog_word);


        combos.put(R.drawable.bear,R.drawable.bear_word);
        combos.put(R.drawable.beaver1,R.drawable.beaver_word);
        combos.put(R.drawable.bee,R.drawable.bee_card);
        combos.put(R.drawable.cat,R.drawable.cat_word);
        combos.put(R.drawable.chicken1,R.drawable.chicken_word);
        combos.put(R.drawable.dog,R.drawable.dog_word);



    }

        private void setIntToCard(){
            intToCard.put(101,image11);
            intToCard.put(102,image12);
            intToCard.put(103,image13);

            intToCard.put(201,image21);
            intToCard.put(202,image22);
            intToCard.put(203,image23);

            intToCard.put(301,image31);
            intToCard.put(302,image32);
            intToCard.put(303,image33);

            intToCard.put(401,image41);
            intToCard.put(402,image42);
            intToCard.put(403,image43);
        }

    //Function that adds cards and number pairs to hashMap
    private void setCards(){
        Card bear = new Card(R.drawable.bear,1,R.drawable.bear_word);
        Card bearWord = new Card(R.drawable.bear_word,11,R.drawable.bear);
        classCards.add(bear);
        classCards.add(bearWord);

        Card beaver = new Card(R.drawable.beaver1,2,R.drawable.beaver_word);
        Card beaverWord = new Card(R.drawable.beaver_word,12,R.drawable.beaver1);
        classCards.add(beaver);
        classCards.add(beaverWord);

        Card bee = new Card(R.drawable.bee,3,R.drawable.bee_card);
        Card beeWord = new Card(R.drawable.bee_card,13,R.drawable.bee);
        classCards.add(bee);
        classCards.add(beeWord);

        Card cat = new Card(R.drawable.cat,4,R.drawable.cat_word);
        Card catWord = new Card(R.drawable.cat_word,14,R.drawable.cat);
        classCards.add(cat);
        classCards.add(catWord);

        Card chicken = new Card(R.drawable.chicken1,5,R.drawable.chicken_word);
        Card chickenWord = new Card(R.drawable.chicken_word,15,R.drawable.chicken1);
        classCards.add(chicken);
        classCards.add(chickenWord);

        Card dog = new Card(R.drawable.dog,6,R.drawable.dog_word);
        Card dogWord = new Card(R.drawable.dog_word,16,R.drawable.dog);
        classCards.add(dog);
        classCards.add(dogWord);
    }
    //function to check if correct match
//    private boolean isMatch(int imageImage, int wordImage){
//        if(imageImage==0){
//            System.out.println("image int null");
//        }
//        if(wordImage==0){
//            System.out.println("word int null");
//        }
//
//        System.out.println("Image in ISMATCH IS: " + imageImage + "word is: " + wordImage);
//        Integer word = combos.get(imageImage);
//        System.out.println("Integer WORD from hash  IS: " + word + "word is: " + wordImage);
//        if(word!=null){
//            if(wordImage == word ){
//                return true;
//            }
//        }
//        System.out.println("Word is null");
//
//        return false;
//    }

    private boolean isMatch(int drawable, int wordDrawable) {
       // Integer word = combos.get(drawable);
        Card imageCard = new Card(0,0,1);
        Card wordCard = new Card(1,1,0);
        boolean found = false;
        boolean found2 = false;
        for(int i = 0; i < classCards.size();i++){
            if(found && found2){
                break;
            }
            if(classCards.get(i).getDrawableResourceId() ==drawable){
                imageCard = classCards.get(i);
                found  =true;
            }
            if(classCards.get(i).getDrawableResourceId() ==wordDrawable){
                wordCard = classCards.get(i);
                found2  =true;
            }

        }
        //check condition

            System.out.println("Word ID : " + wordCard.getID());
            System.out.println("Image ID : " + imageCard.getID());

        System.out.println("Word wordDrawbleID : " + wordCard.getDrawableResourceId());
        System.out.println("Image drawbleID : " + imageCard.getDrawableResourceId());
            return imageCard.comparePartnerID(wordCard);

        //return word != null && word == wordDrawable;
    }

    private boolean isMatch2(int drawable, int wordDrawable) {
  return wordDrawable-200 == drawable;
    }

    private int getImageResource(int clickedFirst){
        if(clickedFirst  == 0){
            return image11;
           // return redImages[clickedFirst];
        }
        else if(clickedFirst==1){
            return image12;
            //return redImages[clickedFirst];
        }
        else if(clickedFirst==2){
            return image13;
            //return redImages[clickedFirst];
        }

        else if(clickedFirst==3){
            return image21;
           // return redImages[clickedFirst];
        }
        else if(clickedFirst==4){
            return image22;
          //  return redImages[clickedFirst];
        }
        else if(clickedFirst==5){
            return image23;
           // return redImages[clickedFirst];
        }
        else if(clickedFirst==6){
           return image31;
            //return blueWords[clickedFirst-6];
        }
        else if(clickedFirst==7){
            return image32;
            //return blueWords[clickedFirst-6];
        }
        else if(clickedFirst==8){
            return image33;
           // return blueWords[clickedFirst-6];
        }
        else if(clickedFirst==9){
            return image41;
            //return blueWords[clickedFirst-6];
        }
        else if(clickedFirst==10){
            return image42;
            //return blueWords[clickedFirst-6];
        }
        else if(clickedFirst==11){
            return image43;
           // return blueWords[clickedFirst-6];
        }


        return 0;
    }


    private int getImageFromInt(int ID){
        return intToCard.get(ID);
        }

    private int getImageResource2(int clickedFirst) {
        if (clickedFirst < 6) {


            return redImages[clickedFirst];
        }
        return blueWords[clickedSecond-6];
    }

    private void enableAllCards(boolean enabled) {
        for (ImageView imageView : imArr) {
            imageView.setEnabled(enabled);
        }
    }

}