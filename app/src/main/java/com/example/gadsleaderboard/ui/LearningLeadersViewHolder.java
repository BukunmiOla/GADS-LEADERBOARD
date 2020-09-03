package com.example.gadsleaderboard.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.model.LearningData;

public class LearningLeadersViewHolder extends RecyclerView.ViewHolder {
    TextView nameTv, detailTv;
    public LearningLeadersViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTv = itemView.findViewById(R.id.name_tv);
        detailTv = itemView.findViewById(R.id.detail_tv);
    }

    public void bindData(LearningData learningLeader) {
        nameTv.setText(learningLeader.getName());
        String detail = learningLeader.getHours()+ "," + learningLeader.getCountry()+".";
        detailTv.setText(detail);
    }
}
