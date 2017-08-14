package com.example.vmtung.example;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class CanvasAndPaint2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_and_paint2);
        final ClockView clock = (ClockView) findViewById(R.id.clockViewId);
        final BitMapClockView bitmapClock = (BitMapClockView) findViewById(R.id.bitMapClockView);

        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new TimerTask() {
                    @Override
                    public void run() {
                        updateTimeClock(clock);
                        updateTimeClock(bitmapClock);
                    }
                });
            }

        }, 0, 1000);

        final RoundChart chart = (RoundChart) this.findViewById(R.id.exampleRoundChart);
        chart.addItem("Agamemnon", 2, ContextCompat.getColor(this,R.color.blue));
        chart.addItem("Bocephus", 3.5f, ContextCompat.getColor(this, R.color.green));
        chart.addItem("Calliope", 2.5f, ContextCompat.getColor(this, R.color.yellow));
        chart.addItem("Daedalus", 3, ContextCompat.getColor(this, R.color.white));
        chart.addItem("Euripides", 1, ContextCompat.getColor(this, R.color.blue));
        chart.addItem("Ganymede", 3, ContextCompat.getColor(this, R.color.black));
    }

    private void updateTimeClock(ClockView clock)
    {
        float milliSeconAngle = clock.getMillisecondAngel();
        float minuteAngle = clock.getMinuteAngel();
        Log.d("DEBUG","angle:"+milliSeconAngle);
        milliSeconAngle = milliSeconAngle - (float) (Math.PI/30);


        if(milliSeconAngle<-2*Math.PI)
        {
            milliSeconAngle = 0;
            minuteAngle = minuteAngle - (float) (Math.PI/30);
        }

        clock.setMillisecondAngel(milliSeconAngle);
        clock.setMinuteAngel(minuteAngle);

        clock.invalidate();
    }

    private void updateTimeClock(BitMapClockView clock)
    {
        float milliSeconAngle = clock.getMillisecondAngel();
        float minuteAngle = clock.getMinuteAngel();
        Log.d("DEBUG","angle:"+milliSeconAngle);
        milliSeconAngle = milliSeconAngle - (float) (Math.PI/30);


        if(milliSeconAngle<-2*Math.PI)
        {
            milliSeconAngle = 0;
            minuteAngle = minuteAngle - (float) (Math.PI/30);
        }

        clock.setMillisecondAngel(milliSeconAngle);
        clock.setMinuteAngel(minuteAngle);

        clock.invalidate();
    }
}
