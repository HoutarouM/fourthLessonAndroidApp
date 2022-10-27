package com.example.thirdlessonandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    intencje jawne zawsze dozwolone
//    niejawne potrzebuja zezwolenie

    ImageView imageView;

    TextView questionTextView;

    RadioButton rBtnAnswerA;
    RadioButton rBtnAnswerB;
    RadioButton rBtnAnswerC;

    Button checkBtn;
    Button hintBtn;

    RadioGroup answers;

    ArrayList<Question> questions;

    int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Question.addQuestions();
        questions = Question.questions;

        getViews();

        setQuestionDataToViews(questionIndex);

        checkBtn.setOnClickListener(view -> {
            if (checkAnswer(questions.get(questionIndex).getCorrectAnswerId())) {
                if (questionIndex + 1 < questions.size()) {
                    questionIndex++;

                    setQuestionDataToViews(questionIndex);
                } else {
                    Toast.makeText(MainActivity.this, "Ostatnie pytanie", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, R.string.bad_answer, Toast.LENGTH_SHORT).show();
            }
        });

        hintBtn.setOnClickListener(view -> {
//            intencja jawna, wiadomo skad do kad
            Intent intent = new Intent(MainActivity.this, HintActivity.class);

            startActivity(intent);
        });
    }

    private void getViews() {
        imageView = findViewById(R.id.image_view);

        questionTextView = findViewById(R.id.text_view);

        rBtnAnswerA = findViewById(R.id.radioButton);
        rBtnAnswerB = findViewById(R.id.radioButton2);
        rBtnAnswerC = findViewById(R.id.radioButton3);

        checkBtn = findViewById(R.id.button);
        hintBtn = findViewById(R.id.button2);
    }

    private void setQuestionDataToViews(int i) {
        Question q = questions.get(i);

        imageView.setImageResource(q.getImageId());
        imageView.setContentDescription(q.getHint());
        questionTextView.setText(q.getQuestionText());
        rBtnAnswerA.setText(q.getAnswers().get(0));
        rBtnAnswerB.setText(q.getAnswers().get(1));
        rBtnAnswerC.setText(q.getAnswers().get(2));
    }


    private boolean checkAnswer(int correctAnswerId) {
        answers = findViewById(R.id.radio_group);

        int answerId = answers.getCheckedRadioButtonId();

        if (answerId == R.id.radioButton) {
            answerId = 1;
        }

        if (answerId == R.id.radioButton2) {
            answerId = 2;
        }

        if (answerId == R.id.radioButton3) {
            answerId = 3;
        }

        if (answerId == correctAnswerId) {
            return true;
        } else {
            return false;
        }
    }
}