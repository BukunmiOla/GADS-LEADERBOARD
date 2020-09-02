package com.example.gadsleaderboard.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadsleaderboard.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillIqFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillIqFragment extends Fragment {

    // the fragment initialization parameters.
    public static final String ARG_ID = "skill";

    private String mParam;

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
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_iq, container, false);
    }
    public static final String ARG_OBJECT = "object";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
//        ((TextView) view.findViewById(android.R.id.text1))
//                .setText(Integer.toString(args.getInt(ARG_OBJECT)));
    }
}