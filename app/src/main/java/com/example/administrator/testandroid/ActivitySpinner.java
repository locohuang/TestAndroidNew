package com.example.administrator.testandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivitySpinner extends Activity {
    private static final String[]items={"北京市","上海市","广州市","深圳市","重庆市","天津市","武汉市","西安市","沈阳市","长沙市","珠海市"};
    private static final String[]items2={"beijingshi","shanghaishi","guangzhishi","beijing2","beij3","tianjinshi","beijin2","xian","shyang","cs","zh"};
    private TextView tv;
    private Spinner spinner;
    private AutoCompleteTextView auto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        tv = (TextView)findViewById(R.id.tv);
        spinner = (Spinner)findViewById(R.id.spinner);
        auto = (AutoCompleteTextView)findViewById(R.id.auto);
        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,items2);
        auto.setAdapter(adapter);
    }
}
