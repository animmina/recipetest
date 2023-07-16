package com.example.blogtest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Scanner;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private Button submitButton;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        submitButton = findViewById(R.id.submitButton);
        outputText = findViewById(R.id.outputText);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = inputText.getText().toString();
                outputText.setText("You entered: " + userInput);
            }
        });
    }
}