package com.example.flagquiz;

import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class currentGame {
    private int questionsAsked = 0;
    private int questionsCorrect = 0;
    private String currentItem;
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<String> itemNames = new ArrayList<>();
    public currentGame(ArrayList<Item> items){
        this.items = items;
        System.out.println(items.size());
        System.out.println("items arraylist 1st item contains: " + items.get(0).getName());

    }
    public void fillItemNames(){
        items.trimToSize();
        for (int i = 0; i < items.size(); i++){
            items.get(i).printQuizItem();
            itemNames.add(items.get(i).getName());
            System.out.println(i);
        }
    }
    public String randomItem(){
        Random rand = new Random();
        if (itemNames.isEmpty()){
            return "";
        }
        int randomIndex = rand.nextInt(itemNames.size());
        currentItem = itemNames.get(randomIndex);
        itemNames.remove(randomIndex);
        itemNames.trimToSize();
        questionsAsked++;
        return currentItem;
    }
    public boolean checkItem(String guessedItem){
        if (guessedItem.equals(currentItem)){
            questionsCorrect++;
            return true;
        }
        else{
            return false;
        }

    }
    public void setCurrentItem(String currentItem){
        this.currentItem = currentItem;
    }
    public void setQuestionsAsked(int questionsAsked){
        this.questionsCorrect = questionsAsked;
    }
    public void setQuestionsCorrect(int questionsCorrect){
        this.questionsCorrect = questionsCorrect;
    }
    public String getCurrentItem(){
        return currentItem;
    }
    public int getQuestionsAsked(){
        return questionsAsked;
    }
    public int getQuestionsCorrect(){
        return questionsCorrect;
    }

}
