package org.androidtown.lab6;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.String;

public class MainActivity extends AppCompatActivity{
    EditText txtData;
    Button write;
    Button clear;
    Button read;
    Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtData = (EditText) findViewById(R.id.txtData);
        write = (Button) findViewById(R.id.write);
        clear = (Button) findViewById(R.id.clear);
        read = (Button) findViewById(R.id.read);
        finish = (Button) findViewById(R.id.finish);

        write.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String data = txtData.getText().toString();
                try {
                    FileOutputStream out = openFileOutput("mysdfile.txt", Context.MODE_PRIVATE);
                    out.write(data.getBytes());
                    out.close();

                    Toast.makeText(getApplicationContext(), "Done writing SD 'mysdfile.txt'", Toast.LENGTH_SHORT).show();
                } catch(Exception e){};
            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txtData.setText("");
            }
        });

        read.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    FileInputStream in = openFileInput("mysdfile.txt");
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
                    String str = "";
                    StringBuffer data = new StringBuffer();
                    while((str = buffer.readLine()) != null){
                        data.append(str + "\n");
                    }
                    txtData.setText(data);
                    buffer.close();
                } catch(Exception e){};
            }
        });

        finish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}