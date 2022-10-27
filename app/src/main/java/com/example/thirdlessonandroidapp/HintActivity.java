package com.example.thirdlessonandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HintActivity extends AppCompatActivity {
    ArrayList<Question> questions;

    int questionIndex;

    TextView qTextView;
    TextView hTextView;

    Button areYouSureBtn;
    Button returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        questions = Question.questions;

        setContentView(R.layout.activity_hint);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            this.questionIndex = data.getInt("questionIndex");
        }

        qTextView = findViewById(R.id.qTextView);
        hTextView = findViewById(R.id.hintTextView);

        qTextView.setText(questions.get(questionIndex).getQuestionText());
        hTextView.setText(questions.get(questionIndex).getHint());

        areYouSureBtn = findViewById(R.id.areYouSure);
        returnBtn = findViewById(R.id.button3);

        returnBtn.setVisibility(View.INVISIBLE);

        areYouSureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hTextView.setVisibility(View.VISIBLE);

                areYouSureBtn.setVisibility(View.INVISIBLE);

                returnBtn.setVisibility(View.VISIBLE);
            }
        });

        returnBtn.setOnClickListener(view -> {
            Intent intent = new Intent();

            setResult(RESULT_OK, intent);

            finish();
        });
    }
}