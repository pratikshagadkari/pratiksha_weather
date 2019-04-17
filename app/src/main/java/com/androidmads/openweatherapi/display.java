package com.androidmads.openweatherapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class display extends AppCompatActivity {
    TextView disp;
    detailsadapter adapter;
    ArrayList<wather> list;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent i=getIntent();
        //disp=findViewById(R.id.disp);
        recyclerView=findViewById(R.id.recycler);
        String stringBuilder=i.getStringExtra("stringBuilder");

        list=new ArrayList<>();

        //disp.setText(stringBuilder);
        String arr[]=new String[6];
        int count=0;
        int p=0;
        for(int j=0;j<stringBuilder.length();j++) {
            char s = stringBuilder.charAt(j);
            if (s == '_') {
                String substring = stringBuilder.substring(p, j);
                arr[count] = substring;
                p = j + 1;
                count++;
            }
        }
        list.add(new wather(arr[0],arr[1],arr[2],arr[3],arr[4]));
            for(int j=0;j<count;j++)
                Log.d("abcde",arr[j]);

        LinearLayoutManager layoutManager=new LinearLayoutManager(display.this);
        RecyclerView.LayoutManager layoutManager1=layoutManager;
        recyclerView.setLayoutManager(layoutManager1);
        adapter=new detailsadapter(display.this,list);
        recyclerView.setAdapter(adapter);
    }
}
