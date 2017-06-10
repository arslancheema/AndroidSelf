package com.example.aarshad.android_self.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aarshad.android_self.R;
import com.example.aarshad.android_self.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            headIndex = extras.getInt("headIndex");
            bodyIndex = extras.getInt("bodyIndex");
            legIndex = extras.getInt("legIndex");
        }

        if (savedInstanceState==null){

            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setImageIds(AndroidImageAssets.getAll());
            headFragment.setIndex(headIndex);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.head_fragment,headFragment)
                    .commit();

            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageIds(AndroidImageAssets.getAll());
            bodyFragment.setIndex(bodyIndex);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.body_fragment,bodyFragment)
                    .commit();

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageIds(AndroidImageAssets.getAll());
            legFragment.setIndex(legIndex);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.leg_fragment,legFragment)
                    .commit();

        }
    }
}
