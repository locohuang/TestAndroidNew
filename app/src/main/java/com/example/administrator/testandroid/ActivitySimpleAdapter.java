package com.example.administrator.testandroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivitySimpleAdapter extends Activity {
    private   String[]tv1={"北京市","上海市","广州市","深圳市","重庆市","天津市","武汉市","西安市","沈阳市","长沙市","珠海市","北京市","上海市","广州市","深圳市","重庆市","天津市","武汉市","西安市","沈阳市","长沙市","珠海市"};
    private static final String[]tv2={"北京市2","上海市2","广州市2","深圳市2","重庆市2","天津市2","武汉市2","西安市2","沈阳市2","长沙市2","珠海市2","北京市2","上海市2","广州市2","深圳市2","重庆市2","天津市2","武汉市2","西安市2","沈阳市2","长沙市2","珠海市2"};
    private static final int[] imgIds={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
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
        /*SimpleAdapter simpleAdapter=
                new SimpleAdapter(this,data,R.layout.item,
                        new String[]{"img","tv1","tv2"},
                        new int[]{R.id.my_img,R.id.tv1,R.id.tv2});*/
        MySimpleAdapter simpleAdapter=
                new MySimpleAdapter(this,data,R.layout.item,
                        new String[]{"img","tv1","tv2"},
                        new int[]{R.id.my_img,R.id.tv1,R.id.tv2});
        listView.setAdapter(simpleAdapter);
       /* for(int i=0;i<simpleAdapter.getCount();i++){
            if(i%3==0) {
                View view = listView.getChildAt(i);
                TextView textView = (TextView) simpleAdapter.getView(i, view, listView).findViewById(R.id.tv1);
                textView2.setText(textView.getText());
                textView.setBackgroundColor(Color.GRAY);
            }
        }
        simpleAdapter.notifyDataSetChanged();*/

    }
    class MySimpleAdapter extends SimpleAdapter{
        private Context mContext;
        private List<Map<String,String>> mList;
        private int mResource;
        private String[]mFrom;
        private int[]mTo;
        public MySimpleAdapter(Context context, List<Map<String, String>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
            this.mContext = context;
            this.mList = data;
            this.mResource = resource;
            this.mFrom = from;
            this.mTo = to;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           /* LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource,parent,false);
            ImageView imageView = (ImageView)convertView.findViewById(mTo[0]);
            TextView tv1 = (TextView) convertView.findViewById(mTo[1]);
            TextView tv2 = (TextView) convertView.findViewById(mTo[2]);
            imageView.setImageResource(R.mipmap.ic_launcher);
            tv1.setText(mList.get(position).get(mFrom[1]));
            tv2.setText(mList.get(position).get(mFrom[2]));
            if(position%3==0) {
                tv1.setBackgroundColor(Color.GRAY);
            }
            return convertView;*/
            /*View row = super.getView(position,convertView,parent);
            ImageView imageView = (ImageView)row.findViewById(mTo[0]);
            TextView tv1 = (TextView) row.findViewById(mTo[1]);
            TextView tv2 = (TextView) row.findViewById(mTo[2]);
            imageView.setImageResource(R.mipmap.ic_launcher);
            tv1.setText(mList.get(position).get(mFrom[1]));
            tv2.setText(mList.get(position).get(mFrom[2]));
            if(position%3==0) {
                tv1.setBackgroundColor(Color.GRAY);
            }
            return row;*/
            View row = super.getView(position,convertView,parent);
            ViewHoder viewHoder =(ViewHoder) row.getTag();
            if(null==viewHoder){
                viewHoder = new ViewHoder(row);
                row.setTag(viewHoder);
            }
            viewHoder.img.setImageResource(R.mipmap.ic_launcher);
            viewHoder.tv1.setText(mList.get(position).get(mFrom[1]));
            viewHoder.tv2.setText(mList.get(position).get(mFrom[2]));
            if(position%3==0) {
                viewHoder.tv1.setBackgroundColor(Color.BLUE);
            }else {
                viewHoder.tv1.setBackgroundColor(Color.WHITE);
            }
            return row;
        }
    }
    class ViewHoder{
        ImageView img=null;
        TextView tv1 = null;
        TextView tv2 = null;

        public ViewHoder(View view) {
            img = (ImageView)view.findViewById(R.id.my_img);
            tv1 = (TextView)view.findViewById(R.id.tv1);
            tv2 = (TextView)view.findViewById(R.id.tv2);
        }
    }
}

