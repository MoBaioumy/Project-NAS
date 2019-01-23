package com.example.moham.zaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QuizInputActivity extends AppCompatActivity {

    private MyDBManager db;
    private String title;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_input);

        // widget variables
        final EditText titleInput = findViewById(R.id.editContentTitle);
        final EditText contentInput = findViewById(R.id.editTextContent);

        titleInput.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                title = s.toString();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        contentInput.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                content = s.toString();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        final Button animalsButton = (Button) findViewById(R.id.btn_animals);
        animalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word [] finalWordList = {
                        new Word("donkey", "ezel"),
                        new Word("fish", "vis"),
                        new Word("horse", "paard"),
                        new Word("horse", "paard"),
                        new Word("horse", "paard"),
                        new Word("horse", "paard"),
                        new Word("horse", "paard"),
                        new Word("lion", "leeuw")};

                addQuiz(new Quiz(title, content), finalWordList);

            }
        });

        final Button greetingsButton = (Button) findViewById(R.id.btn_greetings);
        greetingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word [] finalWordList = {
                        new Word("Good morning!", "Goede Morgen!"),
                        new Word("Good afternoon!", "Goede Middag!"),
                        new Word("Good afternoon!", "Goede Middag!"),
                        new Word("Good afternoon!", "Goede Middag!"),
                        new Word("Good afternoon!", "Goede Middag!"),
                        new Word("Good afternoon!", "Goede Middag!"),
                        new Word("Good afternoon!", "Goede Middag!"),
                        new Word("Good evening!", "Goeden avond!")};

                addQuiz(new Quiz(title, content), finalWordList);
            }
        });


        final Button houseButton = (Button) findViewById(R.id.btn_house);
        houseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word [] finalWordList = {
                        new Word("chair", "stoel"),
                        new Word("table", "tafel"),
                        new Word("room", "kamer"),
                        new Word("drapes", "gordijnen"),
                        new Word("carpet", "tapijt"),
                        new Word("carpet", "tapijt"),
                        new Word("roof", "dak"),
                        new Word("house", "huis")};


                addQuiz(new Quiz(title, content), finalWordList);
            }

        });

    }

    private void addEntry() {

//        MyDBManager db;
//        for (int i = 0; i < finalWordList.length; i++);{
//            db.addWord(finalWordList[i]);
//        }
        QuizInputActivity.this.finish();
    }

    private void addQuiz(Quiz quiz, Word [] finalWordList){
        if (!checkInput()) {
            return;
        }
        // open up the data base and add quiz
        db = MyDBManager.getInstance(getApplicationContext());
        db.addQuiz(quiz);

        int quizNumber = db.selectQuizId(title);

        // add all the words to the WORDS_TABLE in the data base
        for (int i = 0; i < finalWordList.length; i++){
            finalWordList[i].setQuizNumber(quizNumber);
            MyDBManager.getInstance(getApplicationContext()).addWord(finalWordList[i]);
        };

        // move to the next Activity
        Intent intent = new Intent(QuizInputActivity.this, QuizInputFinishedActivity.class);
        startActivity(intent);
    }

    private boolean checkInput() {
        if (this.title != null && this.content != null) {
            return true;
        }
        Toast.makeText(this, "Please provide complete info!",
                Toast.LENGTH_LONG).show();
        return false;
    }

}
