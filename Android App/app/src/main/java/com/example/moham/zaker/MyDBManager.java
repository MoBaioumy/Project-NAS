package com.example.moham.zaker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDBManager extends SQLiteOpenHelper {

    // Database attributes
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "wordList.db";

    // Variables for the table to contain all words from all the quizzes
    public static final String WORDS_TABLE = "words";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_WORD = "word";
    public static final String COLUMN_TRANSLATION = "translation";
    public static final String COLUMN_QUIZ = "quiz";

    // Variable for the table to contain quizzes. The COLUMN_QUIZ links to COLUMN_QUIZ_ID
    public static final String QUIZZES_TABLE = "quizzes";

    public static final String COLUMN_QUIZ_ID = "_id";
    public static final String COLUMN_QUIZ_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";

    // Variable for the table to contain the results after a students tries a quiz
    public static final String RESULTS_TABLE = "results";

    // public static final String COLUMN_QUIZ_ID = "_id_quiz";
    public static final String COLUMN_ID_T3 = "_id";
    public static final String COLUMN_STUDENT_NAME = "student";
    public static final String COLUMN_RESULT = "result";



    @Override
    public void onCreate(SQLiteDatabase db) {

        // create table to contain all words. ColumnID is used to keep track of words when
        // duplicates exist. COLUMN_QUIZ links the word to the right quiz it's in.
        String queryWordsTable = "CREATE TABLE " + WORDS_TABLE + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_WORD + " TEXT, " +
                COLUMN_TRANSLATION + " TEXT, " +
                COLUMN_QUIZ + " INTEGER " +
                ");";
        db.execSQL(queryWordsTable);

        // create table to contain all quizzes and their description.
        String queryQuizTable = "CREATE TABLE " + QUIZZES_TABLE + "(" +
                COLUMN_QUIZ_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_QUIZ_NAME + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT " +
                ");";
        db.execSQL(queryQuizTable);

        // create table for the results of the students. COLUMN_QUIZ_ID is the same as in the
        // quizzes table
        String queryResultsTable = "CREATE TABLE " + RESULTS_TABLE + "(" +
                COLUMN_ID_T3 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_STUDENT_NAME + " TEXT, " +
                COLUMN_RESULT + " REAL " +
                ");";
        db.execSQL(queryResultsTable);
    }

    // This is where the unique instance (singleton) of the class is stored, once made.
    private static MyDBManager instance;

    /**
     * Private constructor
     * @param context
     */
    private MyDBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // when upgrading, simply drop all the tables and start fresh
        db.execSQL("DROP TABLE IF EXISTS " + WORDS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QUIZZES_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RESULTS_TABLE);
        onCreate(db);

        //addWord(new Word("new", "nieuw", 1));
        //addQuiz(new Quiz("test", "for testing"));
    }


    // singlton code, to make sure there is only one instance of the database
    public static MyDBManager getInstance(Context context) {
        if (instance == null) {
            MyDBManager db = new MyDBManager(context);
            instance = db;
        }
        return instance;
    }


    // Add new row to the database
    public void addWord(Word word){
        ContentValues values = new ContentValues();
        values.put(COLUMN_WORD, word.getName());
        values.put(COLUMN_TRANSLATION, word.getTranslation());
        values.put(COLUMN_QUIZ, word.getQuizNumber());
//        values.put(COLUMN_QUIZ, quizId);

        SQLiteDatabase db = getWritableDatabase();
        db.insert(WORDS_TABLE, null, values);
        db.close();
    }

    public void deleteWord(Word word){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + WORDS_TABLE + " WHERE " + COLUMN_WORD + "=\"" + word.getName()+ "\";");
    }


    public Cursor selectAllQuizzes() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + QUIZZES_TABLE + " WHERE 1", null);
        return cursor;
    }

    // A methond to select all the words in the database
    public Cursor selectAllWords() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + WORDS_TABLE + " WHERE 1", null);
        return cursor;
    }



    public Cursor selectWordsFromQuiz(int quiz_id){
        List <String> wordsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + WORDS_TABLE + " WHERE " +
                        COLUMN_QUIZ + " = " + quiz_id, null);

//        cursor.moveToFirst();

        // loop through all the data the cursor has and append the words and translation to a list
//        while (!cursor.isAfterLast()){
//            if(cursor.getString(cursor.getColumnIndex(COLUMN_WORD)) != null){
//
//                wordsList.add(cursor.getString(cursor.getColumnIndex(COLUMN_WORD)));
//                wordsList.add(cursor.getString(cursor.getColumnIndex(COLUMN_TRANSLATION)));
//            }
//        }
        db.close();
        return cursor;
    }

    public int selectQuizId(String quizName){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + QUIZZES_TABLE + " WHERE " + COLUMN_QUIZ_NAME + " =\'" + quizName + "\';", null);
        cursor.moveToFirst();
        return cursor.getInt(cursor.getColumnIndex(COLUMN_QUIZ_ID));
    }

    // Return a specific word and its translation from the WORDS_TABLE
    public List getWordAndTranslation(int i){
        List <String> dbString = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT "+ COLUMN_WORD +", "+ COLUMN_TRANSLATION+" FROM " + WORDS_TABLE +
                        " WHERE " + COLUMN_ID + " = " + i;

        // Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);

        // Go to the first row (a double check)
        c.moveToFirst();

        // get the word and translation then append/add them to the list
        dbString.add(c.getString(c.getColumnIndex(COLUMN_WORD)));
        dbString.add(c.getString(c.getColumnIndex(COLUMN_TRANSLATION)));

        db.close();
        return dbString;
    }

    public void addQuiz (Quiz quiz){
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUIZ_NAME, quiz.getName());
        values.put(COLUMN_DESCRIPTION, quiz.getDescription());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(QUIZZES_TABLE, null, values);
        db.close();
    }

    public void addResult(int result, int quiz_id, String studentName){
        ContentValues values = new ContentValues();
        values.put(COLUMN_RESULT, result);
        values.put("#######quiz", quiz_id);
        values.put(COLUMN_STUDENT_NAME, studentName);

        SQLiteDatabase db = getWritableDatabase();
        db.insert(RESULTS_TABLE, null, values);
        db.close();
    }




//    public Cursor selectWord() {
//        String query = "select * from " + tableName + " where "+ KEY_USERNAME + " = '" + uname + "'";
//        SQLiteDatabase sql = this.getReadableDatabase();
//        Cursor cur = sql.rawQuery(query, null);
//        return cur;
//    }


}
