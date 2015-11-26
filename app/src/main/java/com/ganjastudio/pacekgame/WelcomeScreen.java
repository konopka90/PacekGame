package com.ganjastudio.pacekgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;


public class WelcomeScreen extends Activity {

    ImageButton startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        addListenerOnButtonStartGame();
    }

    public void addListenerOnButtonStartGame() {

        startGameButton = (ImageButton) findViewById(R.id.startGame);
        startGameButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(WelcomeScreen.this, Spin.class);
                startActivity(intent);
            }

        });

    }
}
