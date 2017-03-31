package org.androidtown.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent passedIntent = getIntent(); // get intent
        if(passedIntent != null) //if passedIntent is not empty
        {
            String loginName = passedIntent.getStringExtra("loginName");
            String loginAge = passedIntent.getStringExtra("loginAge"); //get string in MainActivity to NewActivity
            Toast.makeText(getApplicationContext(), "Student info : " + loginName + ", " + loginAge, Toast.LENGTH_SHORT).show();
            //show the toast message of student information
        }
        Button button0 = (Button) findViewById(R.id.button0); //match the button in XML

        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish(); //if touch the button, finish this activity
            }
        });
    }
}
