package com.example.moham.zaker;

import android.content.ContentValues;
import android.content.Context;
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

    public MyDBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

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

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + WORDS_TABLE);
        onCreate(db);
    }


//    Add new row to the database
    public void addWord(Word word){
        ContentValues values = new ContentValues();
        values.put(COLUMN_WORD, word.getName());
        values.put(COLUMN_TRANSLATION, word.getTranslation());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(WORDS_TABLE, null, values);
        db.close();
    }

    public void deleteWord(Word word){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + WORDS_TABLE + " WHERE " + COLUMN_WORD + "=\"" + word.getName()+ "\";");
    }
}
