package com.example.asus.my_library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        final Intent mainIntent = new Intent(this, MainActivity.class);
        final Intent intentTwo = new Intent(ActivityInfo.this, ActivityTwo.class);
        intentTwo.putExtra("activity_type", "Info");
        TextView setTitle = (TextView)findViewById(R.id.setTitle);
        TextView setAuthor = (TextView)findViewById(R.id.setAuthor);
        TextView setYear = (TextView)findViewById(R.id.setYear);
        TextView setDescription = (TextView)findViewById(R.id.setDescription);
        Button btnDelete = (Button)findViewById(R.id.btnDelete);
        Button btnUpdate = (Button)findViewById(R.id.btnUpdate);
        Button btnToMain = (Button)findViewById((R.id.btnToMain));

        setTitle.setText(MainActivity.TitleList.get(MainActivity.poss));
        setAuthor.setText(MainActivity.AutorList.get(MainActivity.poss));
        setYear.setText(MainActivity.YearList.get(MainActivity.poss));
        setDescription.setText(MainActivity.DescriptionList.get(MainActivity.poss));

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.TitleList.remove(MainActivity.poss);
                MainActivity.AutorList.remove(MainActivity.poss);
                MainActivity.YearList.remove(MainActivity.poss);
                MainActivity.DescriptionList.remove(MainActivity.poss);
                MainActivity.list.remove(MainActivity.poss);

                ActivityInfo.super.finish();

                startActivity(mainIntent);

            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentTwo);
                ActivityInfo.super.finish();
            }
        });
        btnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityInfo.super.finish();
                startActivity(mainIntent);
            }
        });
    }

}
