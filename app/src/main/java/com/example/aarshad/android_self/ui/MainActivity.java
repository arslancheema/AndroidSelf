package com.example.aarshad.android_self.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.aarshad.android_self.R;
import com.example.aarshad.android_self.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextButton = (Button) findViewById(R.id.buttonNext);

    }

    @Override
    public void onImageClick(int position) {

        int bodyPartNumber = position/12 ;
        int index = position - 12*bodyPartNumber;

        switch (bodyPartNumber) {
            case 0:
                headIndex = index;
                break;
            case 1:
                bodyIndex = index;
                break;
            case 2:
                legIndex = index;
                break;
        }

        Bundle b = new Bundle();
        b.putInt("headIndex", headIndex);
        b.putInt("bodyIndex", bodyIndex);
        b.putInt("legIndex", legIndex);

        final Intent i = new Intent(this,AndroidMeActivity.class);
        i.putExtras(b);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });



    }
}
