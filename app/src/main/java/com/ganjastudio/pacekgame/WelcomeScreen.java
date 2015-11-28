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
    }

    public void startWiki(View view) {
        Intent intent = new Intent(this, WikiActivity.class);
        startActivity(intent);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, Spin.class);
        startActivity(intent);
    }

    public void startSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
