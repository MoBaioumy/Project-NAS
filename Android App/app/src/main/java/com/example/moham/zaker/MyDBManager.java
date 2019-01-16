package com.example.moham.zaker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "wordList.db";

    public static final String WORDS_TABLE = "words";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_WORD = "word";
    public static final String COLUMN_TRANSLATION = "translation";
    public static final String COLUMN_QUIZ = "quiz";


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + WORDS_TABLE + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_WORD + " TEXT, " +
                COLUMN_TRANSLATION + " TEXT, " +
                COLUMN_QUIZ + "INTEGER " +
                ");";
        db.execSQL(query);
    }

    //    private static variable called instance of type EntryDatabase. This is where the unique instance of the class is stored, once made.
    private static MyDBManager instance;

    private MyDBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + WORDS_TABLE);
        onCreate(db);
    }


    // singlton code
    public static MyDBManager getInstance(Context context) {
        if (instance == null) {
            MyDBManager db = new MyDBManager(context);
            instance = db;
        }
        return instance;
    }


//    Add new row to the database
    public void addWord(Word word){
        ContentValues values = new ContentValues();
        values.put(COLUMN_WORD, word.getName());
        values.put(COLUMN_TRANSLATION, word.getTranslation());
//        values.put(COLUMN_QUIZ, quizId);

        SQLiteDatabase db = getWritableDatabase();
        db.insert(WORDS_TABLE, null, values);
        db.close();
    }

    public void deleteWord(Word word){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + WORDS_TABLE + " WHERE " + COLUMN_WORD + "=\"" + word.getName()+ "\";");
    }

    // A methond to select all in the database
    public Cursor selectAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + WORDS_TABLE, null);
        return cursor;
    }
}
