package com.example.gadsleaderboard.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.gadsleaderboard.ui.LearningFragment;
import com.example.gadsleaderboard.ui.SkillIqFragment;

public class PagerAdapter extends FragmentStateAdapter {

    Fragment mFragment;
    public PagerAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a NEW fragment instance in createFragment(int)
        Bundle args = new Bundle();
        if (position%2==0){
            mFragment = new LearningFragment();
            args.putInt(LearningFragment.ARG_ID, position + 1);
        }
        else {
            mFragment = new SkillIqFragment();
            args.putInt(SkillIqFragment.ARG_ID, position + 2);
        }
        mFragment.setArguments(args);
        return mFragment;
    }

    @Override
    public int getItemCount() {
        return 100;
    }
}