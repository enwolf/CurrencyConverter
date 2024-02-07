package com.college.converter;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.college.converter.databinding.ActivityMainBinding;

/*
    TODOs:
    In groups of 4, complete the following tasks, 1 for each team member:
    1. Extract all the strings into the strings.xml file and use them in the layout and the activity
    2. Change the theme of the app to a NoActionBar theme and modify the primary colors
    3. Add Log messages at the entry/exit of onCreate() and convertCurrency methods. Level should be Info
    4. Add ViewBinding to the project

    ** Each task must be done in a separate branch and merged to the main branch
    after completion using a Pull Request.
    ** Each task must be done by a different team member.

*/

public class MainActivity extends AppCompatActivity {

    static private final Float CONVERSION_RATE = 0.80F;
    private ActivityMainBinding variableBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i(TAG, "Entering onCreate()");
        super.onCreate(savedInstanceState);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        Button buttonConvert = variableBinding.convertButton;

        buttonConvert.setOnClickListener( view ->  {
            convertCurrency(view);

        } );
        Log.i(TAG, "Exiting onCreate()");
    }

    public void convertCurrency(View view)
    {
        Log.i(TAG, "Entering convertCurrency class");

        EditText inputView = variableBinding.entryId;
        String inputAmount = variableBinding.entryId.getText().toString();
        TextView resultView = variableBinding.resultId;

        if (!inputAmount.isEmpty()) {

            Float inputAmountDecimal = Float.valueOf(inputAmount);
            Float resultFloat = inputAmountDecimal * CONVERSION_RATE;
            resultView.setText( resultFloat + " Euros" );
        }
        Log.i(TAG, "Exiting convertCurrency class");
    }
}