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
    int QUIZ_SIZE = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_quiz_list);
        i = 1;

        // ToDO: Add try except for when the database is still empty
        nextWord();

//        Toast.makeText("", )

    }

    public void nextWord(){
        // get database
        db = MyDBManager.getInstance(getApplicationContext());

        // get a list with the words & translation. since it's only 2 items, a hash map is overkill
        List cursor = db.getWordAndTranslation(i);
        TextView txt = (TextView) findViewById(R.id.textView9);
        word = (String) cursor.get(0);
        trans = (String) cursor.get(1);

        // get a ransom translation as a test word
        Random rand = new Random();
        int n = rand.nextInt(6) + 1;
        cursor = db.getWordAndTranslation(n);
        randWord = (String) cursor.get(1);

        // Set the text for the question
        txt.setText("Does " + word + " mean " + randWord + "?");

    }

    public void onClick(View v){
        Button button = (Button) v;
        String btn_text = (String) button.getText();

        TextView txtScore = (TextView) findViewById(R.id.text_score);

        // if answered correctly, increase score
        if (btn_text.equals("True") && randWord.equals(trans)){
            score++;
            txtScore.setText("Score: " + score);
        }

        else if (btn_text.equals("False") && !randWord.equals(trans)){
            score++;
            txtScore.setText("Score: " + score);
        }
        // move to the next word
        i++;
        nextWord();

        // After the quiz size is reached, report score and move to next activity

        // maybe try, catch so that when quiz is over, move to the next
        if (i == QUIZ_SIZE){
            Intent intent = new Intent (StudentQuizActivity.this,
                            StudentFinalScoreActivity.class);
            intent.putExtra("score", score);
            // ToDO: fix code to add results
            db.addResult(score, 1, "Karel Scheepstra");
            startActivity(intent);
        }

    }
}
