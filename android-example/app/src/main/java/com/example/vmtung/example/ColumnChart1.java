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
 * Created by vmtung on 22/08/2017.
 */

public class ColumnChart1 extends View
{
    private List<ColumnChart1.Item> mData = new ArrayList<ColumnChart1.Item>();
    private String[]xEntries;

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
    private float marginBottomXAxisAndChart = 0f;
    private float yAxisStepHeight;
    private float xAxisWidth =100;
    private float xAxisStepWidth = 0f;
    private float originPointX=0f;
    private float originPointY=0f;
    private float lineStroke=0f;
    private float marginBetweenColumn;
    private String chartName ;
    private int maxYAxisValue;
    private int yAxisStepValue;

    public ColumnChart1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ColumnChart,
                0,
                0
        );

        try
        {
            captionMarginLeft = a.getDimension(R.styleable.ColumnChart_xAxisValueMarginLeft, 0);
            chartRadius = a.getDimension(R.styleable.ColumnChart_chartRadius, 0);
            chartMarginTop = a.getDimension(R.styleable.ColumnChart_chartMarginTop, 0);
            textValueAxisSize = a.getDimension(R.styleable.ColumnChart_textValueAxisSize, 0);
            colorIconHintSize = a.getDimension(R.styleable.ColumnChart_colorIconCaptionSize, 0);
            chartNameMarginTop = a.getDimension(R.styleable.ColumnChart_chartNameMarginTop, 0);
            chartNameMarginLeft = a.getDimension(R.styleable.ColumnChart_chartNameMarginLeft, 0);
            chartNameTextSize = a.getDimension(R.styleable.ColumnChart_chartNameTextSize, 0);
            maxYAxisValue = a.getInteger(R.styleable.ColumnChart_maxYaxisValue, 0);
            yAxisStepValue = a.getInteger(R.styleable.ColumnChart_yAxisStepValue, 0);
            yAxisStepHeight = a.getDimension(R.styleable.ColumnChart_yAxisStepHeight, 0);
            xAxisStepWidth = a.getDimension(R.styleable.ColumnChart_xAxisStepWidth, 0);
            chartName = a.getString(R.styleable.ColumnChart_chartName);
            marginLeftValueAndChart = a.getDimension(R.styleable.ColumnChart_marginLeftYAxisAndChart, 0);
            marginBottomXAxisAndChart = a.getDimension(R.styleable.ColumnChart_marginBottomXAxisAndChart, 0);
            lineStroke = a.getDimension(R.styleable.ColumnChart_lineStroke, 0);
            marginBetweenColumn = a.getDimension(R.styleable.ColumnChart_marginBetweenColumn, 0);

        } finally {
            a.recycle();
        }

        init();
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

            canvas.drawLine(
                    originPointX ,
                    originPointY - i * yAxisStepHeight,
                    xAxisWidth,
                    originPointY - i * yAxisStepHeight,
                    axisPaint
            );
        }


        for(int i =0;i < xEntries.length; i++)
        {

            canvas.drawText(
                    xEntries[i],
                    originPointX + xAxisStepWidth*i,
                    originPointY + marginBottomXAxisAndChart,
                    captionBottomPaint
            );
        }

        for (int i=0; i< mData.size();i++)
        {

            drawColumn(canvas, mData.get(i), xEntries, i);
        }
    }

    public static class ColumnItem
    {
        private String name;
        private int value;

        public ColumnItem(String name, int value) {
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

    public class Item {
        private String mLabel;
        private List<ColumnChart1.ColumnItem> mValue;
        private int mColor;

        public Item(String mLabel, List<ColumnChart1.ColumnItem> mValue, int mColor) {
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

        public List<ColumnChart1.ColumnItem> getmValue() {
            return mValue;
        }

        public int getmColor() {
            return mColor;
        }

        public void setmColor(int mColor) {
            this.mColor = mColor;
        }
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

    public int addItem(String label, List<ColumnChart1.ColumnItem> mValue, int color) {
        ColumnChart1.Item it = new ColumnChart1.Item(label, mValue, color);
        mData.add(it);
        return mData.size() - 1;
    }

    public void addXEntries(String[]xEntries)
    {
        xAxisWidth = xAxisWidth + xAxisStepWidth*(xEntries.length-1);
        this.xEntries = xEntries;
    }

    void drawColumn(Canvas canvas, ColumnChart1.Item item, String[]xArrayEntries, int columnIndex)
    {
        Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStrokeWidth(100);
        linePaint.setColor(item.getmColor());

        for (int i =0;i<xArrayEntries.length; i++)
        {
            String label = xArrayEntries[i];
            ColumnChart1.ColumnItem lineItem = getLineItemByLabel(item.getmValue(), label);
            if(lineItem==null)
            {
                continue;
            }

            canvas.drawLine(
                    originPointX + xAxisStepWidth*i + columnIndex*marginBetweenColumn,
                    originPointY - (lineItem.value/yAxisStepValue)*yAxisStepHeight,
                    originPointX + xAxisStepWidth*i +columnIndex*marginBetweenColumn,
                    originPointY,
                    linePaint
            );
        }
    }

    private ColumnChart1.ColumnItem getLineItemByLabel(List<ColumnChart1.ColumnItem>items, String label)
    {
        for (ColumnChart1.ColumnItem columnItem:items)
        {
            if (columnItem.getName().equals(label))
            {
                return columnItem;
            }
        }
        return null;
    };
}
