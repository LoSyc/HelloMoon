package com.bignerdranch.android.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HelloMoonFragment extends Fragment {
    private final String TAG = "HelloMoon";

    private AudioPlayer mPlayer = new AudioPlayer();

    private final int PLAY = 1;
    private final int PAUSE = 0;
    private final int RESUMES = -1;

    private int flag = 1;
    private Button mPlayButton;
    private Button mStopButton;

    /*
    void updateButtons() {
        boolean isEnabled = !mPlayer.isPlaying();
        mPlayButton.setEnabled(isEnabled);
    }
    */
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon_audio, parent, false);

        mPlayButton = (Button)v.findViewById(R.id.hellomoon_audioplayButton);
        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
                
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (flag == PLAY) {
                    Log.i(TAG, "isPlaying");
                    mPlayer.play(getActivity());
                    flag = PAUSE;
                    mPlayButton.setText("Pause");
                } else if (flag == PAUSE) {
                    Log.i(TAG, "isPausing");
                    mPlayer.PauseAndResumes(getActivity());
                    flag = RESUMES;
                    mPlayButton.setText("Resume");
                } else if (flag == RESUMES) {
                    Log.i(TAG, "isReumesing");
                    mPlayer.PauseAndResumes(getActivity());
                    flag = PAUSE;
                    mPlayButton.setText("Pause");
                }
                //updateButtons();
            }
        });
        
        mStopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {                
                mPlayer.stop();
                mPlayButton.setText("Play");
                flag = PLAY;
                //updateButtons();
            }
        });

        return v;
    }
}
