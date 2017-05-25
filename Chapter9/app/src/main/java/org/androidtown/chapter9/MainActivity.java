package org.androidtown.chapter9;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private boolean audio1_play = false;
    private boolean audio2_play = false;
    MediaPlayer mediaPlayer;
    RelativeLayout audio1;
    RelativeLayout audio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audio1 = (RelativeLayout) findViewById(R.id.audio1);
        audio2  = (RelativeLayout) findViewById(R.id.audio2);

        audio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!audio1_play){
                    if(mediaPlayer != null){
                        mediaPlayer.release();
                        mediaPlayer = new MediaPlayer();
                    }
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music1);
                    mediaPlayer.start();
                    audio1.setBackgroundColor(Color.GRAY);
                    audio2.setBackgroundColor(Color.WHITE);
                    audio1_play = true;
                    audio2_play = false;
                }
                else{
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    audio1.setBackgroundColor(Color.WHITE);
                    audio1_play = false;
                }
            }
        });

        audio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!audio2_play){
                    if(mediaPlayer != null){
                        mediaPlayer.release();
                        mediaPlayer = new MediaPlayer();
                    }
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music2);
                    mediaPlayer.start();
                    audio2.setBackgroundColor(Color.GRAY);
                    audio1.setBackgroundColor(Color.WHITE);
                    audio2_play = true;
                    audio1_play = false;
                }
                else{
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    audio2.setBackgroundColor(Color.WHITE);
                    audio2_play = false;
                }
            }
        });
    }
}
