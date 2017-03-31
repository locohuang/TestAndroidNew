package com.example.administrator.testandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityC extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
    }
    public void go(View view){
        Intent intent = new Intent(this,ActivityD.class);
        startActivity(intent);
    }
}
