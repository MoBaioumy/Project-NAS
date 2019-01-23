package com.example.moham.zaker;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class QuizListAdapter extends ResourceCursorAdapter {

    public QuizListAdapter(Context context, Cursor cursor) {
        super(context, R.layout.word_entry_layout, cursor);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textTitle = view.findViewById(R.id.word);
        TextView textContent = view.findViewById(R.id.trans);

        String title = cursor.getString(cursor.getColumnIndex(MyDBManager.COLUMN_QUIZ_NAME));
        textTitle.setText(title);

        String content = cursor.getString(cursor.getColumnIndex(MyDBManager.COLUMN_DESCRIPTION));
        textContent.setText(content);

    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        /**
//         * This method is responsible to for getting the view and attaching it to the ListView
//         */
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.quiz_entry_layout, parent, false);
//        }
//
//        // get the attributes from the right Friend object
//        Quiz currentQuiz = quizzes.get(position);
//        String name = currentQuiz.getName();
//        String description = currentQuiz.getDescription();
//
//        // get text and image view from the object and set them in the List view
//        TextView textViewName = convertView.findViewById(R.id.Title);
//        TextView imageViewFace = convertView.findViewById(R.id.description);
//        TextView number = convertView.findViewById(R.id.Number);
//        textViewName.setText(name);
//        imageViewFace.setText(description);
//        number.setText(Integer.toString(quizzes.size()));
//        return convertView;
//    }


}
