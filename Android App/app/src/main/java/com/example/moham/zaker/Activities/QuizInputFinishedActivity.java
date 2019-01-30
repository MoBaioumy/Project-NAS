package com.example.moham.zaker.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.moham.zaker.Data.MyDBManager;
import com.example.moham.zaker.R;
import com.example.moham.zaker.Adapters.WordListAdapter;

public class QuizInputFinishedActivity extends AppCompatActivity {

    private MyDBManager db;
    private WordListAdapter adapter;
    public int quizNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_input_finished);

        // Ger quiz number from previous Activity
        Intent intent = getIntent();
        quizNumber = intent.getIntExtra("quizNumber", 1);

        // get ONLY the RIGHT words from the database; words with the right quiz_id
        db = MyDBManager.getInstance(getApplicationContext());
        Cursor cursor = db.selectWordsFromQuiz(quizNumber);

        // Add all the words to list view using the adapter
        adapter = new WordListAdapter(getApplicationContext(), cursor);
        final ListView wordInputList = findViewById(R.id.list_input_words);
        wordInputList.setAdapter(adapter);

        // FAB to add more words
        FloatingActionButton fab = findViewById(R.id.fab_add_words);
        fab.setOnClickListener(new FABonClickListener());

        wordInputList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Delete word from the database and refresh
                MyDBManager.getInstance(getApplicationContext()).deleteWord(id);
                MyDBManager database = db;
                WordListAdapter entryAdapter = adapter;
                entryAdapter.swapCursor(db.selectWordsFromQuiz(quizNumber));
                return true;
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

    // Inner class for FAB listener
    private class FABonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // code to run when the button gets clicked
            Intent intent = new Intent(QuizInputFinishedActivity.this,
                    WordsInputActivity.class);
            intent.putExtra("quizNumber", quizNumber);
            startActivity(intent);
        }
    }
}
