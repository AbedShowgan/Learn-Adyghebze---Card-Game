package com.example.circassianwords_cardgame;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
public class Parser {


    //File Example:  ////////////////////////////////////////////////////////
//
//    {
//        "father": "ты; ятэ; тат (dad)"
//    },
//    {
//        "mother": "ны; янэ; нан (mom)"
//    },
//    {
//        "dad": "татэ"
//    },
//    {
//        "mom": "нанэ"
//    },
//    {
//        "spoon": "джэмышх"
//    },
//    {
//        "teaspoon": "щайджэмышх; чайджэмышх"
    ////////////////////////////////////////////////////////
    private static char[] parentheses = new char[] { '(', ')', '[', ']', '{', '}' };
    private static char[] separators = new char[] {  ',', ';', '\'',':','"'};
    private static char geresh = '"';
    private ArrayList<String> englishWords;
    private ArrayList<String> adygheWords;
    private HashMap<String,String> words;
    private String path;
    private File file;
 //   private Scanner sc;
    //Constructor receiving file path
    public Parser(String path) throws FileNotFoundException{
            this.path = path;
            this.file = new File(path);
        englishWords = new ArrayList<String>();
        adygheWords = new ArrayList<String>();
        words = new HashMap<String,String>() ;
            //Prepare list of English Words
        setEnglish();
        //this.sc = new Scanner(file);
    }





    public String getAdygheWord(String english){

        if(english !=null){
            String ans = null;
            ans =  words.get(english);
            if(ans !=null){
                return ans;
            }
        }
       return "EnglishWord Not Found";
    }
    //Returns English-Adyghe words map
    public HashMap<String,String> getMap(){
        return null;
    }

    //Returns English words list
    public ArrayList<String> getEnglish(){
        return null;
    }
    //Returns Adyghe words list
    public ArrayList<String> getAdyghe(){
        return null;
    }

    //      returns index of next geresh
    //Param: String str, and count index of geresh
    public int nextGeresh(String str,int count){
        int index = 0;
        int counter = 0;
        for (int i=0; i < str.length(  ); i++){
            index++;
            if(str.charAt(i)=='"')
                counter++;
            if(counter==count)
                return index;
        }
           return -1;
    }





    //Sets up English List of words
    private void setEnglish() throws FileNotFoundException{
        //Use new Scanner everytime
        Scanner sc = new Scanner(this.file);
        String word;
        while(sc.hasNextLine()){
            //get next line
            String line = sc.nextLine();
            //trim whitespace
            line.trim();
            //we encountered word;

            if(line.charAt(0)==(geresh)){
                int indexNextGeresh = nextGeresh(line,2);
                //trim english word
                if(indexNextGeresh != -1){
                    word  = line.substring(0,indexNextGeresh+1);
                    englishWords.add(word);
                }
                else{
                    throw new RuntimeException("Format Error");
                }

            }
        }
    }

    //Sets up Adyghe List of words
    private void setAdyghe() throws FileNotFoundException{
        //Use new Scanner everytime
        Scanner sc = new Scanner(this.file);
        String word;
        while(sc.hasNextLine()){
            //get next line
            String line = sc.nextLine();
            //trim whitespace
            line.trim();
            //we encountered word;

            if(line.charAt(0)==(geresh)){
                int wordStart = nextGeresh(line,3);
                int wordEnd = nextGeresh(line,4);
                //trim english word
                if(wordStart != -1){
                    word  = line.substring(wordStart+1,wordEnd+1);
                    adygheWords.add(word);
                }
                else{
                    throw new RuntimeException("Format Error");
                }

            }
        }
    }

}
