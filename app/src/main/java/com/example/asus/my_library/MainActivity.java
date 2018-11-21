package com.example.asus.my_library;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Book> list = new ArrayList<Book>();
    public static ArrayList<String> TitleList = new ArrayList<String>();
    public static ArrayList<String> AutorList = new ArrayList<String>();
    public static ArrayList<String> YearList = new ArrayList<String>();
    public static ArrayList<String> DescriptionList = new ArrayList<String>();
    public static int poss;
    Button btn1;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
        intent.putExtra("activity_type", "Main");
        final Intent InfoIntent = new Intent(this, com.example.asus.my_library.ActivityInfo.class);

        btn1 = (Button) findViewById(R.id.btn1);
        listView = (ListView)findViewById(R.id.listView);
        setMyAdapter();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(InfoIntent);
                poss = position;
                MainActivity.super.finish();
                //setMyAdapter();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    public void setMyAdapter(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, TitleList);

        listView.setAdapter(adapter);
        listView.deferNotifyDataSetChanged();
    }

}
