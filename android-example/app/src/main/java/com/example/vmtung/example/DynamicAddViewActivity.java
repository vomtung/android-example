package com.example.vmtung.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DynamicAddViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_add_view);
        final LinearLayout containerLinearLayout = (LinearLayout)findViewById(R.id.containerLinearLayout);
        final LinearLayout horizontalLinearLayout = (LinearLayout)findViewById(R.id.horizontalLinearLayout);
        Button addNewView = (Button)findViewById(R.id.addNewView);
        Button addNewViewHorizontal = (Button)findViewById(R.id.addNewViewHorizontal);


        addNewView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = new ImageView(DynamicAddViewActivity.this);
                imageView.setImageResource(R.drawable.ic_fall);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //imageView.setBackgroundColor(ContextCompat.getColor(NewNoteActivity.this, R.color.blue));

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(500,500);
                lp.setMargins(100, 50, 0, 100);

                imageView.setLayoutParams(
                        new ViewGroup.LayoutParams(lp)
                );

                containerLinearLayout.addView(imageView, lp);
            }
        });

        addNewViewHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = new ImageView(DynamicAddViewActivity.this);
                imageView.setImageResource(R.drawable.ic_fall);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //imageView.setBackgroundColor(ContextCompat.getColor(NewNoteActivity.this, R.color.blue));

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(500,500);
                lp.setMargins(100, 50, 200, 100);

                imageView.setLayoutParams(
                        new ViewGroup.LayoutParams(lp)
                );

                horizontalLinearLayout.addView(imageView, lp);
            }
        });
    }
}
