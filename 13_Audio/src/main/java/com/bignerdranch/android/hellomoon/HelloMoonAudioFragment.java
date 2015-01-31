package com.bignerdranch.android.hellomoon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HelloMoonAudioFragment extends Fragment {
    private final String TAG = "HelloMoonAudio";
    private FragmentManager fm;

    private AudioPlayer mPlayer = new AudioPlayer();

    private final int NEXTPLAY = 1;
    private final int NEXTPAUSE = 0;
    private final int NEXTRESUMES = -1;

    private int flag = 1;
    private Button mPlayButton;
    private Button mStopButton;
    private Button mVedioButton;

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
        fm = getActivity().getSupportFragmentManager();

        mPlayButton = (Button)v.findViewById(R.id.hellomoon_audioPlayButton);
        mStopButton = (Button)v.findViewById(R.id.hellomoon_aduioStopButton);
        mVedioButton = (Button) v.findViewById(R.id.hellomoon_VedioButton);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (flag == NEXTPLAY) {
                    Log.i(TAG, "isPlaying");
                    mPlayer.play(getActivity());
                    flag = NEXTPAUSE;
                    mPlayButton.setText("Pause");
                } else if (flag == NEXTPAUSE) {
                    Log.i(TAG, "isPausing");
                    mPlayer.PauseAndResumes(getActivity());
                    flag = NEXTRESUMES;
                    mPlayButton.setText("Resume");
                } else if (flag == NEXTRESUMES) {
                    Log.i(TAG, "isReumesing");
                    mPlayer.PauseAndResumes(getActivity());
                    flag = NEXTPAUSE;
                    mPlayButton.setText("Pause");
                }
                //updateButtons();
            }
        });
        
        mStopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {                
                mPlayer.stop();
                mPlayButton.setText("Play");
                flag = NEXTPLAY;
                //updateButtons();
            }
        });

        mVedioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "isPausing");
                if (flag != NEXTPLAY && flag != NEXTRESUMES) {
                    mPlayer.PauseAndResumes(getActivity());
                    flag = NEXTRESUMES;
                    mPlayButton.setText("Resume");
                }
                Fragment fragment = new HelloMoonVedioFragment();
                fm.beginTransaction().replace(R.id.helloMoonFragment, fragment).addToBackStack(null).commit();
            }
        });

        return v;
    }
}
