package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LeaderBoardActivity extends AppCompatActivity {
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

}