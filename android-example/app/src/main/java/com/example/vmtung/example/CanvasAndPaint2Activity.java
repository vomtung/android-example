package com.example.vmtung.example;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
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
