package com.example.taja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.taja.databinding.ActivityContainerBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContainerActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, FragmentChangeListener {

    ActivityContainerBinding activityContainerBinding;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activityContainerBinding = ActivityContainerBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(activityContainerBinding.getRoot());
        // Setup Bottom Navigation
        bottomNavigationView = activityContainerBinding.mainNavigationView;
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.homePage);
    }

    // Implement changeFragment() method to enable the fragment changing feature from the current fragment
    @Override
    public void changeFragment(int container, Fragment fragment) {
        getSupportFragmentManager().
                beginTransaction().
                replace(container, fragment).
                commit();
    }

    // Create Fragment
    HomeFragment homeFragment = new HomeFragment();
    AboutFragment aboutFragment = new AboutFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homePage:
                changeFragment(activityContainerBinding.container.getId(), homeFragment);
                return true;
            case R.id.aboutPage:
                changeFragment(activityContainerBinding.container.getId(), aboutFragment);
                return true;
            case R.id.profilePage:
                changeFragment(activityContainerBinding.container.getId(), profileFragment);
                return true;
            default:
                return false;
        }
    }


}