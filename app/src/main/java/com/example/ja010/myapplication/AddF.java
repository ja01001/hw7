package com.example.ja010.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by ja010 on 17-05-02.
 */

public class AddF extends LinearLayout implements View.OnClickListener{
    int imagno = 0;
    int priceno =0;
    int position =0;
    int ep;

    AutoCompleteTextView ae1;
    ImageView im;
    Button bn, ba;
    EditText e1;


    // im bnext badd fn
    public AddF(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    public void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.addf,this);
        ae1 = (AutoCompleteTextView) findViewById(R.id.fn);
        im =(ImageView)findViewById(R.id.im);
        bn = (Button)findViewById(R.id.bnext);
        ba = (Button)findViewById(R.id.badd);
        e1 = (EditText)findViewById(R.id.e1);
        bn.setOnClickListener(this);
        ba.setOnClickListener(this);
    }
    public AddF(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AddF(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    void setWidget(String name, int no) {
        imagno = no;
        priceno = no;
        ae1.setText(name);
        im.setImageResource(data.image[imagno]);
        ba.setText("M");
    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.badd){
            if(ba.getText().toString().equals("ADD")){
                onAddListener.onAdd(ae1.getText().toString(),imagno,Integer.parseInt(e1.getText().toString()));
            }
            else{
                onModifyListener.onModiy(ae1.getText().toString(),imagno,Integer.parseInt(e1.getText().toString()));
            }
        }
        else if (view.getId() == R.id.bnext)
        {
            if(imagno == data.image.length - 1)
            {
                imagno = 0;
                im.setImageResource(data.image[imagno]);
            }
            else
            {
                imagno++;
                im.setImageResource(data.image[imagno]);
            }
        }
    }
    interface OnAddListener{
        void onAdd(String name, int imgno,int price);
    }
    public OnAddListener onAddListener;
    public void setOnAddListener(OnAddListener onAddListener ){
        this.onAddListener =onAddListener;
    }
    interface OnModifyListener
    {
        void onModiy(String name, int imgno, int price);
    }
    public OnModifyListener onModifyListener;

    public void setOnModifyListener(OnModifyListener onModifyListener)
    {
        this.onModifyListener = onModifyListener;
    }
}
