package com.example.vmtung.example;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CanvasAndPaint3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_and_paint3);

        final RoundChart chart = (RoundChart) this.findViewById(R.id.exampleRoundChart);
        chart.addItem("Agamemnon", 2, ContextCompat.getColor(this,R.color.blue));
        chart.addItem("Bocephus", 3.5f, ContextCompat.getColor(this, R.color.green));
        chart.addItem("Calliope", 2.5f, ContextCompat.getColor(this, R.color.yellow));
        chart.addItem("Daedalus", 3, ContextCompat.getColor(this, R.color.colorAccent));
        chart.addItem("Euripides", 1, ContextCompat.getColor(this, R.color.red));
        chart.addItem("Ganymede", 3, ContextCompat.getColor(this, R.color.black));
    }


}
