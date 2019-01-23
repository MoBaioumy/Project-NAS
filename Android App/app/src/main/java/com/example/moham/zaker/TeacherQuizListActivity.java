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
                Intent intent = new Intent(TeacherQuizListActivity.this, QuizInputActivity.class);
                startActivity(intent);
            }
        });



        db = MyDBManager.getInstance(getApplicationContext());
        Cursor cursor = db.selectAllQuizzes();

        // ERROR
        adapter = new QuizListAdapter(getApplicationContext(), cursor);
        final ListView quizList = findViewById(R.id.list_quiz);
        quizList.setAdapter(adapter);




//        Word bottle = new Word("bottle", "fles");
//        Word morning = new Word("morning", "ochtend");
//
//        ArrayList<Word> wordsList = new ArrayList<>();
//        wordsList.add(bottle);
//        wordsList.add(morning);
//
//
//        Quiz testQuiz = new Quiz("test", wordsList, "A test quiz");
//        ArrayList<Quiz> quizList = new ArrayList<>();
//        quizList.add(testQuiz);
//
//        QuizListAdapter quizAdapter = new QuizListAdapter(this, R.layout.quiz_entry_layout, quizList);
//        mListView.setAdapter(quizAdapter);


    }
}
