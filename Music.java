package com.example.user.logintest;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.*;
import android.view.*;
import android.view.View;
import android.widget.*;
import android.media.*;
import android.media.MediaPlayer.*;



public class Music extends AppCompatActivity {

    Button[] bt = new Button[3];
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        bt[0] = (Button)findViewById(R.id.button2);
        bt[1] = (Button)findViewById(R.id.button3);
        bt[2] = (Button)findViewById(R.id.button4);
        Button buttonback = (Button)findViewById(R.id.button5);
        buttonback.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(Music.this,MainPageActivity.class);
                startActivity(intent);
                Music.this.finish();
            }
        });
        bt[0].setText("播放");
        bt[1].setText("暫停");

        bt[0].setEnabled(true);
        bt[1].setEnabled(false);
        bt[2].setEnabled(false);

        for(int i=0; i<bt.length; i++){
            bt[i].setOnClickListener(new SampleClickListener());
        }
        // setContentView(R.layout.activity_main);
    }
    public void onResume()
    {
        super.onResume();
        mp = MediaPlayer.create(this, R.raw.music); //取得MediaPlayer類別的物件
        mp.setOnCompletionListener(new SampleCompletionListener()); //登陸播放完畢監聽器
    }
    public void onPause()
    {
        super.onPause();
        mp.release(); //釋放MediaPlayer類別物件所操作的資源
    }
    private class SampleCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            bt[0].setEnabled(true);
            bt[1].setEnabled(false);
            bt[2].setEnabled(false);
        }
    }
    private class SampleClickListener implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            if(v == bt[0])
            {
                bt[0].setEnabled(false);
                bt[1].setEnabled(true);
                bt[2].setEnabled(false);
                try
                {
                    mp.prepare(); //準備
                } catch (Exception e) {
                    mp.start();  //開始播放
                }
            }else if(v == bt[1])
            {
                if(mp.isPlaying())
                {
                    bt[0].setEnabled(false);
                    bt[1].setEnabled(true);
                    bt[2].setEnabled(true);
                    mp.pause(); //暫停播放
                    bt[1].setText("繼續");
                }else{
                    bt[0].setEnabled(false);
                    bt[1].setEnabled(true);
                    bt[2].setEnabled(true);
                    mp.start();
                    bt[1].setText("暫停");
                }
            }else if(v == bt[2])
            {
                bt[0].setEnabled(true);
                bt[1].setEnabled(false);
                bt[2].setEnabled(false);
                mp.pause(); //暫停播放
                mp.seekTo(0); //回到音訊資料的開頭播放
                bt[0].setText("重新開始");

            }
        }
    }
}

