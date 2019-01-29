package com.example.moham.zaker.Activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.moham.zaker.Data.MyDBManager;
import com.example.moham.zaker.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class StudentProgressActivity extends AppCompatActivity {

    private static final String TAG = "StudentProgressActivity";
    private LineChart mChart;
    MyDBManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_progress);


        mChart = (LineChart) findViewById(R.id.chart);

//        mChart.setOnChartGestureListener(StudentProgressActivity.this);
//        mChart.setOnChartValueSelectedListener(StudentProgressActivity.this);

        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);


        db = MyDBManager.getInstance(getApplicationContext());
        ArrayList<Float> resultsList = db.selectAllResults();


        ArrayList<Entry> yValues = new ArrayList<>();


        // TODO: add code to import results from the data base and visualize it

//        yValues.add(new Entry(0, 60f));
//        yValues.add(new Entry(1, 50f));
//        yValues.add(new Entry(2, 70f));
//        yValues.add(new Entry(3, 60f));
        yValues.add(new Entry(0, resultsList.get(0)));
        yValues.add(new Entry(1, resultsList.get(1)));
        yValues.add(new Entry(2, resultsList.get(2)));



        LineDataSet gradesSet = new LineDataSet(yValues, "Grades of Quizzes");

        gradesSet.setFillAlpha(130);
        gradesSet.setLineWidth(4f);
        gradesSet.setColor(Color.BLUE);
        gradesSet.setValueTextColor(Color.BLACK);
        gradesSet.setValueTextSize(20f);


        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(gradesSet);

        LineData allData = new LineData(dataSets);

        mChart.setData(allData);

    }
}
