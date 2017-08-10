package com.example.vmtung.example;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by vmtung on 07/08/2017.
 */

public class IconTextButton extends FrameLayout {

    public IconTextButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.IconTextViewButton, 0, 0);

        int valueColor = a.getColor(R.styleable.ColorOptionsView_valueColor, ContextCompat.getColor(context, R.color.blue));
        String titleText = a.getString(R.styleable.IconTextViewButton_titleTextView);
        int iconResourceId = a.getResourceId(R.styleable.IconTextViewButton_iconResource, 0);
        a.recycle();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_icon_text_view_button, this, true);
        ImageView image = (ImageView) this.findViewById(R.id.imageIcon);
        TextView titleTextView = (TextView) this.findViewById(R.id.titleTextView);

        View container = (View) this.findViewById(R.id.container);

        container.setBackgroundColor(valueColor);
        titleTextView.setText(titleText);
        image.setImageResource(iconResourceId);

    }

    public IconTextButton(@NonNull Context context)
    {
        super(context);

    }


}
