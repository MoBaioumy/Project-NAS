package com.example.moham.zaker.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.example.moham.zaker.Data.MyDBManager;
import com.example.moham.zaker.R;

public class StudentOverviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_overview);
    }

    // This function will get called when ANY of the buttons is clicked.
    public void onClicked(View v){

        // convert view to checkbox and get its value
        Button button = (Button) v;
        String buttonText = button.getText().toString();

        // Move to quizzes Activity
        if (buttonText.equals("Your quizzes")){
            Intent intent = new Intent (StudentOverviewActivity.this,
                    StudentQuizListActivity.class);
            startActivity(intent);
        }

        // Move to progress Activity
        else if (buttonText.equals("Progress")){
            Intent intent = new Intent (StudentOverviewActivity.this,
                    StudentProgressActivity.class);
            startActivity(intent);
        }

        // Move to community Activity
        else if (buttonText.equals("Community")){
            Intent intent = new Intent (StudentOverviewActivity.this,
                    StudentCommunityActivity.class);
            startActivity(intent);
        }

    }
}
