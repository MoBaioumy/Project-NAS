package com.example.moham.zaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // button for the sample teacher overview
        final Button philipButton = (Button) findViewById(R.id.btn_philip);
        philipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this , TeacherOverviewActivity.class);
                startActivity(intent);

            }
        });

        final Button KarelButton = (Button) findViewById(R.id.btn_karel);
        KarelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this , StudentOverviewActivity.class);
                startActivity(intent);
            }
        });

        // drop the data base and create an empty new one
        MyDBManager db = MyDBManager.getInstance(getApplicationContext());
        db.onUpgrade(db.getWritableDatabase(), 1, 1);
    }
}
