package com.example.vmtung.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button popoverButton = (Button)findViewById(R.id.popoverButton);
        Button menuButton = (Button)findViewById(R.id.menuButton);
        Button frameLayoutButton = (Button)findViewById(R.id.frameLayoutButton);
        Button spinnerExampleButton = (Button)findViewById(R.id.spinnerExampleButton);
        Button alertDialogExampleButton = (Button)findViewById(R.id.alertDialogExampleButton);
        Button compundViewButton = (Button)findViewById(R.id.compundViewButton);
        Button customViewButton = (Button)findViewById(R.id.customViewButton);
        Button canvasButton = (Button)findViewById(R.id.canvasButton);
        Button canvasButton2 = (Button)findViewById(R.id.canvasButton2);
        Button canvasButton3 = (Button)findViewById(R.id.canvasButton3);

        popoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PopoverExampleActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MenuActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        frameLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FrameLayoutExampleActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        spinnerExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SpinnerActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        alertDialogExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AlerDialogExampleActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        compundViewButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CompoundViewActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        customViewButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CustomViewActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        canvasButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CanvasAndPaintExampleActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        canvasButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CanvasAndPaint2Activity.class);
                MainActivity.this.startActivity(i);
            }
        });

        canvasButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CanvasAndPaint3Activity.class);
                MainActivity.this.startActivity(i);
            }
        });
    }
}
