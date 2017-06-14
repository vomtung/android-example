package com.example.vmtung.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class FrameLayoutExampleActivity extends AppCompatActivity {

    private final String TAG = "FrameLayoutExample" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_example);
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        Button clickMeButton = (Button)findViewById(R.id.clickMeButton);
        final EditText logEdittext = (EditText)findViewById(R.id.logEditText);
        final Button logClearButton = (Button)findViewById(R.id.logClearButton);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Linear Layout");
                logEdittext.append("Linear Layout"+"\n");
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
