package com.example.moham.zaker;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TeacherQuizListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_quiz_list);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherQuizListActivity.this, QuizInputActivity.class);
                startActivity(intent);
            }
        });


        ListView mListView = (ListView) findViewById(R.id.list_quiz);

        Word bottle = new Word("bottle", "fles");
        Word morning = new Word("morning", "ochtend");

        ArrayList<Word> wordsList = new ArrayList<>();
        wordsList.add(bottle);
        wordsList.add(morning);


        Quiz testQuiz = new Quiz("test", wordsList, "A test quiz");
        ArrayList<Quiz> quizList = new ArrayList<>();
        quizList.add(testQuiz);

        QuizListAdapter quizAdapter = new QuizListAdapter(this, R.layout.quiz_entry_layout, quizList);
        mListView.setAdapter(quizAdapter);


    }
}
