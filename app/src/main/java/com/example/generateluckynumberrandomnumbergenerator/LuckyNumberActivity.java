package com.example.generateluckynumberrandomnumbergenerator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    TextView resultText;
    Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        resultText = findViewById(R.id.resultText);
        shareBtn = findViewById(R.id.shareBtn);

        // Implicit Intent
        Intent i = getIntent();
        String userName = i.getStringExtra("name");
        int randomNumberGenerated = generateRandomNumber();
        resultText.setText("" + randomNumberGenerated);

//        shareBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                shareData();
//            }
//        });

        shareBtn.setOnClickListener(v -> shareData(userName, randomNumberGenerated));
    }

    public int generateRandomNumber() {
        Random random = new Random();
        int upperLimit = 1000;
        int randomNumber = random.nextInt(upperLimit);
        return randomNumber;
    }

    public void shareData(String userName, int number) {
        // Implicit Intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        String num = String.valueOf(number);
        i.putExtra(Intent.EXTRA_SUBJECT, userName + " got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, "His/Her lucky number is: " + num);

        startActivity(Intent.createChooser(i, "Choose a platform"));

    }
}