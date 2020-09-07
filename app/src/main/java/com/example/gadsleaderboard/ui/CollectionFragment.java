package com.example.gadsleaderboard.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.adapter.PagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;


public class CollectionFragment extends Fragment {

    PagerAdapter mPagerAdapter;
    ViewPager2 viewPager;
    String title;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collection, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mPagerAdapter = new PagerAdapter(this);
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(mPagerAdapter);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) ->
                        setTabTitle(tab, position)
        ).attach();
    }

    @NotNull
    private TabLayout.Tab setTabTitle(TabLayout.Tab tab, int position) {
        if(position==0){
            return tab.setText("Learning Leaders");
        }
        else return tab.setText("Skill IQ Leaders");

    }

}