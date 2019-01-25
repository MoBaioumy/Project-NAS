package com.example.moham.zaker;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TeacherQuizListActivity extends AppCompatActivity {

    // ToDo, EXTRA: allow to delete quizzes using long onClickListen

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

        quizList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), QuizInputFinishedActivity.class);

                // get the actual item by the position on the screen
                Cursor cursor = (Cursor) parent.getItemAtPosition(position);

                // pass the information about the entry to the next activity
                intent.putExtra("titleEntry", cursor.getString(cursor.getColumnIndex(MyDBManager.COLUMN_QUIZ_NAME)));
                intent.putExtra("contentEntry", cursor.getString(cursor.getColumnIndex(MyDBManager.COLUMN_DESCRIPTION)));
                intent.putExtra("quizNumber", cursor.getInt(cursor.getColumnIndex(MyDBManager.COLUMN_QUIZ_ID)));

                // go to the detailed activity
                startActivity(intent);
            }
        });
        // ToDO: allow deleting items. Now it drops the whole database, make it only drop the right items
//        quizList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                MyDBManager.getInstance(getApplicationContext()).onUpgrade(db.getWritableDatabase(), 1, 1);
//                MyDBManager database = db;
//                QuizListAdapter entryAdapter = adapter;
//                entryAdapter.swapCursor(db.selectAllQuizzes());
//                return true;
//            }
//        });

    }
}
