package com.example.flagquiz;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    private Button submit, nextFlag, newGame;
    CountryReader readCountries;
    String currentCountry = "";
    int currentScore = 0;
    int guessed = 0;
    Spinner countrySpinner;
    TextView resultText;
    ImageView flagImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            new couchBaseReader(this);
        readCountries = new CountryReader(this.getApplicationContext());
        setContentView(R.layout.activity_main);
        countrySpinner = findViewById(R.id.countrySpinner);
        fillCountryComboBox(countrySpinner);
        submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(this);
        nextFlag = findViewById(R.id.nextFlagButton);
        nextFlag.setOnClickListener(this);
        newGame = findViewById(R.id.newGameButton);
        newGame.setOnClickListener(this);
        resultText = findViewById(R.id.resultText);
        flagImage = findViewById(R.id.flagImage);
        nextFlagEvent();
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
        readCountries.fillCountryArray();
        // Adds the countries to the combo box
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, readCountries.constantCountryNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(arrayAdapter);
        System.out.println(readCountries.countryNames);


    }

    private void nextFlagEvent() {
        currentCountry = readCountries.randomizeCountryLabel();
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
            resultText.setText("All done!\nFinal score: " + currentScore + "/" + guessed);
            nextFlag.setEnabled(false);
            newGame.setEnabled(true);
        }


    }

    private void submitGuessEvent() {
        guessed++;
        if (countrySpinner.getSelectedItem().toString().equals(currentCountry)) {
            currentScore++;
            resultText.setText("You are correct!\nCurrent score " + currentScore + "/" + guessed);
        } else {
            resultText.setText("You are wrong!\nCurrent score " + currentScore + "/" + guessed);
        }
        submit.setEnabled(false);
        nextFlag.setEnabled(true);
    }

    private void newGameEvent() {
        readCountries.fillCountryArray();
        nextFlagEvent();
        currentScore = 0;
        guessed = 0;
        submit.setEnabled(true);
        newGame.setEnabled(false);
        resultText.setText("");

    }
}

