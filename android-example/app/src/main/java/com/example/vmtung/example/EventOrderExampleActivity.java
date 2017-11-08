package com.example.vmtung.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class EventOrderExampleActivity extends AppCompatActivity {

    private final String TAG = "EventOrderExampleActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_order_example);
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.frameLayout);
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        Button clickMeButton = (Button)findViewById(R.id.clickMeButton);
        final EditText logEdittext = (EditText)findViewById(R.id.logEditText);
        final Button logClearButton = (Button)findViewById(R.id.logClearButton);
        final LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"LinearLayout");
                logEdittext.append("LinearLayout"+"\n");
            }
        });

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Frame Layout");
                logEdittext.append("Frame Layout"+"\n");
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"relativeLayout");
                logEdittext.append("relativeLayout"+"\n");
            }
        });

        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logEdittext.append("clickMeButton"+"\n");
           }
        });

        logClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logEdittext.setText(null);
            }
        });
    }
}
