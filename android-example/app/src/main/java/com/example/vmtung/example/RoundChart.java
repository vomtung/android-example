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

public class RoundChart extends ViewGroup {

    private RectF mPieBounds = new RectF();
    private List<RoundChart.Item> mData = new ArrayList<RoundChart.Item>();

    private Paint mPiePaint;
    private Paint mTextPaint;

    private float mTotal = 0.0f;
    private float mTextHeight = 0.0f;
    private float mHighlightStrength = 1.15f;
    private float hintMarginLeft = 0f;
    private float textHintMarginTop = 0f;
    private float textHintDistanceBetweenAnother = 0f;
    private float chartMarginLeft = 0f;
    private float chartRadius = 0f;
    private float chartMarginTop = 0f;
    private float textHintSize = 0f;
    private float colorIconHintSize = 0f;

    private RoundChart.PieView mPieView;

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
            hintMarginLeft = a.getDimension(R.styleable.RoundChart_hintMarginLeft, 0);
            textHintMarginTop = a.getDimension(R.styleable.RoundChart_textHintMarginTop, 0);
            textHintDistanceBetweenAnother = a.getDimension(R.styleable.RoundChart_textHintDistanceBetweenAnother, 0);
            chartMarginLeft = a.getDimension(R.styleable.RoundChart_chartMarginLeft, 0);
            chartRadius = a.getDimension(R.styleable.RoundChart_chartRadius, 0);
            chartMarginTop = a.getDimension(R.styleable.RoundChart_chartMarginTop, 0);
            textHintSize = a.getDimension(R.styleable.RoundChart_textHintSize, 0);
            colorIconHintSize = a.getDimension(R.styleable.RoundChart_colorIconHintSize, 0);


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
    }

    private class Item {
        public String mLabel;
        public float mValue;
        public int mColor;

        // computed values
        public int mStartAngle;
        public int mEndAngle;

        public int mHighlight;
    }


    private class PieView extends View {

        private RectF mBounds;

        public PieView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            float mTextY = textHintMarginTop;
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

                canvas.drawText(it.mLabel, mBounds.right+hintMarginLeft+ getContext().getResources().getDimension(R.dimen.circle_chart_hint_margin_left), mTextY, mTextPaint);
                canvas.drawRect( mBounds.right+hintMarginLeft, mTextY - colorIconHintSize, mBounds.right+hintMarginLeft + colorIconHintSize, mTextY, mPiePaint);
                mTextY = mTextY+textHintDistanceBetweenAnother;

            }

        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            mBounds = new RectF(chartMarginLeft, chartMarginTop, chartMarginLeft + 2* chartRadius, chartMarginTop + 2* chartRadius);
        }

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

        // Figure out how big we can make the pie.
        float diameter = Math.min(w, h);
        mPieBounds = new RectF(
                0f,
                0f,
                diameter,
                diameter);
        //mPieBounds.offsetTo(getPaddingLeft(), getPaddingTop());

        // Lay out the child view that actually draws the pie.
        mPieView.layout(
                (int) mPieBounds.left,
                (int) mPieBounds.top,
                (int) mPieBounds.right,
                (int) mPieBounds.bottom
        );


        onDataChanged();
    }

    private void onDataChanged() {
        // When the data changes, we have to recalculate
        // all of the angles.
        int currentAngle = 0;
        for (RoundChart.Item it : mData) {
            it.mStartAngle = currentAngle;
            it.mEndAngle = (int) ((float) currentAngle + it.mValue * 360.0f / mTotal);
            currentAngle = it.mEndAngle;

        }

    }

    private void init() {

        mPiePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPiePaint.setStyle(Paint.Style.FILL);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextSize(textHintSize);

        mPieView = new PieView(getContext());
        addView(mPieView);
        //mPieView.rotateTo(mPieRotation);

    }
}
