package com.example.ja010.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gv ;
    GridAdapter ga;
    ArrayList<data> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView)findViewById(R.id.grid);
        ga = new GridAdapter(this,data);
        data.add(new data("a",1));
        data.add(new data("b",2));
        gv.setAdapter(ga);
        ga.notifyDataSetChanged();
    }
}
