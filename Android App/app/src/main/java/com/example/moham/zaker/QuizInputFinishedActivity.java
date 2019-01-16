package com.example.moham.zaker;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class QuizInputFinishedActivity extends AppCompatActivity {

    private MyDBManager db;
    private WordListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_input_finished);


        db = MyDBManager.getInstance(getApplicationContext());
        Cursor cursor = db.selectAll();

        adapter = new WordListAdapter(getApplicationContext(), cursor);
        final ListView journalList = findViewById(R.id.listViewJournals);
        journalList.setAdapter(adapter);
    }
}
