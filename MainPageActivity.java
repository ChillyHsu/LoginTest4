package com.example.user.logintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;


public class MainPageActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        Button button03 = (Button)findViewById(R.id.Button03);

        button03.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(MainPageActivity.this,MainActivity.class);
                startActivity(intent);
                MainPageActivity.this.finish();
            }
        });
        Button button04 = (Button)findViewById(R.id.Button04);

        button04.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(MainPageActivity.this,Music.class);
                startActivity(intent);
                MainPageActivity.this.finish();
            }
        });
    }
}
