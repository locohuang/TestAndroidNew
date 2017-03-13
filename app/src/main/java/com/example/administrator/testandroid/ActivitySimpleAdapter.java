package com.example.administrator.testandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivitySimpleAdapter extends Activity {
    private static final String[]tv1={"北京市","上海市","广州市","深圳市","重庆市","天津市","武汉市","西安市","沈阳市","长沙市","珠海市"};
    private static final String[]tv2={"北京市2","上海市2","广州市2","深圳市2","重庆市2","天津市2","武汉市2","西安市2","沈阳市2","长沙市2","珠海市2"};
    private static final int[] imgIds={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    private TextView textView2;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        textView2 = (TextView)findViewById(R.id.textView2);
        listView = (ListView)findViewById(R.id.listView);
        List<Map<String,String>> data = new ArrayList<>();
        for(int i=0;i<tv1.length;i++) {
            Map<String, String> map = new HashMap<>();
            map.put("img", String.valueOf(imgIds[i]));
            map.put("tv1", tv1[i]);
            map.put("tv2", tv2[i]);
            data.add(map);
        }
        //String[]from = {"img","tv1","tv2"};
        //int[]to = {R.id.my_img,R.id.tv1,R.id.tv2};
        SimpleAdapter simpleAdapter=
                new SimpleAdapter(this,data,R.layout.item,
                        new String[]{"img","tv1","tv2"},
                        new int[]{R.id.my_img,R.id.tv1,R.id.tv2});
        listView.setAdapter(simpleAdapter);
    }
}

