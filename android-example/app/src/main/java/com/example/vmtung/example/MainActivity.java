package com.example.vmtung.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button screenPropertyButton = (Button)findViewById(R.id.screenPropertyButton);
        Button popoverButton = (Button)findViewById(R.id.popoverButton);
        Button menuButton = (Button)findViewById(R.id.menuButton);
        Button eventOrderButton = (Button)findViewById(R.id.eventOrderButton);
        Button spinnerExampleButton = (Button)findViewById(R.id.spinnerExampleButton);
        Button alertDialogExampleButton = (Button)findViewById(R.id.alertDialogExampleButton);
        Button bottomBarButton = (Button)findViewById(R.id.bottomBarButton);
        Button compundViewButton = (Button)findViewById(R.id.compundViewButton);
        Button customViewButton = (Button)findViewById(R.id.customViewButton);
        Button canvasButton = (Button)findViewById(R.id.canvasButton);
        Button canvasButton2 = (Button)findViewById(R.id.canvasButton2);
        Button canvasButton3 = (Button)findViewById(R.id.canvasButton3);
        Button canvasButton4 = (Button)findViewById(R.id.canvasButton4);
        Button canvasButton5 = (Button)findViewById(R.id.canvasButton5);
        Button listViewButton = (Button)findViewById(R.id.listViewButton);
        Button listView2Button = (Button)findViewById(R.id.listView2Button);
        Button collapsingToolbarLayout3Button = (Button)findViewById(R.id.collapsingToolbarLayout3Button);
        Button scrollingActivity2Button = (Button)findViewById(R.id.ScrollingActivity2Button);
        Button dynamicAddViewButton = (Button)findViewById(R.id.dynamicAddViewButton);
        Button takePhotoWithContentProvider = (Button)findViewById(R.id.takePhotoWithContentProvider);
        Button volumeButtonExample = (Button)findViewById(R.id.volumeButtonExample);
        Button collapsingToolbarLayoutButton = (Button)findViewById(R.id.collapsingToolbarLayoutButton);
        Button collapsingToolbarLayout2Button = (Button)findViewById(R.id.collapsingToolbarLayout2Button);
        Button autocompleteButton = (Button)findViewById(R.id.autocompleteButton);
        Button drawableResourceButton = (Button)findViewById(R.id.drawableResourceButton);
        Button propertyAnimationButton = (Button)findViewById(R.id.propertyAnimationButton);
        Button dragAndDropButton = (Button)findViewById(R.id.dragAndDropButton);

        screenPropertyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ScreenPropertyActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        popoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PopoverExampleActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MenuActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        bottomBarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BottomNavigationActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        eventOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, EventOrderExampleActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        spinnerExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SpinnerActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        alertDialogExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AlerDialogExampleActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        compundViewButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CompoundViewActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        customViewButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CustomViewActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        canvasButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CanvasAndPaintActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        canvasButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CanvasAndPaint2Activity.class);
                MainActivity.this.startActivity(i);
            }
        });

        canvasButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CanvasAndPaint3Activity.class);
                MainActivity.this.startActivity(i);
            }
        });

        canvasButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Intent i = new Intent(MainActivity.this, CanvasAndPaint4Activity.class);
                MainActivity.this.startActivity(i);
            }
        });

        canvasButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Intent i = new Intent(MainActivity.this, CanvasAndPaint5Activity.class);
                MainActivity.this.startActivity(i);
            }
        });

        listViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListViewActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        listView2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListView2Activity.class);
                MainActivity.this.startActivity(i);
            }
        });

        collapsingToolbarLayout3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CollapsingToolbarLayout3ButtonActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        scrollingActivity2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ScrollingActivity2.class);
                MainActivity.this.startActivity(i);
            }
        });

        dynamicAddViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DynamicAddViewActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        takePhotoWithContentProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TakePhotoWithContentProviderActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        volumeButtonExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, VolumnButtonExampleActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        collapsingToolbarLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CollapsingToolbarLayoutActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        collapsingToolbarLayout2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CollapsingToolbarLayout2Activity.class);
                MainActivity.this.startActivity(i);
            }
        });

        autocompleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AutoCompleteActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        drawableResourceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DrawableResourceExampleActivity.class);
                startActivity(i);
            }
        });

        propertyAnimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PropertyAnimationActivity.class);
                startActivity(i);
            }
        });

        dragAndDropButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DragAndDropActivity.class);
                startActivity(i);
            }
        });
    }
}
