package com.example.administrator.testandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
    public void next(View view){
        Intent intent = new Intent(this,ActivityNext.class);//源Activity，目标Activity
        startActivity(intent);//启动新的Activity
        finish();
    }
    public void web(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com")));
    }
    public void call(View view){
        startActivity(new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+"13533886446")));
    }
    public void app(View view){
        Intent intent = new Intent();
        intent.setClassName("com.example.administrator.my2","com.example.administrator.my2.MainMy");
        startActivity(intent);
    }
}
