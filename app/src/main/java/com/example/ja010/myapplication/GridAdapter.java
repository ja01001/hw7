package com.example.ja010.myapplication;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ja010 on 17-05-01.
 */

public class GridAdapter  extends BaseAdapter{
    Context c;
    ArrayList<data> datas ;
    TextView fp;
    boolean b = false;


    public GridAdapter(Context c,ArrayList<data> data){
        this.c = c;
        this.datas = data;
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(c).inflate(R.layout.item, null);
        }
        final TextView fruit_name =(TextView)view.findViewById(R.id.t1);
        fp = (TextView)view.findViewById(R.id.t2);
        final ImageView img = (ImageView)view.findViewById(R.id.iv);

        data fruit = datas.get(i);
        if(b){
            fp.setVisibility(TextView.VISIBLE);
        }
        else {
            fp.setVisibility(TextView.GONE);
        }
        fruit_name.setText(fruit.getName());
       // Toast.makeText(c,""+fruit_name, Toast.LENGTH_SHORT).show();
        fp.setText(""+fruit.getPrice());
      //  Toast.makeText(c,""+fp, Toast.LENGTH_SHORT).show();
        img.setImageResource(fruit.image[fruit.getImage()]);
      //  Toast.makeText(c,""+img, Toast.LENGTH_SHORT).show();
        return view;
    }
    public void setVision(Boolean vision){
        b = vision;
        this.notifyDataSetChanged();
    }
    public void refresh(){this.notifyDataSetChanged();}
    public void addf(data data){this.datas.add(data);}

}
