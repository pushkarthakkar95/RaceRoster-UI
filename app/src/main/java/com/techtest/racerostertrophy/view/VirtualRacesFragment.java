package com.techtest.racerostertrophy.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
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
public class VirtualRacesFragment extends Fragment {
    private List<Achievement> virtualRaces;
    private FragmentPersonalRecordsBinding binding;
    private AchievmentListAdapter adapter;
    public VirtualRacesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_personal_records,container,false);
        setLayout();
        adapter = new AchievmentListAdapter(getContext(),getVirtualRaces());
        binding.personalRecyclerv.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.personalRecyclerv.setAdapter(adapter);
        return binding.getRoot();
    }

    @SuppressLint("RestrictedApi")
    private void setLayout(){
        binding.fab.setVisibility(View.GONE);
        binding.pageTitle.setText(R.string.virtualRacesPageTitle);
    }

    private List<Achievement> getVirtualRaces(){
        virtualRaces = new ArrayList<>();
        virtualRaces.add(new Achievement("Virtual Half Marathon Race", true,"00:00", R.drawable.ic_award));
        virtualRaces.add(new Achievement("Tokyo-Hakone Ekiden 2020", true,"00:00:00", R.drawable.ic_medal));
        virtualRaces.add(new Achievement("Virtual 10K Race", true,"00:00:00", R.drawable.ic_fast));
        virtualRaces.add(new Achievement("Hakone Ekiden", true,"00:00:00", R.drawable.ic_medal));
        virtualRaces.add(new Achievement("Mizuno Singapore Ekiden 2015", true,"00:00:00", R.drawable.ic_medal));
        virtualRaces.add(new Achievement("Virtual 5K Race", true,"23:07", R.drawable.ic_5k));
        return virtualRaces;
    }
}
