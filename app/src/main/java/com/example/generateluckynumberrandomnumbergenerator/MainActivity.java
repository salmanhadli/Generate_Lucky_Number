package com.example.generateluckynumberrandomnumbergenerator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> {
            String userName = editText.getText().toString();

            if (userName.length() > 0) {
                // Explicit Intent
                Intent i = new Intent(getApplicationContext(), LuckyNumberActivity.class);

                // Passing the name to second activity
                i.putExtra("name", userName);

                startActivity(i);
            } else {
                Toast.makeText(MainActivity.this, "Please Enter your name", Toast.LENGTH_SHORT).show();
            }


        });
    }
}