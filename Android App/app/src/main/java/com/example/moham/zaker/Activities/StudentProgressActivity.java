package com.example.moham.zaker.Activities;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.moham.zaker.Data.MyDBManager;
import com.example.moham.zaker.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StudentProgressActivity extends AppCompatActivity {

    private static final String TAG = "StudentProgressActivity";
    private BarChart barChart;
    MyDBManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_progress);

        // gat widget
        barChart = (BarChart) findViewById(R.id.chart);

        // set chart attributes
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(50);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(true);

        // Create entry array for entries
        ArrayList<BarEntry> barEntries = new ArrayList<>();

        // Get all results from database
        db = MyDBManager.getInstance(getApplicationContext());
        ArrayList<Float> resultsList = db.selectAllResults();

        // Add all the results to the graph
        for (int i = 1; i < resultsList.size(); i++){
            barEntries.add(new BarEntry(i, (float)resultsList.get(i)));
        }

        // Create data set, assign colors and display the graph
        BarDataSet gradesSet = new BarDataSet(barEntries, "Grades of Quizzes");
        gradesSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData data = new BarData(gradesSet);
        data.setBarWidth(0.9f);
        barChart.setData(data);

    }
}
