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

        // get ONLY the RIGHT words from the database; words with the right quiz_id
        db = MyDBManager.getInstance(getApplicationContext());
        Cursor cursor = db.selectAllWords();

        // Add all the words to list view using the adapter
        adapter = new WordListAdapter(getApplicationContext(), cursor);
        final ListView wordInputList = findViewById(R.id.list_input_words);
        wordInputList.setAdapter(adapter);

        // TODo: the backButton should return you to the quizzes overview
    }
}
