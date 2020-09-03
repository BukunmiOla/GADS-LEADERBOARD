package com.example.gadsleaderboard.network;

import com.example.gadsleaderboard.model.SkillIqData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET ("/api/skilliq")
    Call<List<SkillIqData>> getSkillIqData();

}
