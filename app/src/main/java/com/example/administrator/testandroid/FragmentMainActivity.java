package com.example.administrator.testandroid;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class FragmentMainActivity extends Activity{
    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private int showState = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
        //FragmentManager:管理Fragment
        //FragmentTransaction:开启事务;添加/替换Fragment;提交
        FragmentManager fragmentManager = getFragmentManager();//创建FragmentManager对象
        FragmentTransaction transaction = fragmentManager.beginTransaction();//创建FragmentTransaction对象
        transaction.add(R.id.frame_main,fragmentOne);//把Fragment添加到容器
        transaction.commit();//提交
        //getFragmentManager().beginTransaction().add(R.id.frame_main,fragmentOne).commit();
    }
    public  void change(View view){
        FragmentManager fragmentManager = getFragmentManager();//创建FragmentManager对象
        FragmentTransaction transaction = fragmentManager.beginTransaction();//创建FragmentTransaction对象
        if(showState == 0){
            System.out.println("0");
            transaction.replace(R.id.frame_main,fragmentTwo);//把容器里面的Fragment替换
            showState = 1;
        }else if(showState == 1){
            System.out.println("1");
            transaction.replace(R.id.frame_main,fragmentOne);//把容器里面的Fragment替换
            showState = 0;
        }
        transaction.commit();//提交
    }
}
