package com.example.administrator.testandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Activity0202 extends Activity implements CompoundButton.OnCheckedChangeListener{
    private CheckBox cbk_test;
    private ToggleButton tb_test;
    private RadioGroup rg_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_0202);
        cbk_test = (CheckBox)findViewById(R.id.cbk_test);
        cbk_test.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //cbk_test.setText("选中");
                    cbk_test.setText(R.string.cbk_checked);
                }else{
                    //cbk_test.setText("未选中");
                    cbk_test.setText(R.string.cbk_unchecked);
                }
            }
        });
        tb_test = (ToggleButton)findViewById(R.id.tb_test);
        tb_test.setOnCheckedChangeListener(this);
        rg_test = (RadioGroup)findViewById(R.id.rg_test);
        rg_test.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton =(RadioButton) group.findViewById(checkedId);
                Toast.makeText(Activity0202.this,radioButton.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            Toast.makeText(Activity0202.this,"On",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(Activity0202.this,"Off",Toast.LENGTH_SHORT).show();
        }
    }
}
