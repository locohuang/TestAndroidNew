package com.example.administrator.testandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import com.example.administrator.testandroid.model.User;

import java.util.Random;

public class ActivityProgressBar extends Activity {
    private ProgressBar progressBar;
    //private int curProgress=0;
    private Random random;
    private int randomValue;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        random = new Random();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==0x110){
                    User user = (User) msg.obj;
                    System.out.println("aaa:"+user.getUserName());
                    progressBar.setProgress(msg.arg1);
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                int curProgress=0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    randomValue = random.nextInt(10);
                    curProgress = curProgress+randomValue;
                    //handler.sendEmptyMessage(0x110);
                    Message msg = new Message();
                    msg.what = 0x110;
                    msg.arg1 = curProgress;
                    User user = new User("001","Li");
                    msg.obj = user;
                    handler.sendMessage(msg);
                    //progressBar.setProgress(curProgress);
                }
            }
        }).start();
    }
}
