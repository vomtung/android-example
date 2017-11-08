package com.example.vmtung.example;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class CollapsingToolbarLayout2Activity extends AppCompatActivity {

    private AppBarLayout containerAppBarLayout;
    private TabLayout tabLayoutMyProfile;
    private RelativeLayout themeBackGroundRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar_layout2);

        containerAppBarLayout = (AppBarLayout) findViewById(R.id.containerAppBarLayout);
        tabLayoutMyProfile = (TabLayout) findViewById(R.id.tabLayoutMyProfile);
        themeBackGroundRelativeLayout = (RelativeLayout) findViewById(R.id.themeBackGroundRelativeLayout);

        tabLayoutMyProfile.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        themeBackGroundRelativeLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));

        containerAppBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state, int verticalOffset) {
                if(State.COLLAPSED.equals(state))
                {
                    //myProfileHeaderBarRelativeLayout.getBackground().setAlpha(255);
                    tabLayoutMyProfile.getBackground().setAlpha(255);
                }
                if(State.EXPANDED.equals(state))
                {
                    //myProfileHeaderBarRelativeLayout.getBackground().setAlpha(Math.abs(verticalOffset*255/appBarLayout.getTotalScrollRange())/2);
                    tabLayoutMyProfile.getBackground().setAlpha(verticalOffset*255/appBarLayout.getTotalScrollRange());
                    themeBackGroundRelativeLayout.getBackground().setAlpha((verticalOffset*255/appBarLayout.getTotalScrollRange()));
                }
                else
                {
                    //myProfileHeaderBarRelativeLayout.getBackground().setAlpha(Math.abs(verticalOffset*255/appBarLayout.getTotalScrollRange())/2);
                    tabLayoutMyProfile.getBackground().setAlpha(Math.abs(verticalOffset*255/appBarLayout.getTotalScrollRange()));
                    themeBackGroundRelativeLayout.getBackground().setAlpha(Math.abs(verticalOffset*255/appBarLayout.getTotalScrollRange()));
                }
            }
        });
    }
}
