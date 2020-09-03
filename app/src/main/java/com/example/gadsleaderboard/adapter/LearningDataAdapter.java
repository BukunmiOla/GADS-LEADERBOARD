package com.example.gadsleaderboard.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.model.LearningData;
import com.example.gadsleaderboard.ui.LearningLeadersViewHolder;

import java.util.List;

public class LearningDataAdapter extends RecyclerView.Adapter<LearningLeadersViewHolder> {
    List<LearningData> mLearningLeadersList;
    public LearningDataAdapter(List<LearningData> body) {
        mLearningLeadersList = body;
    }

    @NonNull
    @Override
    public LearningLeadersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learning_leaders,parent,false);
        return new LearningLeadersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningLeadersViewHolder holder, int position) {
        final LearningData learningLeader = mLearningLeadersList.get(position);
        holder.bindData(learningLeader);
    }

    @Override
    public int getItemCount() {
        return mLearningLeadersList != null ? mLearningLeadersList.size():0;
    }
}
