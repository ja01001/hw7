package com.example.ja010.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by ja010 on 17-05-01.
 */

public class GridAdapter  extends BaseAdapter{
    Context c;
    ArrayList<data> data ;


    public GridAdapter(Context c,ArrayList<data> data){
        this.c = c;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view ==null)
            view = new GridView(c);
        ((gridItem)view).setData(data.get(i));
        return view;
    }
}
