package com.example.moham.zaker;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class StudentQuizActivity extends AppCompatActivity {

    private MyDBManager db;
    public int i;
    public String word;
    public String trans;
    public String randWord;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_quiz_list);
        i = 1;
        nextWord();



//        Toast.makeText("", )

    }

    public void nextWord(){
        db = MyDBManager.getInstance(getApplicationContext());

        List cursor = db.databaseToString(i);
        TextView txt = (TextView) findViewById(R.id.textView9);
        word = (String) cursor.get(0);
        trans = (String) cursor.get(1);


        Random rand = new Random();
        int n = rand.nextInt(10) + 1;
        cursor = db.databaseToString(n);
        randWord = (String) cursor.get(1);


        txt.setText("Does " + word + " mean " + randWord + "?");

    }

    public void onClick(View v){
        Button button = (Button) v;
        String btn_text = (String) button.getText();

        TextView txtScore = (TextView) findViewById(R.id.text_score);



        if (btn_text.equals("True") && randWord.equals(trans)){
            score++;
            txtScore.setText("Score: " + score);
        }

        else if (btn_text.equals("False") && !randWord.equals(trans)){
            score++;
            txtScore.setText("Score: " + score);
        }
        i++;
        nextWord();

        if (i == 10){
            Intent intent = new Intent (StudentQuizActivity.this , StudentFinalScoreActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
        }



    }
}
