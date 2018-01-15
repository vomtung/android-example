package com.example.vmtung.example;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import static android.view.MotionEvent.INVALID_POINTER_ID;

public class DragAndDropActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_and_drop);
        View demoView = findViewById(R.id.demoView);

        demoView.setOnTouchListener(new View.OnTouchListener()
        {
            float mLastTouchX;
            float mLastTouchY;
            int mActivePointerId;
            float mPosX;
            float mPosY;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {

                final int action = MotionEventCompat.getActionMasked(motionEvent);

                switch (action) {
                    case MotionEvent.ACTION_DOWN: {
                        final int pointerIndex = MotionEventCompat.getActionIndex(motionEvent);
                        final float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                        final float y = MotionEventCompat.getY(motionEvent, pointerIndex);

                        // Remember where we started (for dragging)
                        mLastTouchX = x;
                        mLastTouchY = y;
                        // Save the ID of this pointer (for dragging)
                        mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                        view.animate()
                                //.x(x)
                                .x(motionEvent.getRawX() )
                                //.y(y)
                                .y(motionEvent.getRawY() )
                                .setDuration(0)
                                .start();
                        break;
                    }

                    case MotionEvent.ACTION_MOVE: {
                        // Find the index of the active pointer and fetch its position
                        final int pointerIndex =
                                MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);

                        final float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                        final float y = MotionEventCompat.getY(motionEvent, pointerIndex);

                        // Calculate the distance moved
                        final float dx = x - mLastTouchX;
                        final float dy = y - mLastTouchY;

                        mPosX += dx;
                        mPosY += dy;

                        //invalidate();

                        // Remember this touch position for the next moveWithValueAnimator event
                        mLastTouchX = x;
                        mLastTouchY = y;
                        view.animate()
                                //.x(x)
                                .x(motionEvent.getRawX() )
                                //.y(y)
                                .y(motionEvent.getRawY() )
                                .setDuration(0)
                                .start();

                        break;
                    }

                    case MotionEvent.ACTION_UP: {
                        mActivePointerId = INVALID_POINTER_ID;
                        break;
                    }

                    case MotionEvent.ACTION_CANCEL: {
                        mActivePointerId = INVALID_POINTER_ID;
                        break;
                    }

                    case MotionEvent.ACTION_POINTER_UP: {

                        final int pointerIndex = MotionEventCompat.getActionIndex(motionEvent);
                        final int pointerId = MotionEventCompat.getPointerId(motionEvent, pointerIndex);

                        if (pointerId == mActivePointerId) {
                            // This was our active pointer going up. Choose a new
                            // active pointer and adjust accordingly.
                            final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                            mLastTouchX = MotionEventCompat.getX(motionEvent, newPointerIndex);
                            mLastTouchY = MotionEventCompat.getY(motionEvent, newPointerIndex);
                            mActivePointerId = MotionEventCompat.getPointerId(motionEvent, newPointerIndex);
                        }
                        break;
                    }
                }

                return true;
            }
        });
    }
}
