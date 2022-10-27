package com.example.thirdlessonandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizEnd extends AppCompatActivity {
    TextView textView;
    Button restartBtn;

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_end);

        textView = findViewById(R.id.score);
        restartBtn = findViewById(R.id.restart_btn);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            this.score = data.getInt("score");
        }

        textView.setText("Wynik: " + this.score);

        restartBtn.setOnClickListener(view -> {
            Intent intent = new Intent(QuizEnd.this, MainActivity.class);

            startActivity(intent);
        });
    }
}