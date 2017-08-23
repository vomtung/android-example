package com.example.vmtung.example;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CanvasAndPaint5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_and_paint5);

        final ColumnChart1 chart = (ColumnChart1) this.findViewById(R.id.exampleColumnChart);

        List<ColumnChart1.ColumnItem> item1 = new ArrayList<ColumnChart1.ColumnItem>();
        ColumnChart1.ColumnItem item11 = new ColumnChart1.ColumnItem("January", 200);
        ColumnChart1.ColumnItem item12 = new ColumnChart1.ColumnItem("February", 800);
        ColumnChart1.ColumnItem item13 = new ColumnChart1.ColumnItem("March", 700);
        ColumnChart1.ColumnItem item14 = new ColumnChart1.ColumnItem("April", 400);
        ColumnChart1.ColumnItem item15 = new ColumnChart1.ColumnItem("May", 900);
        ColumnChart1.ColumnItem item16 = new ColumnChart1.ColumnItem("May", 100);
        item1.add(item11);
        item1.add(item12);
        item1.add(item13);
        item1.add(item14);
        item1.add(item15);
        item1.add(item16);

        List<ColumnChart1.ColumnItem> item2 = new ArrayList<ColumnChart1.ColumnItem>();
        ColumnChart1.ColumnItem item21 = new ColumnChart1.ColumnItem("January", 600);
        ColumnChart1.ColumnItem item22 = new ColumnChart1.ColumnItem("February", 900);
        ColumnChart1.ColumnItem item23 = new ColumnChart1.ColumnItem("March", 100);
        ColumnChart1.ColumnItem item24 = new ColumnChart1.ColumnItem("April", 200);
        ColumnChart1.ColumnItem item25 = new ColumnChart1.ColumnItem("May", 500);
        ColumnChart1.ColumnItem item26 = new ColumnChart1.ColumnItem("June", 500);
        ColumnChart1.ColumnItem item27 = new ColumnChart1.ColumnItem("July", 100);
        item2.add(item21);
        item2.add(item22);
        item2.add(item23);
        item2.add(item24);
        item2.add(item25);
        item2.add(item26);
        item2.add(item27);

        List<ColumnChart1.ColumnItem> item3 = new ArrayList<ColumnChart1.ColumnItem>();
        ColumnChart1.ColumnItem item31 = new ColumnChart1.ColumnItem("January", 0);
        ColumnChart1.ColumnItem item32 = new ColumnChart1.ColumnItem("February", 100);
        ColumnChart1.ColumnItem item33 = new ColumnChart1.ColumnItem("March", 700);
        ColumnChart1.ColumnItem item34 = new ColumnChart1.ColumnItem("April", 900);
        ColumnChart1.ColumnItem item35 = new ColumnChart1.ColumnItem("May", 500);
        ColumnChart1.ColumnItem item36 = new ColumnChart1.ColumnItem("June", 300);
        ColumnChart1.ColumnItem item37 = new ColumnChart1.ColumnItem("July", 700);
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
