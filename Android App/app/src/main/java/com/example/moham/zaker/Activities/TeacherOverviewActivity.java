package com.example.moham.zaker.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moham.zaker.R;

public class TeacherOverviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_overview);

        // move to the community activity for the teacher
        final Button communityButton = (Button) findViewById(R.id.btn_community);
        communityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TeacherOverviewActivity.this,
                                TeacherCommunityActivity.class);
                startActivity(intent);
            }
        });

        // move to the teacher progress activity to view the analysis of the class
        final Button progressButton = (Button) findViewById(R.id.btn_progress);
        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TeacherOverviewActivity.this,
                                TeacherProgressActivity.class);
                startActivity(intent);
            }
        });

        // move to the teaching material to create or view quizzes
        final Button quizzesButton = (Button) findViewById(R.id.btn_quizzes);
        quizzesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TeacherOverviewActivity.this,
                                TeacherQuizListActivity.class);
                startActivity(intent);
            }
        });
    }
}
