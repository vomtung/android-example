package com.example.vmtung.example;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PropertyAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        Button startAnimation1 = (Button)findViewById(R.id.startAnimationButtonn1);
        Button startAnimation2 = (Button)findViewById(R.id.startAnimationButtonn2);
        Button startAnimation3 = (Button)findViewById(R.id.startAnimationButtonn3);
        Button startObjectAnimationButton = (Button)findViewById(R.id.startObjectAnimationButton);
        Button animatorSetXMLButton = (Button)findViewById(R.id.animatorSetXMLButton);

        final View propertyAnimationView1 = findViewById(R.id.propertyAnimationView1);
        final View propertyAnimationView2 = findViewById(R.id.propertyAnimationView2);
        final View propertyAnimationView3 = findViewById(R.id.propertyAnimationView3);
        final View objectAnimationView = findViewById(R.id.objectAnimationView);
        final TextView statusAnimationTextView = (TextView) findViewById(R.id.statusAnimationTextView);
        final View animatorSetView = (View) findViewById(R.id.animatorSetView);


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

        startAnimation3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveWithValueAnimator2(propertyAnimationView3, statusAnimationTextView);
            }
        });

        startObjectAnimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveWithObjectAnimator(objectAnimationView);
            }
        });

        animatorSetXMLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(
                        PropertyAnimationActivity.this,
                        R.animator.animation_load_from_xml_example
                );
                set.setTarget(animatorSetView);
                set.start();
            }
        });
    }

    public void moveWithValueAnimator(final View view){
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

    public void moveWithValueAnimator2(final View view, final TextView resultView){
        ValueAnimator va = ValueAnimator.ofFloat(0f, 300f);
        int mDuration = 3000; //in millis
        va.setDuration(mDuration);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setTranslationX((float)animation.getAnimatedValue());

            }
        });
        va.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                resultView.setText(getString(R.string.Start));
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                resultView.setText(getString(R.string.End));
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                resultView.setText(getString(R.string.Repeat));

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
