package com.example.moham.zaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherOverviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_overview);

        final Button communityButton = (Button) findViewById(R.id.btn_community);
        communityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TeacherOverviewActivity.this , TeacherCommunityActivity.class);
                startActivity(intent);
            }
        });

        final Button progressButton = (Button) findViewById(R.id.btn_progress);
        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TeacherOverviewActivity.this , TeacherProgressActivity.class);
                startActivity(intent);
            }
        });

        final Button quizzesButton = (Button) findViewById(R.id.btn_quizzes);
        quizzesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TeacherOverviewActivity.this , TeacherQuizListActivity.class);
                startActivity(intent);
            }
        });
    }
}
