package com.bignerdranch.android.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Administrator on 2015/1/31.
 */
public class HelloMoonVedioFragment extends Fragment {
    private final String TAG = "HelloMoonVedio";
    private Button mPlayButton;
    private Button mStopButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon_vedio, container, false);
        Log.i(TAG, "VedioFragment start!");
        mPlayButton = (Button) v.findViewById(R.id.hellomoon_vedioPlayButton);
        mStopButton = (Button) v.findViewById(R.id.hellomoon_vedioStopButton);


        return v;
    }
}
