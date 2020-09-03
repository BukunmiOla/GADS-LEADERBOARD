package com.example.gadsleaderboard.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.model.SkillIqData;
import com.example.gadsleaderboard.ui.SkillIQViewHolder;

import java.util.List;

public class SkillDataAdapter extends RecyclerView.Adapter<SkillIQViewHolder> {
    List<SkillIqData> mSkillIqDataList;
    public SkillDataAdapter(List<SkillIqData> body) {
        mSkillIqDataList = body;
    }

    @NonNull
    @Override
    public SkillIQViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_iq_leaders, parent,false);
        return new SkillIQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIQViewHolder holder, int position) {
        final  SkillIqData skillIq = mSkillIqDataList.get(position);
        holder.bindSkillData(skillIq);
    }

    @Override
    public int getItemCount() {
        return mSkillIqDataList!=null? mSkillIqDataList.size():0;
    }
}
