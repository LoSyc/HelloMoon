package com.bignerdranch.android.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class HelloMoonActivity extends FragmentActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_moon);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.helloMoonFragment);

        if (fragment == null) {
            fragment =  new HelloMoonAudioFragment();
            fm.beginTransaction().add(R.id.helloMoonFragment, fragment).commit();
        }
    }
}
