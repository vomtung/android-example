package com.example.vmtung.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class ScreenPropertyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_property);

        TextView widthTextView = (TextView)findViewById(R.id.widthTextView);
        TextView heightTextView = (TextView)findViewById(R.id.heightTextView);
        TextView densityTextView = (TextView)findViewById(R.id.densityTextView);
        TextView densityDpiTextView = (TextView)findViewById(R.id.densityDpiTextView);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        widthTextView.setText(width+"dp");
        heightTextView.setText(height+"dp");
        densityTextView.setText(displayMetrics.density+"");
        densityDpiTextView.setText(displayMetrics.densityDpi+"dpi");

    }
}
