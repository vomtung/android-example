package com.example.vmtung.example;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

public class PopoverExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popover_example);

        final Button startPopoverButton = (Button)findViewById(R.id.startPopover);
        final Button startPopoverMaskButton = (Button)findViewById(R.id.startPopoverMask);
        final Button startPopoverMaskMaginButton = (Button)findViewById(R.id.startPopoverMaskMagin);
        final View maskOutside = (View)findViewById(R.id.maskOutside);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        final View filterDialogLayoutShadow = layoutInflater.inflate(R.layout.dialog_popover_windowpopup_example, null);
        final View filterDialogDarkMaskLayout = layoutInflater.inflate(R.layout.dialog_popover_windowpopup_dark_mask_view, null);
        final View dialogMadrginLayout= layoutInflater.inflate(R.layout.dialog_popupwindow_popover_margin, null);
        final View dialogBottomLayout= layoutInflater.inflate(R.layout.dialog_popover_windowpopup_bottom, null);
        final Button startPopoverShadowButton = (Button)findViewById(R.id.startPopoverShadowButton);
        final Button bottomPopoverButton = (Button)findViewById(R.id.bottomPopoverButton);
        final View bottomAncherView = (View)findViewById(R.id.bottomAncherView);

        final PopupWindow popupWindow = new PopupWindow(filterDialogLayoutShadow,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true);
        final PopupWindow popupWindowDarkMask = new PopupWindow(
                filterDialogDarkMaskLayout,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true);
        final PopupWindow popupWindowMargin = new PopupWindow(
                dialogMadrginLayout,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true);

        final PopupWindow bottomPopupWindow = new PopupWindow(
                dialogBottomLayout,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true);

        final View pupLayout = layoutInflater.inflate(R.layout.dialog_popover_windowpopup_bottom, null);
        pupLayout.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));


        // Closes the popup window when touch outside.
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

        popupWindowMargin.setOutsideTouchable(true);
        popupWindowMargin.setFocusable(true);
        popupWindowMargin.setWidth(width-200);

        final View filterDialogLayout = layoutInflater.inflate(R.layout.dialog_filter_received_overtime, null);
        final PopupWindow pwindow = new PopupWindow(filterDialogLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,true);
        // Closes the popup window when touch outside.
        pwindow.setOutsideTouchable(true);
        pwindow.setFocusable(true);

        pwindow.setOutsideTouchable(true);
        pwindow.setTouchable(true);
        pwindow.setBackgroundDrawable(new BitmapDrawable());

        startPopoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.showAsDropDown(startPopoverButton);
                View container = (View) popupWindow.getContentView().getParent();
                WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
                p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                p.dimAmount = 0.6f;
                //p.dimAmount = 0.8f;
                wm.updateViewLayout(container, p);
            }
        });

        startPopoverMaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindowDarkMask.showAsDropDown(startPopoverMaskButton, 100, 50);
                maskOutside.setVisibility(View.VISIBLE);
                maskOutside.bringToFront();
            }
        });

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                maskOutside.setVisibility(View.GONE);
            }
        });

        popupWindowDarkMask.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                maskOutside.setVisibility(View.GONE);
            }
        });

        startPopoverMaskMaginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindowMargin.showAsDropDown(startPopoverMaskMaginButton, 50, 50);
                View container = (View) popupWindowMargin.getContentView().getParent();
                WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
                p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                p.dimAmount = 0.6f;
                //p.dimAmount = 0.8f;
                wm.updateViewLayout(container, p);
            }
        });

        startPopoverShadowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pwindow.showAsDropDown(startPopoverShadowButton);
            }
        });

        bottomPopoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomPopupWindow.showAsDropDown(bottomAncherView,0, 0);

            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
