package com.example.vmtung.example;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
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

        LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        final View filterDialogLayoutShadow = layoutInflater.inflate(R.layout.dialog_popover_windowpopup_example, null);
        final View dialogMadrginLayout= layoutInflater.inflate(R.layout.dialog_popupwindow_popover_margin, null);

        final PopupWindow popupWindow = new PopupWindow(filterDialogLayoutShadow, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);
        final PopupWindow popupWindowMargin = new PopupWindow(dialogMadrginLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);

        // Closes the popup window when touch outside.
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

        popupWindowMargin.setOutsideTouchable(true);
        popupWindowMargin.setFocusable(true);

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
                popupWindow.showAsDropDown(startPopoverMaskButton);
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

        startPopoverMaskMaginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindowMargin.showAsDropDown(startPopoverMaskMaginButton);
                View container = (View) popupWindowMargin.getContentView().getParent();
                WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
                p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                p.dimAmount = 0.6f;
                //p.dimAmount = 0.8f;
                wm.updateViewLayout(container, p);
            }
        });
    }
}
