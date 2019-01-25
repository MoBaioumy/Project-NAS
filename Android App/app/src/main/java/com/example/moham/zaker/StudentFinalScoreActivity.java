package com.example.moham.zaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentFinalScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_final_score);

        // get the score from the quiz
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 1);

        // set the final score text
        TextView txtScore = (TextView) findViewById(R.id.txt_final_score);
        txtScore.setText("Your score is " + score + "/10");

        // Button to move back to your quizzes
        Button restartQuizButton = (Button) findViewById(R.id.btn_done);
        restartQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent (StudentFinalScoreActivity.this ,
                                    StudentQuizListActivity.class);
                backIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(backIntent);
            }
        });

    }
}
