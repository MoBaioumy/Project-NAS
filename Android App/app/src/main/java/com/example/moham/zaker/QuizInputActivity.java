package com.example.moham.zaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizInputActivity extends AppCompatActivity {
    Word [] finalWordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_input);

        final Button animalsButton = (Button) findViewById(R.id.btn_animals);
        animalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word [] finalWordList = {
                        new Word("donkey", "ezel"),
                        new Word("fish", "vis"),
                        new Word("horse", "paard"),
                        new Word("lion", "leeuw")};

                for (int i = 0; i < finalWordList.length; i++){
                    MyDBManager.getInstance(getApplicationContext()).addWord(finalWordList[i]);
                };
                Intent intent = new Intent(QuizInputActivity.this,
                        QuizInputFinishedActivity.class);

                startActivity(intent);

            }
        });

        final Button greetingsButton = (Button) findViewById(R.id.btn_greetings);
        greetingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word [] finalWordList = {
                        new Word("Good morning!", "Goede Morgen!"),
                        new Word("Good afternoon!", "Goede Middag!"),
                        new Word("Good evening!", "Goeden avond!")};

                for (int i = 0; i < finalWordList.length; i++){
                    MyDBManager.getInstance(getApplicationContext()).addWord(finalWordList[i]);
                };
                Intent intent = new Intent(QuizInputActivity.this, QuizInputFinishedActivity.class);
                startActivity(intent);
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
                        new Word("roof", "dak"),
                        new Word("house", "huis")};

                for (int i = 0; i < finalWordList.length; i++){
                    MyDBManager.getInstance(getApplicationContext()).addWord(finalWordList[i]);
                };
                Intent intent = new Intent(QuizInputActivity.this, QuizInputFinishedActivity.class);
                startActivity(intent);
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

}
