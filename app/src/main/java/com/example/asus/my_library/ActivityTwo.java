package com.example.asus.my_library;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityTwo extends AppCompatActivity {

    private EditText editText, editText2, editText3, editText4;
    Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        final String type = getIntent().getStringExtra("activity_type");
        final Intent mainIntent = new Intent(this, MainActivity.class);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        btn2 = (Button)findViewById(R.id.btn2);
        if(type.equals("Info")){
            setUpdateData();
        }
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("Main")) {
                    MainActivity.list.add(newBook());
                    ActivityTwo.super.finish();
                }
                else if(type.equals("Info")){
                    saveUpdateData();
                    ActivityTwo.super.finish();
                    startActivity(mainIntent);

                }
            }
        });
    }
    Book newBook(){

       Book book1 = new Book();
       book1.setTitle(editText.getText().toString());
       MainActivity.TitleList.add(editText.getText().toString());
       book1.setAuthor(editText2.getText().toString());
       MainActivity.AutorList.add(editText2.getText().toString());
       book1.setYear(editText3.getText().toString());
       MainActivity.YearList.add(editText3.getText().toString());
       book1.setDescription(editText4.getText().toString());
       MainActivity.DescriptionList.add(editText4.getText().toString());
        return book1;
    }

    public void setUpdateData(){
        editText.setText(MainActivity.TitleList.get(MainActivity.poss));
        editText2.setText(MainActivity.AutorList.get(MainActivity.poss));
        editText3.setText(MainActivity.YearList.get(MainActivity.poss));
        editText4.setText(MainActivity.DescriptionList.get(MainActivity.poss));
    }

    public void saveUpdateData(){
        MainActivity.TitleList.set(MainActivity.poss,editText.getText().toString());
        MainActivity.AutorList.set(MainActivity.poss,editText2.getText().toString());
        MainActivity.YearList.set(MainActivity.poss,editText3.getText().toString());
        MainActivity.DescriptionList.set(MainActivity.poss,editText4.getText().toString());
    }

}
