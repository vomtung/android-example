package com.example.vmtung.example;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by vmtung on 10/08/2017.
 */

public class ClockView extends View
{
    private float radius;
    private float millisecondAngel;
    private float minuteAngel;
    private float millisecondHandLenght=0;
    private float minuteHandLenght=0;

    public ClockView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint paint1 = new Paint(0);
        Paint paint2 = new Paint(0);
        Paint paint3 = new Paint(0);

        int width = this.getWidth();
        int height = this.getHeight();

        paint1.setColor(0xffFF1010);

        paint2.setColor(0xffFFFF10);
        paint2.setStrokeWidth(10);

        paint3.setColor(0xff800080);
        paint3.setStrokeWidth(20);

        radius = Math.min(width/2,height/2);
        millisecondHandLenght = (float) width/2-5;
        minuteHandLenght = (float) width/2-25;

        double milisecondEndX   =  width/2 + millisecondHandLenght * Math.cos(millisecondAngel);
        double milisecondEndY   = height/2 - millisecondHandLenght * Math.sin(millisecondAngel);

        double minuteEndX   =  width/2 + minuteHandLenght * Math.cos(minuteAngel);
        double minuteEndY   = height/2 - minuteHandLenght * Math.sin(minuteAngel);

        canvas.drawCircle(width/2, height/2,radius, paint1);
        canvas.drawLine(width/2, height/2, (float)milisecondEndX, (float)milisecondEndY, paint2);
        canvas.drawLine(width/2, height/2, (float)minuteEndX, (float)minuteEndY, paint3);

    }

    public float getMillisecondAngel() {
        return millisecondAngel;
    }

    public void setMillisecondAngel(float millisecondAngel) {
        this.millisecondAngel = millisecondAngel;
    }

    public float getMinuteAngel() {
        return minuteAngel;
    }

    public void setMinuteAngel(float minuteAngel) {
        this.minuteAngel = minuteAngel;
    }
}
