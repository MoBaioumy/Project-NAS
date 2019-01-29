package com.example.moham.zaker.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import com.example.moham.zaker.Data.MyDBManager;
import com.example.moham.zaker.R;

public class QuizListAdapter extends ResourceCursorAdapter {

    public QuizListAdapter(Context context, Cursor cursor) {
        // ToDo: Make another layout for the quizzes
        super(context, R.layout.quiz_entry_layout, cursor);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Get the Widgets
        TextView textQuizTitle = view.findViewById(R.id.txt_quiz_title);
        TextView textQuizContent = view.findViewById(R.id.txt_quiz_description);
        TextView textQuizId = view.findViewById(R.id.txt_quiz_id);


        // set the Title, description and quizId according to the dataBase entry
        String title = cursor.getString(cursor.getColumnIndex(MyDBManager.COLUMN_QUIZ_NAME));
        textQuizTitle.setText(title);

        String content = cursor.getString(cursor.getColumnIndex(MyDBManager.COLUMN_DESCRIPTION));
        textQuizContent.setText(content);

        String quidId = cursor.getString(cursor.getColumnIndex(MyDBManager.COLUMN_QUIZ_ID));
        textQuizId.setText(quidId);

    }
}
