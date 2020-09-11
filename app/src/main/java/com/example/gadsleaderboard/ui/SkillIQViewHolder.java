package com.example.gadsleaderboard.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.model.SkillIqData;

public class SkillIQViewHolder extends RecyclerView.ViewHolder {
    TextView nameTv, detailTv;
    public SkillIQViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTv =itemView.findViewById(R.id.name_tv);
        detailTv =itemView.findViewById(R.id.detail_tv);

    }

    public void bindSkillData(SkillIqData skilliq){
        nameTv.setText(skilliq.getName());
        String detail = skilliq.getScore()+" skill IQ Score, "+skilliq.getCountry();
        detailTv.setText(detail);

    }
}