package com.example.btvn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_code = (EditText) findViewById(R.id.code);
        EditText et_name = (EditText) findViewById(R.id.name);
        EditText et_price = (EditText) findViewById(R.id.price);
        Button bt_save = (Button) findViewById(R.id.bt_save);
        Button bt_view = (Button) findViewById(R.id.bt_view);
        Button bt_close = (Button) findViewById(R.id.bt_close);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = et_name.getText().toString();

                String cont = "";
                cont +=  "Name : " + et_name.getText().toString();
                cont += "      ";
                cont += "Price: " + et_price.getText().toString();
                try {
                    FileOutputStream fout = openFileOutput(filename, Context.MODE_PRIVATE);
                    fout.write(cont.getBytes());
                    fout.close();
                    Toast.makeText(getBaseContext(), "Save successfully!", Toast.LENGTH_SHORT).show();
                }catch (IOException ex){
                    Toast.makeText(getBaseContext(), "Open Error!", Toast.LENGTH_SHORT).show();
                };
            }
        });

        bt_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent2);
            }
        });

        bt_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}