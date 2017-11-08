package com.example.vmtung.example;

import android.support.design.widget.AppBarLayout;

/**
 * Created by vmtung on 11/09/2017.
 */

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {

    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private State mCurrentState = State.IDLE;

    @Override
    public final void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset == 0) {
            //if (mCurrentState != State.EXPANDED) {
            //    onStateChanged(appBarLayout, State.EXPANDED, verticalOffset);
            //}
            mCurrentState = State.EXPANDED;
            //onStateChanged(appBarLayout, State.EXPANDED, verticalOffset);
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
            //if (mCurrentState != State.COLLAPSED) {
            //    onStateChanged(appBarLayout, State.COLLAPSED, verticalOffset);
            //}
            mCurrentState = State.COLLAPSED;
            //onStateChanged(appBarLayout, State.COLLAPSED, verticalOffset);
        } else {
            //if (mCurrentState != State.IDLE) {
            //    onStateChanged(appBarLayout, State.IDLE, verticalOffset);
            //}
            mCurrentState = State.IDLE;

        }
        onStateChanged(appBarLayout, mCurrentState, verticalOffset);
    }

    public abstract void onStateChanged(AppBarLayout appBarLayout, State state, int verticalOffset);
    {
    }
}
