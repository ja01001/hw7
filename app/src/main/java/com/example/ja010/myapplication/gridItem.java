package com.example.ja010.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ja010 on 17-05-01.
 */

public class gridItem extends LinearLayout {
    ImageView iv;
    TextView tv;
    public gridItem(Context c){
        super(c);
        ini(c);

    }
    public void ini(Context c){
        View v = LayoutInflater.from(c).inflate(R.layout.item,null);
        tv = (TextView)findViewById(R.id.tt);
        iv = (ImageView)findViewById(R.id.iv);

    }
    public void setData(data d){
        tv.setText(d.fun);
        iv.setImageResource(d.n);
    }
}
