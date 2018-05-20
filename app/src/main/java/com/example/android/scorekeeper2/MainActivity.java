package com.example.android.scorekeeper2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Tracks the score for Player A
    int finalScorePlayerA = 0;

    //Tracks the score for Player B
    int finalScorePlayerB = 0;

    //Initializing Views in on Create method
    TextView final_scoreA;
    TextView final_scoreB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayforPlayerA(0);
        displayforPlayerB(0);

        //Initializing Views in onCreate method referring back to id of score view
        final_scoreA = findViewById(R.id.score_a);
        final_scoreB = findViewById(R.id.score_b);
    }

    //Save State Methods to keep score when screen rotates

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("someVarA", finalScorePlayerA);
        outState.putInt("someVarB", finalScorePlayerB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        finalScorePlayerA = savedInstanceState.getInt("someVarA");
        finalScorePlayerB = savedInstanceState.getInt("someVarB");
        displayforPlayerA(finalScorePlayerA);
        displayforPlayerB(finalScorePlayerB);
    }

    /**
     * Displays the given score for Player A.
     */
    public void displayforPlayerA(int score) {
        TextView scoreView = findViewById(R.id.score_a);
        scoreView.setText(String.valueOf(score));
    }

    //This method adds points when Player A wins RPS

    public void addAPointA(View view){
        finalScorePlayerA = finalScorePlayerA + 1;
        displayforPlayerA(finalScorePlayerA);
    }

    /**
     * Displays the given score for Player B.
     */
    public void displayforPlayerB(int score) {
        TextView scoreView = findViewById(R.id.score_b);
        scoreView.setText(String.valueOf(score));
    }

    //This method adds points when Player A wins RPS

    public void addAPointB(View view){
        finalScorePlayerB = finalScorePlayerB + 1;
        displayforPlayerB(finalScorePlayerB);
    }

    //resets scores to 0
    public void reset(View view){
        finalScorePlayerA = 0;
        displayforPlayerA(finalScorePlayerA);
        finalScorePlayerB = 0;
        displayforPlayerB(finalScorePlayerB);
    }

}
