package com.example.vmtung.example;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by vmtung on 10/08/2017.
 */

public class CircleView extends View
{
    private int mCurrentAngle=0;

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint paint = new Paint(0);

        int width = this.getWidth();
        int height = this.getHeight();
        float radius = Math.min(width/4, height/4);

        paint.setColor(0xffFF1010);
        paint.setStrokeWidth(5);
        paint.setMaskFilter(new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL));

        canvas.drawCircle(width/4, height/4,radius, paint);

        RectF rectF = new RectF(0, 0, 400, 400);
        paint.setColor(Color.BLUE);
        canvas.drawArc (rectF, -90, 90, true, paint);
        paint.setColor(Color.YELLOW);
        canvas.drawArc (rectF, 45, 30, true, paint);
        paint.setColor(Color.GREEN);
        canvas.drawArc (rectF, 90, 45, true, paint);
        paint.setColor(Color.CYAN);
        canvas.drawArc (rectF, 180, 45, true, paint);
    }
}