package com.example.administrator.testandroid;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.testandroid.fragments.FaxianFragment;
import com.example.administrator.testandroid.fragments.TongXunFragment;
import com.example.administrator.testandroid.fragments.WeixinFragment;
import com.example.administrator.testandroid.fragments.WodekFragment;


public class NaviBottomActivity extends Activity implements RadioGroup.OnCheckedChangeListener{
    private WeixinFragment weixinFragment = null;
    private TongXunFragment tongXunFragment = null;
    private FaxianFragment faxianFragment = null;
    private WodekFragment wodekFragment = null;
    private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi_bottom);
        rg = (RadioGroup)findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this);
        ((RadioButton)findViewById(R.id.rb_wx)).setTextColor(Color.GREEN);
        weixinFragment = new WeixinFragment();
        getFragmentManager().beginTransaction().replace(R.id.fl,weixinFragment).commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if(checkedId == R.id.rb_wx){
            if(weixinFragment == null){
                weixinFragment = new WeixinFragment();
            }
            ((RadioButton)findViewById(R.id.rb_wx)).setTextColor(Color.GREEN);
            transaction.replace(R.id.fl,weixinFragment);
        }else if(checkedId == R.id.rb_tx){
            if(tongXunFragment == null){
                tongXunFragment = new TongXunFragment();
            }
            ((RadioButton)findViewById(R.id.rb_tx)).setTextColor(Color.GREEN);
            transaction.replace(R.id.fl,tongXunFragment);
        }else if(checkedId == R.id.rb_fx){
            if(faxianFragment == null){
                faxianFragment = new FaxianFragment();
            }
            ((RadioButton)findViewById(R.id.rb_fx)).setTextColor(Color.GREEN);
            transaction.replace(R.id.fl,faxianFragment);
        }else if(checkedId == R.id.rb_wd){
            if(wodekFragment == null){
                wodekFragment = new WodekFragment();
            }
            ((RadioButton)findViewById(R.id.rb_wd)).setTextColor(Color.GREEN);
            transaction.replace(R.id.fl,wodekFragment);
        }
        transaction.commit();
    }
}
