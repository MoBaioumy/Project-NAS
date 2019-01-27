package com.example.moham.zaker;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class QuizInputFinishedActivity extends AppCompatActivity {

    private MyDBManager db;
    private WordListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_input_finished);

        Intent intent = getIntent();
        final int quizNumber = intent.getIntExtra("quizNumber", 1);

        // get ONLY the RIGHT words from the database; words with the right quiz_id
        db = MyDBManager.getInstance(getApplicationContext());
        Cursor cursor = db.selectWordsFromQuiz(quizNumber);

        // Add all the words to list view using the adapter
        adapter = new WordListAdapter(getApplicationContext(), cursor);
        final ListView wordInputList = findViewById(R.id.list_input_words);
        wordInputList.setAdapter(adapter);


        FloatingActionButton fab = findViewById(R.id.fab_add_words);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizInputFinishedActivity.this,
                        WordsInputActivity.class);
                intent.putExtra("quizNumber", quizNumber);
                startActivity(intent);
            }
        });




    }

    // the backButton should return you to the quizzes overview
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,TeacherQuizListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
