package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.example.gadsleaderboard.ui.SystemUIManager;

public class MainActivity extends AppCompatActivity {
    SystemUIManager manager = new SystemUIManager();
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
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            manager.hideSystemUI(getWindow().getDecorView());
        }
        else manager.showSystemUI(getWindow().getDecorView());
    }

}