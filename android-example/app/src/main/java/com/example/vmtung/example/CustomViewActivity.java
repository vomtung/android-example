package com.example.vmtung.example;

import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        Resources res = getResources();

        final PieChart pie = (PieChart) this.findViewById(R.id.Pie);
        pie.addItem("Agamemnon", 2, ContextCompat.getColor(this,R.color.blue));
        pie.addItem("Bocephus", 3.5f, ContextCompat.getColor(this,R.color.red));
        pie.addItem("Calliope", 2.5f, ContextCompat.getColor(this,R.color.black));
        pie.addItem("Daedalus", 3, ContextCompat.getColor(this,R.color.yellow));
        pie.addItem("Euripides", 1, ContextCompat.getColor(this,R.color.green));
        pie.addItem("Ganymede", 3, ContextCompat.getColor(this,R.color.white));

    }
}
