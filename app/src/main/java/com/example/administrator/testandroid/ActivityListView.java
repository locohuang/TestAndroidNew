package com.example.administrator.testandroid;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextDirectionHeuristic;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityListView extends Activity {
    private static final String[]items={"北京市","上海市","广州市","深圳市","重庆市","天津市","武汉市","西安市","沈阳市","长沙市","珠海市"};
    private TextView textView2;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        textView2 = (TextView)findViewById(R.id.textView2);
        listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(arrayAdapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //textView2.setText(""+position+" "+items[position]);
                //textView2.setText(""+position+" "+((TextView)view).getText());
                //textView2.setText(((TextView)liestViw.getChildAt(position)).getText());
                textView2.setText(""+position+" "+((TextView)parent.getChildAt(position)).getText());
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ActivityListView.this,items[position],Toast.LENGTH_LONG).show();
                return false;
            }
        });
        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    Toast.makeText(ActivityListView.this,"down",Toast.LENGTH_SHORT).show();
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    Toast.makeText(ActivityListView.this,"up",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        /*listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setText(((TextView)view).getText());
            }
        });*/
        /*listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView2.setText(""+position+" "+((TextView)parent.getChildAt(position)).getText());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/

    }
}
