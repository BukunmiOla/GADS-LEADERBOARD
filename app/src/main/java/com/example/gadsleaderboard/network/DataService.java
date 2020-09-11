package com.example.gadsleaderboard.network;

import com.example.gadsleaderboard.model.LearningData;
import com.example.gadsleaderboard.model.PostRequest;
import com.example.gadsleaderboard.model.SkillIqData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {

    @GET ("/api/skilliq")
    Call<List<SkillIqData>> getSkillIqData();

    @GET ("/api/hours")
    Call<List<LearningData>> getLearningData();

    @POST("/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<List<PostRequest>> postDetails(@Field("entry.2006916086") String last,
                                        @Field("entry.1824927963") String mail,
                                        @Field("entry.1877115667") String name,
                                        @Field("entry.284483984") String link);

}
