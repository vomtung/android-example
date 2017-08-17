package com.example.vmtung.example;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vmtung on 16/08/2017.
 */

public class LineChart extends View
{
    private List<Item> mData = new ArrayList<Item>();

    private Paint axisPaint;
    private Paint captionLeftPaint;
    private Paint captionBottomPaint;
    private Paint chartNamePaint;

    private float captionMarginLeft = 0f;
    private float chartRadius = 0f;
    private float chartMarginTop = 0f;
    private float textValueAxisSize = 0f;
    private float colorIconHintSize = 0f;
    private float chartNameMarginTop = 0f;
    private float chartNameMarginLeft = 0f;
    private float chartNameTextSize = 0f;
    private float marginLeftValueAndChart = 0f;
    private float marginBottomYAxisAndChart = 0f;
    private float yAxisStepHeight;
    private float xAxisWidth =100;
    private float xAxisStepWidth = 0f;
    private float originPointX=0f;
    private float originPointY=0f;
    private float lineStroke=0f;
    private String chartName ;
    private int maxYAxisValue;
    private int yAxisStepValue;

    private CharSequence[] xArrayEntries;
    private String[]xEntries;

    public LineChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.LineChart,
                0,
                0
        );

        try
        {
            captionMarginLeft = a.getDimension(R.styleable.LineChart_xAxisValueMarginLeft, 0);
            chartRadius = a.getDimension(R.styleable.LineChart_chartRadius, 0);
            chartMarginTop = a.getDimension(R.styleable.LineChart_chartMarginTop, 0);
            textValueAxisSize = a.getDimension(R.styleable.LineChart_textValueAxisSize, 0);
            colorIconHintSize = a.getDimension(R.styleable.LineChart_colorIconCaptionSize, 0);
            chartNameMarginTop = a.getDimension(R.styleable.LineChart_chartNameMarginTop, 0);
            chartNameMarginLeft = a.getDimension(R.styleable.LineChart_chartNameMarginLeft, 0);
            chartNameTextSize = a.getDimension(R.styleable.LineChart_chartNameTextSize, 0);
            maxYAxisValue = a.getInteger(R.styleable.LineChart_maxYaxisValue, 0);
            yAxisStepValue = a.getInteger(R.styleable.LineChart_yAxisStepValue, 0);
            yAxisStepHeight = a.getDimension(R.styleable.LineChart_yAxisStepHeight, 0);
            xAxisStepWidth = a.getDimension(R.styleable.LineChart_xAxisStepWidth, 0);
            chartName = a.getString(R.styleable.LineChart_chartName);
            marginLeftValueAndChart = a.getDimension(R.styleable.LineChart_marginLeftXAxisAndChart, 0);
            marginBottomYAxisAndChart = a.getDimension(R.styleable.LineChart_marginBottomYAxisAndChart, 0);
            lineStroke = a.getDimension(R.styleable.LineChart_lineStroke, 0);

        } finally {
            a.recycle();
        }
        init();
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        int numberOfStep = Math.round(maxYAxisValue/yAxisStepValue);
        float yAxisHeight = numberOfStep* yAxisStepHeight;
        originPointY = yAxisHeight+ chartMarginTop;
        originPointX = captionMarginLeft+ marginLeftValueAndChart;

        for (int i = 0; i <= numberOfStep; i = i+ 1) {
            canvas.drawText(
                    i * yAxisStepValue + "",
                    captionMarginLeft,
                    originPointY - i * yAxisStepHeight,
                    captionLeftPaint
            );

            canvas.drawLine(originPointX , originPointY - i * yAxisStepHeight, xAxisWidth, originPointY - i * yAxisStepHeight, axisPaint);
        }
        for(int i =0;i < xEntries.length; i++)
        {

            canvas.drawText(
                    xEntries[i],
                    originPointX + xAxisStepWidth*i,
                    originPointY + marginBottomYAxisAndChart,
                    captionBottomPaint
            );
        }

        for (LineChart.Item item :mData)
        {
            drawLine(canvas, item, xEntries);
        }


    }

    public class Item {
        private String mLabel;
        private List<LineItem> mValue;
        private int mColor;

        public Item(String mLabel, List<LineItem> mValue, int mColor) {
            this.mLabel = mLabel;
            this.mValue = mValue;
            this.mColor = mColor;
        }

        public String getmLabel() {
            return mLabel;
        }

        public void setmLabel(String mLabel) {
            this.mLabel = mLabel;
        }

        public List<LineItem> getmValue() {
            return mValue;
        }

        public int getmColor() {
            return mColor;
        }

        public void setmColor(int mColor) {
            this.mColor = mColor;
        }
    }

    void drawLine(Canvas canvas, LineChart.Item item, String[]xArrayEntries)
    {
        Point previousPoint = null;
        Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStrokeWidth(lineStroke);
        linePaint.setColor(item.getmColor());

        for (int i =0;i<xArrayEntries.length; i++)
        {
            String label = xArrayEntries[i];
            LineItem lineItem = getLineItemByLabel(item.getmValue(), label);
            if(lineItem==null)
            {
                continue;
            }
            if(previousPoint!=null) {
                Point newPoint = new Point(
                        originPointX + xAxisStepWidth*i,
                        originPointY - (lineItem.value/yAxisStepValue)*yAxisStepHeight
                        );
                canvas.drawLine(
                        previousPoint.getX(),
                        previousPoint.getY(),
                        newPoint.getX(),
                        newPoint.getY(),
                        linePaint
                        );
                previousPoint = newPoint;
            }
            else
            {
                previousPoint = new Point(
                        originPointX + xAxisStepWidth*i,
                        originPointY - (lineItem.value/yAxisStepValue)*yAxisStepHeight
                );
            }
        }
    }

    public static class LineItem
    {
        private String name;
        private int value;

        public LineItem(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    };

    private LineItem getLineItemByLabel(List<LineItem>items, String label)
    {
        for (LineItem lineItem:items)
        {
            if (lineItem.getName().equals(label))
            {
                return lineItem;
            }
        }
        return null;
    };

    public int addItem(String label, List<LineItem> mValue, int color) {
        Item it = new Item(label, mValue, color);
        mData.add(it);
        return mData.size() - 1;
    }

    public void addXEntries(String[]xEntries)
    {
        xAxisWidth = xAxisWidth + xAxisStepWidth*(xEntries.length-1);
        this.xEntries = xEntries;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }


    private void init()
    {
    axisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    axisPaint.setStrokeWidth(3);
    axisPaint.setColor(Color.GRAY);

    captionLeftPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    captionLeftPaint.setColor(Color.BLACK);
    captionLeftPaint.setTextSize(textValueAxisSize);
    captionLeftPaint.setTextAlign(Paint.Align.RIGHT);

    captionBottomPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    captionBottomPaint.setColor(Color.BLACK);
    captionBottomPaint.setTextSize(textValueAxisSize);
    captionBottomPaint.setTextAlign(Paint.Align.CENTER);

    chartNamePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    chartNamePaint.setColor(Color.BLACK);
    chartNamePaint.setTextSize(chartNameTextSize);
    }
}
