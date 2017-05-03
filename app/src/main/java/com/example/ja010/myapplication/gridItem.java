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

public class gridItem extends LinearLayout implements View.OnClickListener{
    ImageView iv;
    TextView tv,tpr;

    public gridItem(Context c){
        super(c);
        ini(c);

    }
    public void ini(Context c){
        View v = LayoutInflater.from(c).inflate(R.layout.item,null);
        tv = (TextView)v.findViewById(R.id.t1);
        iv = (ImageView)v.findViewById(R.id.iv);
        tpr = (TextView)v.findViewById(R.id.t2);

    }

    @Override
    public void onClick(View view) {

    }
/*
    public void setData(data d){
        tv.setText(d.name);
        iv.setImageResource(d.imgno);
    }
*/
}
