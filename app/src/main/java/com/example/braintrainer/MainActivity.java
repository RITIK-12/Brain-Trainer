package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView resultTextView;
    TextView scoreTextView;
    TextView timerTextView;
    TextView sumTextView;
    int locationOfCorrectAnswer;
    Button goButton;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int score;
    int numberOfQuestions;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgainButton;
    ConstraintLayout gameLayout;



    public  void  start(View view){
        goButton.setVisibility(View.INVISIBLE);
        playAgain(findViewById(R.id.timerTextView));
        gameLayout.setVisibility(View.VISIBLE);
    }
    public void chooseAnswer(View view){

        if(Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())){
            resultTextView.setText("   Correct !! :-) ");
            score++;

        }
        else{
            resultTextView.setText("     Wrong !! :-( ");

        }

        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score) + " / "+ Integer.toString(numberOfQuestions));
        newQuestion();
    }
    public  void  newQuestion(){
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        sumTextView.setText(Integer.toString(a) + " + "  + Integer.toString(b));
        locationOfCorrectAnswer = rand.nextInt(4);
        scoreTextView.setText(Integer.toString(score) + " / "+ Integer.toString(numberOfQuestions));
        answers.clear();
        for(int i =0;i<4;i++){
            if(i==locationOfCorrectAnswer){
                answers.add(a+b);
            }
            else{
                int wrongAnswer = rand.nextInt(41);
                while (wrongAnswer== a+b){
                    wrongAnswer = rand.nextInt(41);
                }
                answers.add(wrongAnswer);

            }





        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }

    public  void playAgain(View view){
        score =0;
        numberOfQuestions=0;
        newQuestion();
        timerTextView.setText("30 s");
        playAgainButton.setVisibility(View.INVISIBLE);
        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000) + " s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("         DONE !!");
                playAgainButton.setVisibility(View.VISIBLE);

            }
        }.start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameLayout = findViewById(R.id.gameLayout);
        goButton = findViewById(R.id.goButton);
        button0 = findViewById(R.id.button0);
        button1= findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);
        sumTextView = findViewById(R.id.sumTextView);
        resultTextView = findViewById(R.id.resultTextView);
        playAgainButton = findViewById(R.id.playAgainButton);
        goButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);


    }
}
