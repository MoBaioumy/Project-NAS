package com.example.moham.zaker.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.moham.zaker.Data.MyDBManager;
import com.example.moham.zaker.Adapters.QuizListAdapter;
import com.example.moham.zaker.R;

public class StudentQuizListActivity extends AppCompatActivity {
    private MyDBManager db;
    private QuizListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_quiz_list2);

        // get all quizzes from the database, QUIZZES_TABLE
        db = MyDBManager.getInstance(getApplicationContext());
        Cursor cursor = db.selectAllQuizzes();

        // Add all the quizzes to list view using the adapter
        adapter = new QuizListAdapter(getApplicationContext(), cursor);
        final ListView quizList = findViewById(R.id.list_quiz_student);
        quizList.setAdapter(adapter);

        // NO INNER CLASS IS USER HERE, SEE PROGRESS.md (17 Jan)
        quizList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), StudentQuizActivity.class);

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
    }
}
