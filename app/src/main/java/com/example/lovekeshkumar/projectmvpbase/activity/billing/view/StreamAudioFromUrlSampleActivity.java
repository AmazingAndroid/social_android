package com.example.lovekeshkumar.projectmvpbase.activity.billing.view;

/**
 * Created by Lovekesh Kumar on 3/14/2018.
 */

import java.io.IOException;
import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.example.lovekeshkumar.projectmvpbase.R;


public class StreamAudioFromUrlSampleActivity extends Activity implements OnClickListener, OnTouchListener, OnCompletionListener, MediaPlayer.OnBufferingUpdateListener {
    private Button btn_play,
            btn_pause,
            btn_stop;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    private int lengthOfAudio;
    private final String URL = "https://cdn.discordapp.com/attachments/341897684715831300/420133803353440256/Phir_Mohabbat.mp3";


    private final Handler handler = new Handler();
    private final Runnable r = new Runnable()
    {
        @Override
        public void run() {
            updateSeekProgress();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initialize_Controls();
    }

    private void initialize_Controls()
    {
        btn_play = (Button)findViewById(R.id.btn_play);
        btn_play.setOnClickListener(this);
        btn_pause = (Button)findViewById(R.id.btn_pause);
        btn_pause.setOnClickListener(this);
        btn_pause.setEnabled(false);
        btn_stop = (Button)findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(this);
        btn_stop.setEnabled(false);

        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnTouchListener(this);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnBufferingUpdateListener(this);
        mediaPlayer.setOnCompletionListener(this);

    }

    @Override
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int percent)
    {
        seekBar.setSecondaryProgress(percent);
    }

    @Override
    public void onCompletion(MediaPlayer mp)
    {
        btn_play.setEnabled(true);
        btn_pause.setEnabled(false);
        btn_stop.setEnabled(false);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        if (mediaPlayer.isPlaying())
        {
            SeekBar tmpSeekBar = (SeekBar)v;
            mediaPlayer.seekTo((lengthOfAudio / 100) * tmpSeekBar.getProgress() );
        }
        return false;
    }

    @Override
    public void onClick(View view)
    {

        try
        {
            mediaPlayer.setDataSource(URL);
            mediaPlayer.prepare();
            lengthOfAudio = mediaPlayer.getDuration();

        }
        catch (Exception e)
        {
            //Log.e("Error", e.getMessage());
        }

        switch (view.getId())
        {
            case R.id.btn_play:
                playAudio();
                break;
            case R.id.btn_pause:
                pauseAudio();
                break;
            case R.id.btn_stop:
                stopAudio();
                break;
            default:
                break;
        }

        updateSeekProgress();
    }

    private void updateSeekProgress()
    {
        if (mediaPlayer.isPlaying())
        {
            seekBar.setProgress((int)(((float)mediaPlayer.getCurrentPosition() / lengthOfAudio) * 100));
            handler.postDelayed(r, 1000);
        }
    }

    private void stopAudio()
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.stop();
        }
        btn_play.setEnabled(true);
        btn_pause.setEnabled(false);
        btn_stop.setEnabled(false);
        seekBar.setProgress(0);
    }

    private void pauseAudio()
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.pause();
        }
        btn_play.setEnabled(true);
        btn_pause.setEnabled(false);
    }

    private void playAudio()
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.start();
        }
        btn_play.setEnabled(false);
        btn_pause.setEnabled(true);
        btn_stop.setEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopAudio();
    }
}
