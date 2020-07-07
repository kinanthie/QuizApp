package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private QuestionBank mQuestionLibrary = new QuestionBank();
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);
        UpdateQuestion();

        UpdateScore(mScore);


    }

    private void UpdateQuestion() {
        if (mQuestionNumber<mQuestionLibrary.getLength()) {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber, 4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        else {
            Toast.makeText(MainActivity.this, "Ini pertanyaan terakhir!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, HighScore.class);
            intent.putExtra("score", mScore);
            startActivity(intent);
        }
    }

    private void UpdateScore(int point) {
        mScoreView.setText("" + mScore+"/"+mQuestionLibrary.getLength() );
    }

    public void onClick(View view) {
        Button answer = (Button) view;

        if (answer.getText() == mAnswer) {
            mScore = mScore + 1;
            Toast.makeText(MainActivity.this, "Benar!", Toast.LENGTH_LONG).show();
        }else
            Toast.makeText(MainActivity.this, "Salah!", Toast.LENGTH_LONG).show();

        UpdateScore(mScore);
        UpdateQuestion();
    }
}
