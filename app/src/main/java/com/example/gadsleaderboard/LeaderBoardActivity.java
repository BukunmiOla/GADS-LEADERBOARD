package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gadsleaderboard.adapter.PagerAdapter;
import com.example.gadsleaderboard.ui.SystemUIManager;

public class LeaderBoardActivity extends AppCompatActivity {
    PagerAdapter mPagerAdapter;
    ViewPager2 viewPager;
    SystemUIManager manager = new SystemUIManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

        findViewById(R.id.submission_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSubmitPage = new Intent(LeaderBoardActivity.this, SubmissionActivity.class);
                startActivity(goToSubmitPage);
            }
        });

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