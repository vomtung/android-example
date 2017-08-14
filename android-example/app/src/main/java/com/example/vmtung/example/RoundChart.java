package com.example.vmtung.example;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
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

    private List<RoundChart.Item> mData = new ArrayList<RoundChart.Item>();
    private float mTotal = 0.0f;

    private RectF mPieBounds = new RectF();

    private Paint mPiePaint;

    private boolean mShowText = false;

    private float mTextX = 0.0f;
    private float mTextY = 0.0f;
    private float mTextWidth = 0.0f;
    private float mTextHeight = 0.0f;
    private int mTextPos = 0;

    private float mHighlightStrength = 1.15f;

    private float mPointerRadius = 2.0f;
    private float mPointerX;
    private float mPointerY;

    private int mPieRotation;

    private PieChart.OnCurrentItemChangedListener mCurrentItemChangedListener = null;

    private int mTextColor;
    private RoundChart.PieView mPieView;
    private Scroller mScroller;
    private ValueAnimator mScrollAnimator;
    private GestureDetector mDetector;

    // The angle at which we measure the current item. This is
    // where the pointer points.
    private int mCurrentItemAngle;

    // the index of the current item.
    private int mCurrentItem = 0;
    private boolean mAutoCenterInSlice;
    private ObjectAnimator mAutoCenterAnimator;
    private RectF mShadowBounds = new RectF();
    public RoundChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
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
        public Shader mShader;
    }

    private class PieView extends View {

        /**
         * Construct a PieView
         *
         * @param context
         */
        public PieView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
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
            }

        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            mBounds = new RectF(0, 0, w, h);
        }

        RectF mBounds;

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


        float xpad = (float) (getPaddingLeft() + getPaddingRight());
        float ypad = (float) (getPaddingTop() + getPaddingBottom());

        // Account for the label


        // Figure out how big we can make the pie.
        float diameter = Math.min(w, h);
        mPieBounds = new RectF(
                0.0f,
                0.0f,
                diameter,
                diameter);

        // Lay out the child view that actually draws the pie.
        mPieView.layout((int) mPieBounds.left,
                (int) mPieBounds.top,
                (int) mPieBounds.right,
                (int) mPieBounds.bottom);


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
        mPiePaint.setTextSize(mTextHeight);

        mPieView = new PieView(getContext());
        addView(mPieView);
        //mPieView.rotateTo(mPieRotation);

    }


}
