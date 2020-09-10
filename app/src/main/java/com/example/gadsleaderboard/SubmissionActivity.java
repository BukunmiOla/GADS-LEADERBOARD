package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.gadsleaderboard.model.PostRequest;
import com.example.gadsleaderboard.network.ClientInstance;
import com.example.gadsleaderboard.network.DataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionActivity extends AppCompatActivity {
    EditText nameEt, linkEt, lastEt, mailEt;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);


        findViewById(R.id.submit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // custom dialog
                 dialog= new Dialog(SubmissionActivity.this);
                dialog.setContentView(R.layout.submission_dialog);

                // set the custom dialog components - text, image and button
                ImageView image = dialog.findViewById(R.id.cancel_img_btn);
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.findViewById(R.id.yes_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        postSubmission(dialog);

                    }
                });
                dialog.show();
            }
        });
    }
    private void postSubmission(Dialog dialog) {

        DataService service =
                ClientInstance.getClientInstance("https://docs.google.com")
                        .create(DataService.class);

        PostRequest postRequest = createEntry();

        Call<List<PostRequest>> call = service.postDetails(postRequest.getLastName(),
                postRequest.getMail(),postRequest.getName(),postRequest.getProjectLink());

        call.enqueue(new Callback<List<PostRequest>>() {
            @Override
            public void onResponse(Call<List<PostRequest>> call, Response<List<PostRequest>> response) {
                dialog.setContentView(R.layout.submission_successful_dialog);

            }

            @Override
            public void onFailure(Call<List<PostRequest>> call, Throwable t) {
                dialog.setContentView(R.layout.submission_successful_dialog);
            }
        });
        clearInputs();
    }
    private PostRequest createEntry(){
        nameEt = findViewById(R.id.first_name_et);
        lastEt = findViewById(R.id.last_name_et);
        mailEt = findViewById(R.id.mail_et);
        linkEt = findViewById(R.id.github_link_et);

        PostRequest PostRequest = new PostRequest();
        PostRequest.setName(nameEt.getText().toString());
        PostRequest.setLastName(lastEt.getText().toString());
        PostRequest.setMail(mailEt.getText().toString());
        PostRequest.setProjectLink(linkEt.getText().toString());
        return  PostRequest;
    }
    private void clearInputs() {
        nameEt.setText("");
        lastEt.setText("");
        mailEt.setText("");
        linkEt.setText("");
    }

}