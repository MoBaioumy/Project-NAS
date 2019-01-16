package com.example.moham.zaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentOverviewActivity extends AppCompatActivity {
    private MyDBManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_overview);



        final Button communityButton = (Button) findViewById(R.id.btn_community);
        communityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (StudentOverviewActivity.this , CommunityStudentActivity.class);
                startActivity(intent);
            }
        });

        final Button progressButton = (Button) findViewById(R.id.btn_progress);
        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (StudentOverviewActivity.this , StudentProgressActivity.class);
                startActivity(intent);
            }
        });

        final Button quizzesButton = (Button) findViewById(R.id.btn_quizzes);
        quizzesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (StudentOverviewActivity.this , StudentQuizListActivity.class);
                startActivity(intent);
            }
        });
    }
}
