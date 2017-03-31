package org.androidtown.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Age;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.editText1);
        Age = (EditText)findViewById(R.id.editText2);
        button1 = (Button)findViewById(R.id.button1); // Get EditText and Button in XML

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ // if click the button
                String loginName = Name.getText().toString(); //get string in Name to loginName
                String loginAge = Age.getText().toString(); //get string in Age to loginAge
                Intent intent = new Intent(getApplicationContext(), NewActivity.class); //create new intent for NewActivity
                intent.putExtra("loginName", loginName);
                intent.putExtra("loginAge", loginAge); // give loginName and loginAge to NewActivity
                startActivity(intent); //call NewActivity
            }
        });
    }
}
