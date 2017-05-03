package com.example.ja010.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button b1;
    CheckBox cb ;
    AddF af ;
    GridView gv ;
    int Pos = 0;
    GridAdapter ga;
    ArrayList<data> datalist = new ArrayList<data>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView)findViewById(R.id.grid);
        datalist.add(new data("아보카도",0,1000));
        datalist.add(new data("바나나",1,2000));
        datalist.add(new data("체리",2,3000));
        datalist.add(new data("크렌베리",3,4000));
        datalist.add(new data("포도",4,5000));
        datalist.add(new data("키위",5,6000));
        datalist.add(new data("오렌지",6,7000));
        datalist.add(new data("참외",7,8000));
        ga = new GridAdapter(this,datalist);
        gv.setAdapter(ga);
        af = (AddF)findViewById(R.id.add);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final data item = (data) ga.getItem(position);
                String name = item.getName();
                int img = item.getImage();
                af.setWidget(name, img);
                Pos = position;
                af.setOnModifyListener(new AddF.OnModifyListener(){
                    @Override
                    public void onModiy(String name, int imgno, int price) {
                        item.setName(name);
                        item.setImage(imgno);
                        item.setPrice(price);
                        ga.notifyDataSetChanged();

                    }
                });
            }
        });
        af.setOnAddListener(new AddF.OnAddListener() {
            @Override
            public void onAdd(String name, int imgno, int price) {
                ga.addf(new data(name,imgno,price));
            }
        });

        cb = (CheckBox)findViewById(R.id.cb);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cb.isChecked() == true){
                    ga.setVision(true);
                }
                else {
                    ga.setVision(false);
                }
            }
        });
        b1 = (Button)findViewById(R.id.bc);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
