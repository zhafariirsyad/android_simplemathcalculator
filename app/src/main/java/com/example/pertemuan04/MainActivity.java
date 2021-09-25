package com.example.pertemuan04;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createRandomAndShowQuestion();
    }

    int randomWithRange(int min, int max){

        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    private void createRandomAndShowQuestion(){
        TextView questionTxtView = findViewById(R.id.questionTxtView);
        int firstNumber = randomWithRange(10,100);
        int secondNumber = randomWithRange(10,firstNumber - 1);
        correctAnswer = firstNumber - secondNumber;

        String question = String.format("%d - %d",firstNumber,secondNumber);
        questionTxtView.setText(question);
    }

    public void clickAnswerButton(View v){
        evaluation();
    }

    private void evaluation(){
        EditText answerEditText = findViewById(R.id.answerText);
        TextView contentEvaluation = findViewById(R.id.contentEvaluationTxtView);
        int answer = Integer.parseInt(answerEditText.getText().toString());
        if(answer == correctAnswer){
            contentEvaluation.setText("Jawaban benar");
            contentEvaluation.setTextColor(Color.parseColor("#47A868"));
        }else{
            String wrongAnswer = String.format("Jawaban salah, seharusnya %d",correctAnswer);
            contentEvaluation.setText(wrongAnswer);
            contentEvaluation.setTextColor(Color.RED);
        }

        createRandomAndShowQuestion();

        answerEditText.setText("");
    }
}