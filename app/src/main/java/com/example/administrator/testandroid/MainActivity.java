package com.example.administrator.testandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TextView tv;
    private EditText et;
    private Button btn;
    private String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.btn);
    }
    protected void get(View view){
        text = et.getText().toString();
        //tv.setText(text);
        Toast.makeText(MainActivity.this,text, Toast.LENGTH_LONG).show();
    }
}
