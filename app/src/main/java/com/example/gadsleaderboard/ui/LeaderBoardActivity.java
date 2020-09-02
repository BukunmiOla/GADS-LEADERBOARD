package com.example.gadsleaderboard.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.adapter.PagerAdapter;

public class LeaderBoardActivity extends AppCompatActivity {
    PagerAdapter mPagerAdapter;
    ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

    }
}