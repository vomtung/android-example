package com.example.vmtung.example;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by vmtung on 10/08/2017.
 */

public class BitMapClockView extends View {

    private float millisecondAngel;
    private float minuteAngel;

    public BitMapClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        Log.d("DEBUG", "millisecondAngel:"+millisecondAngel+":minuteAngel"+minuteAngel);

        Bitmap bitmapClock = BitmapFactory.decodeResource(getResources(), R.drawable.ic_clock_canvas);
        Bitmap bitmapSecond = BitmapFactory.decodeResource(getResources(), R.drawable.ic_clock_hand_second);
        Bitmap bitmapMinute = BitmapFactory.decodeResource(getResources(), R.drawable.ic_clock_hand_minute);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);

        int width = this.getWidth();
        int height = this.getHeight();

        Rect rectClock = new Rect(0, 0, width, height);

        Matrix secondMatrix = new Matrix();
        Log.d("Milisecon", width+"---"+bitmapSecond.getWidth()+"---"+width/(bitmapSecond.getWidth()));
        secondMatrix.postScale((float)width/(bitmapSecond.getWidth()), (float)height/(bitmapSecond.getHeight()));
        //secondMatrix.postScale((float)0.3, (float)0.3);
        secondMatrix.postRotate((float)(millisecondAngel*180/Math.PI), width/2, height/2);

        Matrix minuteMatrix = new Matrix();
        minuteMatrix.postScale((float)width/(bitmapMinute.getWidth()), (float)height/(bitmapMinute.getHeight()));
        minuteMatrix.postRotate((float)(minuteAngel*180/Math.PI), width/2, height/2);

        canvas.drawBitmap(bitmapSecond, secondMatrix, paint);
        canvas.drawBitmap(bitmapMinute, minuteMatrix, paint);
        canvas.drawBitmap(bitmapClock, null, rectClock, paint);
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
