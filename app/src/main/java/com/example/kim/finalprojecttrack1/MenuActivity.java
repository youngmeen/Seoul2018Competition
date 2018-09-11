package com.example.kim.finalprojecttrack1;

import android.app.AlertDialog;
import android.support.v4.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.kim.finalprojecttrack1.Fragment.EmergencyFragment;
import com.example.kim.finalprojecttrack1.Fragment.HomeFragment;
import com.example.kim.finalprojecttrack1.Fragment.SettingFragment;
import com.example.kim.finalprojecttrack1.Fragment.ShelterFragment;
import com.example.kim.finalprojecttrack1.Fragment.MessageFragment;
import com.example.kim.finalprojecttrack1.chat.MessageActivity;
import com.google.firebase.auth.FirebaseAuth;


public class MenuActivity extends AppCompatActivity {

    Toolbar toolbar;
    AlertDialog.Builder alert_ex;
    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        int number = intent.getIntExtra("number", 0);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        if (number == R.id.navigation_emrgency) {
            EmergencyFragment fragment = EmergencyFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            mBottomNavigationView.setSelectedItemId(number);
            transaction.commit();
        } else if (number == R.id.navigation_shelter) {
            ShelterFragment fragment1 = ShelterFragment.newInstance();
            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
            transaction1.replace(R.id.container, fragment1);
            mBottomNavigationView.setSelectedItemId(number);
            transaction1.commit();
        } else if (number == R.id.navigation_message) {
            MessageFragment fragment2 = MessageFragment.newInstance();
            FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
            transaction2.replace(R.id.container, fragment2);
            mBottomNavigationView.setSelectedItemId(number);
            transaction2.commit();
        } else if (number == R.id.navigation_setting) {
            SettingFragment fragment3 = SettingFragment.newInstance();
            FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
            transaction3.replace(R.id.container, fragment3);
            mBottomNavigationView.setSelectedItemId(number);
            transaction3.commit();
        }


//
//
//        if (savedInstanceState == null) {
//            loadEmergencyFragment();
//        }

        setupBottomNavigation();


    }


    private void setupBottomNavigation() {
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    startActivity(new Intent(MenuActivity.this, MainActivity.class));
                    finish();
                case R.id.navigation_emrgency:
                    loadEmergencyFragment();
                    return true;
                case R.id.navigation_setting:
                    loadSettingFragment();
                    return true;
                case R.id.navigation_shelter:
                    loadShelterFragment();
                    return true;
                case R.id.navigation_message:
                    loadMessageFragment();
                    return true;
            }
            return false;
        });

    }


    private void loadSettingFragment() {
        SettingFragment fragment = SettingFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    private void loadShelterFragment() {
        ShelterFragment fragment = ShelterFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    private void loadEmergencyFragment() {
        EmergencyFragment fragment = EmergencyFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    private void loadMessageFragment() {
        MessageFragment fragment = MessageFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        alert_ex = new AlertDialog.Builder(this);
        alert_ex.setMessage("정말로 종료하시겠습니다.");

        alert_ex.setPositiveButton("취소", (dialogInterface, i) -> {

        });
        alert_ex.setNegativeButton("종료", (dialogInterface, i) -> {
            FirebaseAuth.getInstance().signOut();
            finishAffinity();
        });
        AlertDialog alert = alert_ex.create();
        alert.show();
    }
}
