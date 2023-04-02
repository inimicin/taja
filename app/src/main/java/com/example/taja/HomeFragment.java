package com.example.taja;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taja.databinding.FragmentHomeBinding;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TabLayout tabLayout;
    FragmentHomeBinding fragmentHomeBinding;

    FragmentChangeListener fragmentChangeListener;

    PanduanFragment panduanFragment;
    EventFragment eventFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        fragmentChangeListener = (FragmentChangeListener) getActivity();

        tabLayout = fragmentHomeBinding.tabLayout;
        tabLayout.addTab(tabLayout.newTab().setText("Panduan Bertani"));
        tabLayout.addTab(tabLayout.newTab().setText("Event Pertanian"));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(fragmentHomeBinding.containertab.getId(), new PanduanFragment());
        transaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                TabItem tabPanduan = fragmentHomeBinding.tabPanduan;
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                switch(tab.getPosition()){
                    case  0 :
                        transaction.replace(fragmentHomeBinding.containertab.getId(), new PanduanFragment()).commit();
                        break;
                    case 1 :
                        transaction.replace(fragmentHomeBinding.containertab.getId(), new EventFragment()).commit();
                        break;
                }
                System.out.println(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return fragmentHomeBinding.getRoot();
    }
}