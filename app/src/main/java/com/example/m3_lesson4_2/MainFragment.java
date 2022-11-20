package com.example.m3_lesson4_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class MainFragment extends Fragment implements OnItemClick {

    public static final String NAME_KEY = "name";
    public static final String CAPITAL_NAME_KEY = "CAPITAL";
    public static final String FLAG_KEY = "FLAG";
    private RecyclerView recyclerView;
    private ArrayList<Country> countries = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);

        countries.add(new Country("Kyrgyzstan", "Bishkek","https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/Flag_of_Kyrgyzstan.svg/2560px-Flag_of_Kyrgyzstan.svg.png"));
        countries.add(new Country("Germany", "Berlin", "https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/2560px-Flag_of_Germany.svg.png"));
        countries.add(new Country("Japan", "Tokio", "https://upload.wikimedia.org/wikipedia/commons/a/af/Flag_of_Japan_bordered.png"));
        countries.add(new Country("Russia", "Moskow", "https://upload.wikimedia.org/wikipedia/commons/d/d4/Flag_of_Russia.png"));
        countries.add(new Country("China", "Pekin", "https://upload.wikimedia.org/wikipedia/commons/2/2e/Flag_of_China.png"));
        countries.add(new Country("USA", "Washington", "https://upload.wikimedia.org/wikipedia/en/thumb/a/a4/Flag_of_the_United_States.svg/2560px-Flag_of_the_United_States.svg.png"));
        countries.add(new Country("Canada", "Toronto", "https://upload.wikimedia.org/wikipedia/commons/b/b6/Flag_of_Canada.png"));
        countries.add(new Country("Kazakhstan", "Astana", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Flag_of_Kazakhstan.svg/1280px-Flag_of_Kazakhstan.svg.png"));
        countries.add(new Country("Ukraina", "Kiev", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Flag_of_Ukraine.png/640px-Flag_of_Ukraine.png"));

        recyclerView.setAdapter(new CountryAdapter(countries, this));


    }

    @Override
    public void onItemClick(Country country) {
        Bundle bundle = new Bundle();
        bundle.putString(NAME_KEY, country.getName());
        bundle.putString(CAPITAL_NAME_KEY, country.getCapitalName());
        bundle.putString(FLAG_KEY, country.getFlag());
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, secondFragment).addToBackStack(null).commit();
    }
}