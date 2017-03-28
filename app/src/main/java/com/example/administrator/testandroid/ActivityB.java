package com.example.administrator.testandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.testandroid.model.User2;

import java.util.ArrayList;

public class ActivityB extends Activity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        tv = (TextView)findViewById(R.id.tv);
        Intent intent = getIntent();
        int myInt = intent.getIntExtra("myInt",0);
        String myStr = intent.getStringExtra("myStr");
        StringBuilder stringBuilder  = new StringBuilder();
        stringBuilder.append(myInt);
        stringBuilder.append("   ");
        stringBuilder.append(myStr);
        tv.setText(stringBuilder.toString());
        System.out.println("result:"+myInt+"  "+myStr);
        int[]intArray = intent.getIntArrayExtra("myArray");
        for(int x:intArray){
            System.out.println(x);
        }
        ArrayList<String> arrayList = intent.getStringArrayListExtra("myList");
        for(String x:arrayList){
            System.out.println(x);
        }
        User user =(User) intent.getExtras().getSerializable("myUser");
        if(null!=user)
            System.out.println("user:"+user.getId()+"   "+user.getName());

        MyMap myMap = (MyMap)intent.getSerializableExtra("myMap");
        if(null!=myMap)
            System.out.println("map:"+myMap.getMap().get("mkey1")+"   "+myMap.getMap().get("mkey2"));

        User2 user2 = getIntent().getParcelableExtra("myUser");
        if(null!=user2){
            System.out.println(user2.getId()+ "   "+user2.getName() );
        }
        User2 user1 = getIntent().getExtras().getParcelable("my1");
    }
}
