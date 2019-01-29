package com.example.moham.zaker.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.moham.zaker.Data.MyDBManager;
import com.example.moham.zaker.R;
import com.example.moham.zaker.Classes.Word;

public class WordsInputActivity extends AppCompatActivity {

    String currentWord;
    String currentTranslation;
    private MyDBManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_input);

        // Get quizId from previous List
        Intent intent = getIntent();
        final int quizNumber = intent.getIntExtra("quizNumber", 1);

        // Get widgets
        final EditText wordInput = findViewById(R.id.edit_txt_word);
        final EditText translationInput = findViewById(R.id.edit_txt_translation);

        wordInput.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                currentWord = s.toString();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        translationInput.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                currentTranslation = s.toString();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });


        Button addWordButton = findViewById(R.id.btn_new_word);
        Button submitWordsButton = findViewById(R.id.btn_submit_words);

        addWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDBManager.getInstance(getApplicationContext()).addWord
                        (new Word(currentWord, currentTranslation, quizNumber));

                // empty the text fields
                wordInput.setText("");
                translationInput.setText("");
            }
        });

        submitWordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WordsInputActivity.this,
                        QuizInputFinishedActivity.class);
                intent.putExtra("quizNumber", quizNumber);
                startActivity(intent);
            }
        });
    }
}
