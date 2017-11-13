package com.example.vmtung.example;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrawableResourceExampleActivity extends AppCompatActivity {

    private static final String HEX_PATTERN = "^#([A-Fa-f0-9]{6})$";

    private View view1;
    private View view2;
    private View view3;
    private EditText colorCodeEditText;
    private int cornerRadius = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_resource_example);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        colorCodeEditText = (EditText)findViewById(R.id.colorCodeEditText);

        colorCodeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if(colorCodeEditText.getText()!=null && colorCodeEditText.getText().toString()!=null
                        && validate(colorCodeEditText.getText().toString())
                        )
                {


                    Timer timer = new Timer();

                    TimerTask timeTask= new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    cornerRadius = cornerRadius+5;
                                    setRoundedDrawable(DrawableResourceExampleActivity.this,
                                            view1,
                                            Color.parseColor(colorCodeEditText.getText().toString()),
                                            0,
                                            cornerRadius,
                                            2
                                    );
                                }
                            });


                        }
                    };
                    timer.schedule(timeTask, 1000,1000);
                }
            }
        });
    }

    public static void setRoundedDrawable(Context context, View view, int backgroundColor, int borderColor, int cornerRadius, int stroke)
    {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(cornerRadius);
        shape.setColor(backgroundColor);
        if (borderColor != 0){
            shape.setStroke(2, borderColor);
        }
        view.setBackground(shape);
    }

    public boolean validate(final String hex){

        Pattern pattern = Pattern.compile(HEX_PATTERN);
        Matcher matcher;

        matcher = pattern.matcher(hex);
        return matcher.matches();

    }
}
