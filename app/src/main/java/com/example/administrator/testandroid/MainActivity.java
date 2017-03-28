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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.example.administrator.testandroid.model.User2;
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
    public void go(View view){
        Intent intent = new Intent(this,ActivityB.class);
        intent.putExtra("myInt",20);
        intent.putExtra("myStr","工贸");
        int[] intArray = new int[]{1,2,3,4,5};
        intent.putExtra("myArray",intArray);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("abc");
        arrayList.add("bcd");
        arrayList.add("cde");
        intent.putStringArrayListExtra("myList",arrayList);

        //intent.putExtra("myMap",map);
        User user = new User(1001,"zhang");
        Bundle bundle = new Bundle();
        bundle.putSerializable("myUser",user);

        MyMap myMap = new MyMap();
        Map<String,String> map = new HashMap<>();
        map.put("mkey1","guangzhou");
        map.put("mkey2","beijing");
        myMap.setMap(map);
        intent.putExtra("myMap",myMap);
        //bundle.putSerializable("myMap",myMap);
        intent.putExtras(bundle);
        startActivity(intent);
        //finish();
    }
    public void go2(View view){
        Intent intent = new Intent(this,ActivityB.class);
        User2 user = new User2(1001,"zhang");
        intent.putExtra("myUser",user);
        Bundle bundle = new Bundle();
        bundle.putParcelable("my1",user);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
