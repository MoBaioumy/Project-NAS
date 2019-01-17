package com.example.moham.zaker;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class WordListAdapter extends ResourceCursorAdapter {

    public WordListAdapter(Context context, Cursor cursor) {
        super(context, R.layout.word_entry_layout, cursor);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textTitle = view.findViewById(R.id.word);
        TextView textContent = view.findViewById(R.id.trans);

        String title = cursor.getString(cursor.getColumnIndex(MyDBManager.COLUMN_WORD));
        textTitle.setText(title);

        String content = cursor.getString(cursor.getColumnIndex(MyDBManager.COLUMN_TRANSLATION));
        textContent.setText(content);

    }
}
