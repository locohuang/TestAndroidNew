package com.example.administrator.testandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityResult2 extends Activity {
    public static final int RESULT_CODE=0x121;
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        et = (EditText)findViewById(R.id.et);
    }
    public void back(View view){
        Intent intent = new Intent();
        intent.putExtra("key2",et.getText().toString());
        setResult(RESULT_CODE,intent);
        finish();
    }
}
