package com.anupamchugh.smoothcountdownprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Toast;

import com.anupamchugh.smoothcountdown.SmoothCircularProgressView;
import com.anupamchugh.smoothcountdown.SmoothProgressAnimationListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int ONE_SECOND_IN_MS = 1000;
    SmoothCircularProgressView smoothCircularProgressView;

    Button btn10, btn20, btn10AcDc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smoothCircularProgressView = (SmoothCircularProgressView) findViewById(R.id.smoothCircularProgress);

        btn10= (Button)findViewById(R.id.btn10);
        btn20= (Button)findViewById(R.id.btn20);
        btn10AcDc= (Button)findViewById(R.id.btn10AcDc);

        btn10.setOnClickListener(this);
        btn20.setOnClickListener(this);
        btn10AcDc.setOnClickListener(this);

        smoothCircularProgressView.addAnimationListener(new SmoothProgressAnimationListener() {
            @Override
            public void onValueChanged(float value) {

            }

            @Override
            public void onAnimationEnd() {

                Toast.makeText(getApplicationContext(),"Time Up",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn10:
                smoothCircularProgressView.setProgress(0);
                smoothCircularProgressView.setStartAngle(270);
                smoothCircularProgressView.setProgressWithAnimation(100, 10 * ONE_SECOND_IN_MS);
                break;

            case R.id.btn20:
                smoothCircularProgressView.setProgress(0);
                smoothCircularProgressView.setStartAngle(270);
                smoothCircularProgressView.setProgressWithAnimation(100, 20 * ONE_SECOND_IN_MS);

                break;

            case R.id.btn10AcDc:
                smoothCircularProgressView.setProgress(0);
                smoothCircularProgressView.setInterpolator(new AccelerateDecelerateInterpolator());
                smoothCircularProgressView.setStartAngle(270);
                smoothCircularProgressView.setProgressWithAnimation(100, 10 * ONE_SECOND_IN_MS);


                break;

        }
    }
}
