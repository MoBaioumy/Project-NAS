package com.example.moham.zaker;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TeacherQuizListActivity extends AppCompatActivity {
    private MyDBManager db;
    private QuizListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_quiz_list);

        // set FAB for creating a new quiz
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherQuizListActivity.this,
                                QuizInputActivity.class);
                startActivity(intent);
            }
        });

        // get all quizzes from the database, QUIZZES_TABLE
        db = MyDBManager.getInstance(getApplicationContext());
        Cursor cursor = db.selectAllQuizzes();

        // Add all the quizzes to list view using the adapter
        adapter = new QuizListAdapter(getApplicationContext(), cursor);
        final ListView quizList = findViewById(R.id.list_quiz);
        quizList.setAdapter(adapter);

        /* ToDo
         */
        // ToDo: Set listener to select the quiz and view the words within it


    }
}
