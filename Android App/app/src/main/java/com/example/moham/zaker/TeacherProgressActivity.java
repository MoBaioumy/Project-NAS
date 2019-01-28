package com.example.moham.zaker;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class TeacherProgressActivity extends AppCompatActivity {
    private static final String TAG = "TeacherProgressActivity";
    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_progress);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        graph.addSeries(series);
        series.setTitle("Random Curve 1");
        series.setColor(Color.BLUE);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(8);





// custom paint to make a dotted line


        // bar chart with student name under every bar and quiz score as the height.
//
//        mChart = findViewById(R.id.line_chart);
////
////        mChart.setOnChartGestureListener(TeacherProgressActivity.this);
////        mChart.setOnChartValueSelectedListener(TeacherProgressActivity.this);
//        mChart.setDragEnabled(true);
//        mChart.setScaleEnabled(false);


        // TODO: add code to import results from the data base and visualize it
//        ArrayList<Entry> lineValues = new ArrayList<>();
//        lineValues.add(new Entry(0, 60f));
//        lineValues.add(new Entry(1, 60f));
//        lineValues.add(new Entry(2, 70f));
//        lineValues.add(new Entry(3, 60f));
//
//
//        LineDataSet set1 = new LineDataSet(lineValues, "Grades of students");
//        set1.setFillAlpha(110);
////
//        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
//
//        dataSets.add(set1);
//        LineData data = new LineData(dataSets);
//        mChart.setData(data);
    }
}