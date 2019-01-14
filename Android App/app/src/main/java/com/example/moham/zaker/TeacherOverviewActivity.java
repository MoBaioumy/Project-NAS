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

        final Button btn_community = (Button) findViewById(R.id.btn_community);
        btn_community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TeacherOverviewActivity.this , CommunityTeacherActivity.class);
                startActivity(intent);
            }
        });

        final Button btn_progress = (Button) findViewById(R.id.btn_progress);
        btn_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TeacherOverviewActivity.this , TeacherProgressActivity.class);
                startActivity(intent);
            }
        });

        final Button btn_quizzes = (Button) findViewById(R.id.btn_quizzes);
        btn_quizzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TeacherOverviewActivity.this , TeacherQuizListActivity.class);
                startActivity(intent);
            }
        });
    }
}
