package com.example.moham.zaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StudentFinalScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_final_score);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 1);

        TextView txtScore = (TextView) findViewById(R.id.txt_final_score);
        txtScore.setText("Your score is " + score);

    }
}
