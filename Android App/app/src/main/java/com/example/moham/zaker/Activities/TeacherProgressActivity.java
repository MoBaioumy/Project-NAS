package com.example.moham.zaker.Activities;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.moham.zaker.Data.MyDBManager;
import com.example.moham.zaker.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarEntry;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class TeacherProgressActivity extends AppCompatActivity {
    private static final String TAG = "TeacherProgressActivity";
    private LineChart mChart;
    MyDBManager db;
    ArrayList <DataPoint> Arraydata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_progress);

        //Get widgets
        GraphView graph = (GraphView) findViewById(R.id.graph);

        // Get results from db
        db = MyDBManager.getInstance(getApplicationContext());
        ArrayList<Float> resultsList = db.selectAllResults();

        // Add all results to the graph
        Arraydata.add(new DataPoint(0, 0));
        for (int i = 1; i < Arraydata.size(); i++){
            Arraydata.add(new DataPoint(i, resultsList.get(i)));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

        // Graph attributes and make it visuble
        graph.addSeries(series);
        series.setTitle("Student Resutls");
        series.setColor(Color.BLUE);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(8);
    }
}