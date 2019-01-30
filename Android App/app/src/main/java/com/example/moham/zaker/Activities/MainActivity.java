package com.example.moham.zaker.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moham.zaker.Data.MyDBManager;
import com.example.moham.zaker.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // button for the sample teacher and student overview
        final Button teacherButton = (Button) findViewById(R.id.btn_philip);
        teacherButton.setOnClickListener(new TeacherButtonClickListener());

        final Button studentButton = (Button) findViewById(R.id.btn_karel);
        studentButton.setOnClickListener(new StudentButtonClickListener());
    }

    private class StudentButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // Move to the studentActivity
            Intent intent = new Intent (MainActivity.this,
                            StudentOverviewActivity.class);
            startActivity(intent);
        }
    }

    private class TeacherButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // Move to the TeacherActivity
            Intent intent = new Intent (MainActivity.this,
                            TeacherOverviewActivity.class);
            startActivity(intent);
        }
    }


}
