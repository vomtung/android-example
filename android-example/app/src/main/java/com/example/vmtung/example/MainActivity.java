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
    }
}
