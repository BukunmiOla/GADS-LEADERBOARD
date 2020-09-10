package com.example.gadsleaderboard.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.adapter.SkillDataAdapter;
import com.example.gadsleaderboard.model.SkillIqData;
import com.example.gadsleaderboard.network.ClientInstance;
import com.example.gadsleaderboard.network.DataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillIqFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillIqFragment extends Fragment {

    // the fragment initialization parameters.
    public static final String ARG_ID = "skill";

    private String mParam;
    private RecyclerView skillRv;

    public SkillIqFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameter.
     *
     * @param param Parameter 1.
     * @return A new instance of fragment SkillIqFragment.
     */
    public static SkillIqFragment newInstance(String param) {
        SkillIqFragment fragment = new SkillIqFragment();
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
        return inflater.inflate(R.layout.fragment_skill_iq, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        skillRv= view.findViewById(R.id.skill_iq_rv);
        showSkillIq();
//        ((TextView) view.findViewById(android.R.id.text1))
//                .setText(Integer.toString(args.getInt(ARG_OBJECT)));
    }

    private void showSkillIq() {
        DataService service =
                ClientInstance.getClientInstance("https://gadsapi.herokuapp.com")
                        .create(DataService.class);

        Call<List<SkillIqData>> call = service.getSkillIqData();
        call.enqueue(new Callback<List<SkillIqData>>() {
            @Override
            public void onResponse(Call<List<SkillIqData>> call, Response<List<SkillIqData>> response) {
                Toast.makeText(getActivity(), "Connected", Toast.LENGTH_SHORT).show();
                generateData(response.body());
            }

            @Override
            public void onFailure(Call<List<SkillIqData>> call, Throwable t) {
                Toast.makeText(getActivity(), "Something went wrong...", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void generateData(List<SkillIqData> body) {
        SkillDataAdapter adapter = new SkillDataAdapter(body);
        skillRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        skillRv.setAdapter(adapter);
    }
}