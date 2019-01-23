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

        final Button btn_mohamed = (Button) findViewById(R.id.btnMohamed);
        btn_mohamed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this , TeacherOverviewActivity.class);
                startActivity(intent);

            }
        });

        final Button btn_karel = (Button) findViewById(R.id.btnKarel);
        btn_karel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this , StudentOverviewActivity.class);
                startActivity(intent);
            }
        });


        MyDBManager db = MyDBManager.getInstance(getApplicationContext());
        db.onUpgrade(db.getWritableDatabase(), 1, 1);
    }
}
