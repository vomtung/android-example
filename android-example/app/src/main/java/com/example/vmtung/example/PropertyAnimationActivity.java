package com.example.vmtung.example;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PropertyAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        Button startAnimation1 = (Button)findViewById(R.id.startAnimationButtonn1);
        Button startAnimation2 = (Button)findViewById(R.id.startAnimationButtonn2);
        Button startObjectAnimationButton = (Button)findViewById(R.id.startObjectAnimationButton);

        final View propertyAnimationView1 = findViewById(R.id.propertyAnimationView1);
        final View propertyAnimationView2 = findViewById(R.id.propertyAnimationView2);
        final View objectAnimationView = findViewById(R.id.objectAnimationView);


        startAnimation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveWithValueAnimator(propertyAnimationView1);
            }
        });

        startAnimation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveWithValueAnimator(propertyAnimationView2);
            }
        });

        startObjectAnimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveWithObjectAnimator(objectAnimationView);
            }
        });
    }

    public static void moveWithValueAnimator(final View view){
        ValueAnimator va = ValueAnimator.ofFloat(0f, 300f);
        int mDuration = 3000; //in millis
        va.setDuration(mDuration);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setTranslationX((float)animation.getAnimatedValue());
            }
        });
        va.setRepeatCount(5);
        va.start();
    }

    public static void moveWithObjectAnimator(final View view)
    {
        ObjectAnimator ob = ObjectAnimator.ofFloat(view, "translationX", 100f);
        int mDuration = 3000; //in millis
        ob.setDuration(mDuration);

        ob.setRepeatCount(5);
        ob.start();
    }
}
