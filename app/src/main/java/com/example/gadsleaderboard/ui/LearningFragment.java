package com.example.gadsleaderboard.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.adapter.LearningDataAdapter;
import com.example.gadsleaderboard.model.LearningData;
import com.example.gadsleaderboard.network.ClientInstance;
import com.example.gadsleaderboard.network.DataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearningFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearningFragment extends Fragment {

    // the fragment initialization parameters.
    public static final String ARG_ID = "learning";
    private RecyclerView learningRv;

    private String mParam;

    public LearningFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameter.
     *
     * @param param Parameter 1.
     * @return A new instance of fragment LearningFragment.
     */
    public static LearningFragment newInstance(String param) {
        LearningFragment fragment = new LearningFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ID, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learning, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        learningRv= view.findViewById(R.id.learning_rv);
        showleaders();
    }

    private void showleaders() {
        DataService service =
                ClientInstance.getClientInstance("https://gadsapi.herokuapp.com")
                        .create(DataService.class);

        Call<List<LearningData>> call = service.getLearningData();
        call.enqueue(new Callback<List<LearningData>>() {
            @Override
            public void onResponse(Call<List<LearningData>> call, Response<List<LearningData>> response) {
                Toast.makeText(getActivity(), "Connected", Toast.LENGTH_SHORT).show();
                generateData(response.body());
            }

            @Override
            public void onFailure(Call<List<LearningData>> call, Throwable t) {
                Toast.makeText(getActivity(), "Something went wrong...", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void generateData(List<LearningData> body) {
        LearningDataAdapter adapter = new LearningDataAdapter(body);
        learningRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        learningRv.setAdapter(adapter);
    }

}