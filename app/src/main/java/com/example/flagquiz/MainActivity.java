package com.example.flagquiz;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    private Button submit, nextFlag, newGame;
    //CountryReader readCountries;
    String currentCountry = "";
    int currentScore = 0;
    int guessed = 0;
    Spinner countrySpinner;
    TextView resultText;
    ImageView flagImage;
    Spinner catagories;
    ArrayList<Quiz> quizList;
    currentGame thisGame ;
    int quizTypeIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            new couchBaseReader(this);
        JsonReader reader = new JsonReader(this);
        quizList = reader.readJson();
       // readCountries = new CountryReader(this.getApplicationContext());
        setContentView(R.layout.activity_main);
        countrySpinner = findViewById(R.id.itemSpinner);
        //fillCountryComboBox(countrySpinner);
        submit = findViewById(R.id.submitButton);
        submit.setEnabled(false);
        submit.setOnClickListener(this);
        nextFlag = findViewById(R.id.nextFlagButton);
        nextFlag.setEnabled(false);
        nextFlag.setOnClickListener(this);
        newGame = findViewById(R.id.newGameButton);
        newGame.setEnabled(true);
        newGame.setOnClickListener(this);
        resultText = findViewById(R.id.resultText);
        flagImage = findViewById(R.id.flagImage);
        catagories = findViewById(R.id.gameTypeSpinner);
        fillCatagoryComboBox(catagories, quizList);
        System.out.println("Quizlist arraylist contains: " + quizList);

    }

    private void fillCatagoryComboBox(Spinner catagories, ArrayList<Quiz> quizList) {
        for (int i = 0; i < quizList.size(); i++) {


            ArrayList<String> catagoryList = new ArrayList<>();
            for (Map.Entry<String, ArrayList<Item>> entry : quizList.get(i).getQuiz().entrySet()) {
                catagoryList.add(entry.getKey());
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, catagoryList);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            catagories.setAdapter(arrayAdapter);

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submitButton:
                submitGuessEvent();
                break;
            case R.id.nextFlagButton:
                nextFlagEvent();
                break;
            case R.id.newGameButton:
                newGameEvent();
                break;


        }
    }

    private void fillCountryComboBox(Spinner countrySpinner) {

        // Fills the country Array
        // Adds the countries to the combo box
        ArrayList<String> newList = new ArrayList<>(thisGame.itemNames);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, newList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(arrayAdapter);
        System.out.println(thisGame.itemNames);


    }

    private void nextFlagEvent() {
        currentCountry = thisGame.randomItem();
        if (!currentCountry.isEmpty()) {
            String withoutSpace = currentCountry.replaceAll("\\s", "_").toLowerCase();
            System.out.println(withoutSpace);
            int resID = this.getResources().getIdentifier(withoutSpace, "drawable", getPackageName());
            //int resID = this.getResources().getIdentifier("usa", "drawable", getPackageName());
            System.out.println(resID);
            flagImage.setImageResource(resID);
            nextFlag.setEnabled(false);
            submit.setEnabled(true);
        } else {
            resultText.setText("All done!\nFinal score: " + thisGame.getQuestionsCorrect() + "/" + thisGame.getQuestionsAsked());
            nextFlag.setEnabled(false);
            newGame.setEnabled(true);
            catagories.setEnabled(true);
        }


    }

    private void submitGuessEvent() {
        guessed++;
        if (thisGame.checkItem(countrySpinner.getSelectedItem().toString())){
            resultText.setText("You are correct!");
        }
        else{
            resultText.setText("WRONG!!!");
        }
        submit.setEnabled(false);
        nextFlag.setEnabled(true);
    }

    private void newGameEvent() {
        String gameType = catagories.getSelectedItem().toString();
        thisGame = new currentGame(quizList.get(quizTypeIndex).getQuiz().get(gameType)); // Write to accomodate more than one quiz
        thisGame.fillItemNames();
        fillCountryComboBox(countrySpinner);
        nextFlagEvent();
        currentScore = 0;
        guessed = 0;
        submit.setEnabled(true);
        newGame.setEnabled(false);
        catagories.setEnabled(false);
        resultText.setText("");
        nextFlagEvent();


    }
}

