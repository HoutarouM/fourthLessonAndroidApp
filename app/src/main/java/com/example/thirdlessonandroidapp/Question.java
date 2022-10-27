package com.example.thirdlessonandroidapp;

import java.util.ArrayList;

public class Question {
    public static ArrayList<Question> questions = new ArrayList<>();


    private int questionText;
    private ArrayList<Integer> answers = new ArrayList<>();
    private int imageId;
    private String hint;
    private int correctAnswerId;


    public Question(int questionText, int imageId, int odpA, int odpB, int odpC, String hint, int correctAnswerId) {
        this.questionText = questionText;

//        add answers
        answers.add(odpA);
        answers.add(odpB);
        answers.add(odpC);

        this.imageId = imageId;
        this.hint = hint;
        this.correctAnswerId = correctAnswerId;
    }

    public static void addQuestions() {
        questions.add(new Question(R.string.Question, R.drawable.photo, R.string.everest, R.string.tatry, R.string.wielka_racza, "Gora", 2));
        questions.add(new Question(R.string.Question2, R.drawable.git, R.string.git, R.string.github, R.string.gitlab, "g", 1));
        questions.add(new Question(R.string.Question3, R.drawable.python, R.string.python, R.string.js, R.string.rust, "r", 1));
        questions.add(new Question(R.string.Question4, R.drawable.mvc, R.string.warstwowa, R.string.mikroserwisy, R.string.mvc, "m", 3));
        questions.add(new Question(R.string.Question5, R.drawable.react, R.string.react, R.string.angular, R.string.vue, "r", 1));
    }

    public int getQuestionText() {
        return questionText;
    }

    public void setQuestionText(int questionText) {
        this.questionText = questionText;
    }

    public ArrayList<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Integer> answers) {
        this.answers = answers;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getCorrectAnswerId() {
        return correctAnswerId;
    }

    public void setCorrectAnswerId(int correctAnswerId) {
        this.correctAnswerId = correctAnswerId;
    }

    public boolean isCorrectAnswer(int answer) {
        if (this.correctAnswerId == answer) {
            return true;
        } else {
            return false;
        }
    }
}
