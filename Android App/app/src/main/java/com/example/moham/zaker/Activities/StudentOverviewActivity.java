package com.example.moham.zaker.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moham.zaker.Data.MyDBManager;
import com.example.moham.zaker.R;

public class StudentOverviewActivity extends AppCompatActivity {
    private MyDBManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_overview);


        // move to the community activity for the student
        final Button communityButton = (Button) findViewById(R.id.btn_community);
        communityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (StudentOverviewActivity.this,
                                StudentCommunityActivity.class);
                startActivity(intent);
            }
        });

        // move to the student progress activity to view grades and progress
        final Button progressButton = (Button) findViewById(R.id.btn_progress);
        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (StudentOverviewActivity.this,
                                StudentProgressActivity.class);
                startActivity(intent);
            }
        });

        // move to the quizzes page to quizzesList
        final Button quizzesButton = (Button) findViewById(R.id.btn_quizzes);
        quizzesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (StudentOverviewActivity.this,
                                StudentQuizListActivity.class);
                startActivity(intent);
            }
        });
    }
}
