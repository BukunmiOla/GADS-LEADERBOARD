package com.example.gadsleaderboard.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.gadsleaderboard.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent next = new Intent(MainActivity.this, LeaderBoardActivity.class);
                startActivity(next);
                finish();
            }
        }, 3500);

    }
}