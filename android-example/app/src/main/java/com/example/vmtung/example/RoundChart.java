package com.example.vmtung.example;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vmtung on 11/08/2017.
 */

public class RoundChart extends View {

    private RectF mPieBounds = new RectF();
    private List<RoundChart.Item> mData = new ArrayList<RoundChart.Item>();

    private Paint mPiePaint;
    private Paint mTextPaint;
    private Paint chartNamePaint;

    private float mTotal = 0.0f;
    private float mTextHeight = 0.0f;
    private float mHighlightStrength = 1.15f;
    private float captionMarginLeft = 0f;
    private float textCaptionMarginTop = 0f;
    private float textCaptionDistanceBetweenAnother = 0f;
    private float chartMarginLeft = 0f;
    private float chartRadius = 0f;
    private float chartMarginTop = 0f;
    private float textCaptionSize = 0f;
    private float colorIconCaptionSize = 0f;
    private float chartNameMarginTop = 0f;
    private float chartNameMarginLeft = 0f;
    private float chartNameTextSize = 0f;
    private String chartName ;

    //private RoundChart.PieView mPieView;

    private RectF mBounds;

    public RoundChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RoundChart,
                0,
                0
        );

        try
        {
            captionMarginLeft = a.getDimension(R.styleable.RoundChart_captionMarginLeft, 0);
            textCaptionMarginTop = a.getDimension(R.styleable.RoundChart_textCaptionMarginTop, 0);
            textCaptionDistanceBetweenAnother = a.getDimension(R.styleable.RoundChart_textCaptionDistanceBetweenAnother, 0);
            chartMarginLeft = a.getDimension(R.styleable.RoundChart_chartMarginLeft, 0);
            chartRadius = a.getDimension(R.styleable.RoundChart_chartRadius, 0);
            chartMarginTop = a.getDimension(R.styleable.RoundChart_chartMarginTop, 0);
            textCaptionSize = a.getDimension(R.styleable.RoundChart_textCaptionSize, 0);
            colorIconCaptionSize = a.getDimension(R.styleable.RoundChart_colorIconCaptionSize, 0);
            chartNameMarginTop = a.getDimension(R.styleable.RoundChart_chartNameMarginTop, 0);
            chartNameMarginLeft = a.getDimension(R.styleable.RoundChart_chartNameMarginLeft, 0);
            chartNameTextSize = a.getDimension(R.styleable.RoundChart_chartNameTextSize, 0);
            chartName = a.getString(R.styleable.RoundChart_chartName);


        } finally {
            a.recycle();
        }
        init();
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float mTextY = textCaptionMarginTop;
        float centerX = (mBounds.left + mBounds.right) / 2;
        float centerY = (mBounds.top + mBounds.bottom) / 2;

        for (RoundChart.Item it : mData)
        {
            mPiePaint.setColor(it.mColor);
            canvas.drawArc(
                    mBounds,
                    360 - it.mEndAngle,
                    it.mEndAngle - it.mStartAngle,
                    true,
                    mPiePaint
            );

            canvas.drawText(it.mLabel, mBounds.right+captionMarginLeft+ getContext().getResources().getDimension(R.dimen.circle_chart_caption_margin_left), mTextY, mTextPaint);
            canvas.drawRect( mBounds.right+captionMarginLeft, mTextY - colorIconCaptionSize, mBounds.right+captionMarginLeft + colorIconCaptionSize, mTextY, mPiePaint);

            mTextY = mTextY+textCaptionDistanceBetweenAnother;

        }

        for (RoundChart.Item it : mData)
        {
            canvas.drawText(
                    it.percent+"%",
                    (float)(centerX+(chartRadius * Math.cos((it.mEndAngle+it.mStartAngle)*Math.PI/360))/2),
                    (float)(centerY - (chartRadius * Math.sin((it.mEndAngle+it.mStartAngle)*Math.PI/360))/2),
                    mTextPaint);
        }

        canvas.drawText(chartName, chartNameMarginLeft, chartNameMarginTop, chartNamePaint);
    }

    public class Item {
        public String mLabel;
        public float mValue;
        public int mColor;
        public int percent;

        // computed values
        public int mStartAngle;
        public int mEndAngle;
        public int mHighlight;
    }

    public int addItem(String label, float value, int color) {
        RoundChart.Item it = new RoundChart.Item();
        it.mLabel = label;
        it.mColor = color;
        it.mValue = value;

        it.mHighlight = Color.argb(
                0xff,
                Math.min((int) (mHighlightStrength * (float) Color.red(color)), 0xff),
                Math.min((int) (mHighlightStrength * (float) Color.green(color)), 0xff),
                Math.min((int) (mHighlightStrength * (float) Color.blue(color)), 0xff)
        );

        mTotal += value;

        mData.add(it);

        onDataChanged();

        return mData.size() - 1;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);


        mBounds = new RectF(chartMarginLeft, chartMarginTop, chartMarginLeft + 2* chartRadius, chartMarginTop + 2* chartRadius);

        // Figure out how big we can make the pie.
        float diameter = Math.min(w, h);
        mPieBounds = new RectF(
                0f,
                0f,
                diameter,
                diameter);
    }

    private void onDataChanged() {
        // When the data changes, we have to recalculate
        // all of the angles.
        int currentAngle = 0;
        for (RoundChart.Item it : mData) {
            it.mStartAngle = currentAngle;
            it.mEndAngle = (int) ((float) currentAngle + it.mValue * 360.0f / mTotal);
            currentAngle = it.mEndAngle;
            it.percent = (int)(it.mValue*100/mTotal);

        }

    }

    private void init() {

        mPiePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPiePaint.setStyle(Paint.Style.FILL);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextSize(textCaptionSize);

        chartNamePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        chartNamePaint.setColor(Color.BLACK);
        chartNamePaint.setTextSize(chartNameTextSize);
    }
}
