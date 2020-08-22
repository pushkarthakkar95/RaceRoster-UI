package com.techtest.racerostertrophy.view;

import android.graphics.Color;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.techtest.racerostertrophy.R;
import com.techtest.racerostertrophy.databinding.FragmentPersonalRecordsBinding;
import com.techtest.racerostertrophy.model.Achievement;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalRecordsFragment extends Fragment {
    private FragmentPersonalRecordsBinding binding;
    private List<Achievement> personalRecords;
    private AchievmentListAdapter adapter;
    public PersonalRecordsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_personal_records,container,false);
        adapter = new AchievmentListAdapter(getContext(),getPersonalRecords());
        binding.personalRecyclerv.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.personalRecyclerv.setAdapter(adapter);
        binding.fab.setOnClickListener(v -> goToNextFragment(v));
        return binding.getRoot();
    }

    private void goToNextFragment(View v){
        Navigation.findNavController(v).navigate(PersonalRecordsFragmentDirections
                .actionPersonalRecordsFragmentToVirtualRacesFragment());
    }

    private List<Achievement> getPersonalRecords(){
        personalRecords = new ArrayList<>();
        /* populating the list Room DB preferred if given more time and prod scenario */
        personalRecords.add(new Achievement("Longest Run", true,"00:00", R.drawable.ic_fast));
        personalRecords.add(new Achievement("Highest Elevation", true,"2095ft", R.drawable.ic_mission));
        personalRecords.add(new Achievement("Fastest 5K", true,"00:00", R.drawable.ic_5k));
        personalRecords.add(new Achievement("10K", true,"00:00", R.drawable.ic_award));
        personalRecords.add(new Achievement("Half Marathon", true,"00:00", R.drawable.ic_medal));
        personalRecords.add(new Achievement("Marathon", false,"Not Yet", R.drawable.ic_medal));
        return personalRecords;
    }
}
