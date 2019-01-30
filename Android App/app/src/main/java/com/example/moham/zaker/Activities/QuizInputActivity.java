package com.example.moham.zaker.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moham.zaker.Data.MyDBManager;
import com.example.moham.zaker.Classes.Quiz;
import com.example.moham.zaker.R;
import com.example.moham.zaker.Classes.Word;

public class QuizInputActivity extends AppCompatActivity {

    private MyDBManager db;
    private String title;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_input);

        /**
         * In the original idea of the app, the words of the quiz would come from processing
         * an image of a word list of a MCQ question list. Since the image processing is out
         * of the scope of this course, a set of hardcoded lists of words are added with buttons.
         */

        // widget variables
        final EditText titleInput = findViewById(R.id.edit_txt_title);
        final EditText descriptionInput = findViewById(R.id.edit_txt_description);

        // get input for the Title of the Quiz
        titleInput.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                title = s.toString();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        // get input for the description of the quiz
        descriptionInput.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                content = s.toString();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }

    // method for add a quiz and moving to the next Activity
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
        Intent intent = new Intent(QuizInputActivity.this,
                        QuizInputFinishedActivity.class);
        // TODO: Pass the quiz_id as a parameter to the next Activity to view only the right quiz
        intent.putExtra("quizNumber", quizNumber);
        startActivity(intent);
    }

    // check whether the user has entered both the name and description
    private boolean checkInput() {
        if (this.title != null && this.content != null) {
            return true;
        }
        Toast.makeText(this, "Please provide both the name and description!",
                Toast.LENGTH_LONG).show();
        return false;
    }

    public void onClicked(View v){

        // convert view to checkbox and get its value
        Button button = (Button) v;
        String buttonText = button.getText().toString();

        // loop over all the body parts and sets to visible and colored if checked
        if (buttonText.equals("Animals")){
            Word[] finalWordList = {
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
        else if (buttonText.equals("House")){
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

        else if (buttonText.equals("Basics")){
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

        else if (buttonText.equals("Empty")){
            Word [] finalWordList = {};

            addQuiz(new Quiz(title, content), finalWordList);
        }

    }

}
