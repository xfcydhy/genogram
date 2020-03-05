package com.graduation.genogram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.graduation.genogram.db.FirstNameDatabase;

public class addDatabase extends AppCompatActivity {

    private Button addButton;
    private Button backButton;
    private FirstNameDatabase firstNameDatabase;
    private EditText database;
    private EditText postscript;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_database);

        addButton=findViewById(R.id.add_database);
        database=findViewById(R.id.database_edit);
        postscript=findViewById(R.id.postscript_edit);
        backButton=findViewById(R.id.back_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNameDatabase=new FirstNameDatabase();
                firstNameDatabase.setFirstName(database.getText().toString());
                firstNameDatabase.setPostscript(postscript.getText().toString());
                //firstNameDatabase.save();
                /************
                 *
                 */
                Intent intent=new Intent(addDatabase.this,MainLayout.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(addDatabase.this,MainActivity.class);
                startActivity(intent);
                addDatabase.this.finish();
                Log.d("finish","===================");
            }
        });
    }
}
