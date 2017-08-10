package com.example.vmtung.example;

import android.content.res.Resources;
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
        pie.addItem("Agamemnon", 2, res.getColor(R.color.blue));
        pie.addItem("Bocephus", 3.5f, res.getColor(R.color.red));
        pie.addItem("Calliope", 2.5f, res.getColor(R.color.black));
        pie.addItem("Daedalus", 3, res.getColor(R.color.yellow));
        pie.addItem("Euripides", 1, res.getColor(R.color.green));
        pie.addItem("Ganymede", 3, res.getColor(R.color.white));

        ((Button) findViewById(R.id.Reset)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                pie.setCurrentItem(0);
            }
        });
    }
}
