package com.example.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.example.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment implements OnItemClick {

    AdapterContinent adapter;
    FragmentFirstBinding binding;
    ArrayList<ContinentModel> arrayList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fillOurList();
        setAdapter();
    }

    private void setAdapter() {
        adapter = new AdapterContinent(arrayList,this);
        binding.recyclerView.setAdapter(adapter);
    }


    private void fillOurList() {
        arrayList.add(new ContinentModel(R.drawable.ic_launcher_background, "Asian"));
        arrayList.add(new ContinentModel(R.drawable.ic_launcher_background, "Asian"));
        arrayList.add(new ContinentModel(R.drawable.ic_launcher_background, "Asian"));
        arrayList.add(new ContinentModel(R.drawable.ic_launcher_background, "Asian"));
        arrayList.add(new ContinentModel(R.drawable.ic_launcher_background, "Asian"));
        arrayList.add(new ContinentModel(R.drawable.ic_launcher_background, "Asian"));

    }

    @Override
    public void onClick(ContinentModel continentModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("list",continentModel);
        Fragment fragment = new SecondFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }
}