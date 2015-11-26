package com.ganjastudio.pacekgame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Spin extends Activity {

    enum State
    {
        NoSpin,
        Spin,
        AfterSpin
    }

    RotateAnimation anim;
    ImageView spinButton;
    State state = State.NoSpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin);

        addListenerOnButton();
    }

    private void addListenerOnButton()
    {
        spinButton = (ImageView)findViewById(R.id.spin);
        spinButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                switch (state) {
                    case NoSpin:
                        startAnimation();
                        setupTimer();
                        break;

                    default:
                }
            }

        });
    }

    private void startAnimation()
    {
        anim = new RotateAnimation(0f, 360f, spinButton.getPivotX(), spinButton.getPivotY());
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(600);
        anim.setFillEnabled(true);
        anim.setFillAfter(true);

        spinButton.startAnimation(anim);
        state = State.Spin;
    }

    private void setupTimer()
    {
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {

                anim.setRepeatCount(0);

                state = State.AfterSpin;

                Intent intent = new Intent(Spin.this, GameBoard.class);
                startActivity(intent);

                state = State.NoSpin;
            }
        }.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
