package com.example.moham.zaker.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moham.zaker.Data.MyDBManager;
import com.example.moham.zaker.R;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class StudentFinalScoreActivity extends AppCompatActivity {
    private MyDBManager db;
    String STUDENT_NAME = "Karel";
    public ArrayList <Float> SCORES;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_final_score);

        // get the score from the quiz
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 1);
        int quizId = intent.getIntExtra("quizId", 1);

        // set the final score text
        TextView txtScore = (TextView) findViewById(R.id.txt_final_score);
        txtScore.setText("Your score is " + score + "/10");

        // add results to db
        db.addResult(quizId, score, STUDENT_NAME);

        // Button to move back to your quizzes
        Button restartQuizButton = (Button) findViewById(R.id.btn_done);
        restartQuizButton.setOnClickListener(new RestartButtonClickListener());
    }

    private class RestartButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // move back to your quizzes
            Intent backIntent = new Intent (StudentFinalScoreActivity.this ,
                    StudentQuizListActivity.class);
            backIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(backIntent);
        }
    }
}
