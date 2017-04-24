package org.androidtown.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    Intent intent;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // match Id and widget
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        button = (Button) findViewById(R.id.button2);

        intent = getIntent(); // get intent from MainActivity.java

        String tmp = "";
        // get string from intent and add string show text with textView
        tmp = intent.getStringExtra("name");
        textView4.setText(textView4.getText().toString() + " " + tmp);
        tmp = intent.getStringExtra("gender");
        textView5.setText(textView5.getText().toString() + " " + tmp);
        tmp = intent.getStringExtra("message");
        textView6.setText(textView6.getText().toString() + " " + tmp);

        button.setOnClickListener(new View.OnClickListener(){ // setting setOnClickListener for finishing activity
            @Override
            public void onClick(View view){
                finish(); // finish this activity and return to activity_main
            }
        });
    }
}
