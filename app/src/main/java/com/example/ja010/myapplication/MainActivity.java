package com.example.ja010.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int imagelist[] = {R.drawable.abocado, R.drawable.banana, R.drawable.cherry, R.drawable.cranberry, R.drawable.grape, R.drawable.kiwi, R.drawable.orange, R.drawable.watermelon};
    AddF af ;
    GridView gv ;
    int Pos = 0;
    GridAdapter ga;
    ArrayList<data> data = new ArrayList<data>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView)findViewById(R.id.grid);
        data.add(new data("아보카도",0,1000));
        data.add(new data("바나나",1,2000));
        data.add(new data("체리",2,3000));
        data.add(new data("크렌베리",3,4000));
        data.add(new data("포도",4,5000));
        data.add(new data("키위",5,6000));
        data.add(new data("오렌지",6,7000));
        data.add(new data("참외",7,8000));
        ga = new GridAdapter(this,data);
        gv.setAdapter(ga);
        af = (AddF)findViewById(R.id.add);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                data item = (data) ga.getItem(position);
                String name = item.getName();
                int img = item.getImage();
                af.setWidget(name, img);
                Pos = position;
            }
        });
        af.setOnAddListener(new AddF.OnAddListener() {
            @Override
            public void onAdd(String name, int imgno, int price) {
                ga.addf(new data(name,imgno,price));
            }
        });
        af.setOnModifyListener(new AddF.OnModifyListener() {
            @Override
            public void onModiy(String name, int imgno, int price) {
                ga.modify(new data(name,imgno,price),Pos);
            }
        });
    }
}
