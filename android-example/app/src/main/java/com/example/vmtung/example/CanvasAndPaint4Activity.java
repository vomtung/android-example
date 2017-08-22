package com.example.vmtung.example;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CanvasAndPaint4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_and_paint_example4);

        final LineChart chart = (LineChart) this.findViewById(R.id.exampleLineChart);
        //chart.addItem("Agamemnon", 2, ContextCompat.getColor(this,R.color.blue));
        //chart.addItem("Bocephus", 3.5f, ContextCompat.getColor(this, R.color.green));
        //chart.addItem("Calliope", 2.5f, ContextCompat.getColor(this, R.color.yellow));
        //chart.addItem("Daedalus", 3, ContextCompat.getColor(this, R.color.colorAccent));
        //chart.addItem("Euripides", 1, ContextCompat.getColor(this, R.color.red));
        //chart.addItem("Ganymede", 3, ContextCompat.getColor(this, R.color.grape));

        List<LineChart.LineItem> item1 = new ArrayList<LineChart.LineItem>();
        LineChart.LineItem item11 = new LineChart.LineItem("January", 200);
        LineChart.LineItem item12 = new LineChart.LineItem("February", 800);
        LineChart.LineItem item13 = new LineChart.LineItem("March", 700);
        LineChart.LineItem item14 = new LineChart.LineItem("April", 400);
        LineChart.LineItem item15 = new LineChart.LineItem("May", 900);
        LineChart.LineItem item16 = new LineChart.LineItem("May", 100);
        item1.add(item11);
        item1.add(item12);
        item1.add(item13);
        item1.add(item14);
        item1.add(item15);
        item1.add(item16);

        List<LineChart.LineItem> item2 = new ArrayList<LineChart.LineItem>();
        LineChart.LineItem item21 = new LineChart.LineItem("January", 600);
        LineChart.LineItem item22 = new LineChart.LineItem("February", 900);
        LineChart.LineItem item23 = new LineChart.LineItem("March", 100);
        LineChart.LineItem item24 = new LineChart.LineItem("April", 200);
        LineChart.LineItem item25 = new LineChart.LineItem("May", 500);
        LineChart.LineItem item26 = new LineChart.LineItem("June", 500);
        LineChart.LineItem item27 = new LineChart.LineItem("July", 100);
        item2.add(item21);
        item2.add(item22);
        item2.add(item23);
        item2.add(item24);
        item2.add(item25);
        item2.add(item26);
        item2.add(item27);

        List<LineChart.LineItem> item3 = new ArrayList<LineChart.LineItem>();
        LineChart.LineItem item31 = new LineChart.LineItem("January", 0);
        LineChart.LineItem item32 = new LineChart.LineItem("February", 100);
        LineChart.LineItem item33 = new LineChart.LineItem("March", 700);
        LineChart.LineItem item34 = new LineChart.LineItem("April", 900);
        LineChart.LineItem item35 = new LineChart.LineItem("May", 500);
        LineChart.LineItem item36 = new LineChart.LineItem("June", 300);
        LineChart.LineItem item37 = new LineChart.LineItem("July", 700);
        item3.add(item31);
        item3.add(item32);
        item3.add(item33);
        item3.add(item34);
        item3.add(item35);
        item3.add(item36);
        item3.add(item37);

        String []xEntries = {"January", "February", "March", "April", "May", "June", "July", "August","September","October"};

        chart.addXEntries(xEntries);
        chart.addItem("label1",item1, Color.BLUE);
        chart.addItem("label2",item2,Color.RED);
        chart.addItem("label3",item3,Color.GREEN);
    }
}
