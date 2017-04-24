package org.androidtown.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import java.lang.String;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    RadioButton radioButton;
    RadioButton radioButton2;
    CheckBox checkBox;
    CheckBox checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //match Id and widget
        button = (Button)findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);

        button.setOnClickListener(new View.OnClickListener(){ //Define setOnClickListener for send intent
            @Override
            public void onClick(View view){
                String personName = editText.getText().toString(); // Get text from editText
                String personGender = "";
                String personMessage = "";
                if(radioButton.isChecked()){ // if '남' is checked
                    personGender = radioButton.getText().toString(); //  get text '남'
                }
                else if(radioButton2.isChecked()){ // if '여' is checked
                    personGender = radioButton2.getText().toString(); // get text '여'
                }

                if(checkBox.isChecked()){ // if 'SMS' is checked
                    String tmp = checkBox.getText().toString(); // get text from checkBox
                    personMessage = personMessage + tmp + " "; // add string 'SMS'
                }
                if(checkBox2.isChecked()){ // if 'E-Mail' is checked
                    String tmp = checkBox2.getText().toString(); // get text from checkBoc2
                    personMessage = personMessage + tmp + " "; // add string 'E-Mail'
                }
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class); // define intent
                Bundle bundle = new Bundle(); // define bundle
                bundle.putString("name", personName); // add name to bundle
                bundle.putString("gender", personGender); // add gender to bundle
                bundle.putString("message", personMessage); // add message to bundle
                intent.putExtras(bundle); // put bundle in intent
                startActivity(intent); // give intent and call activity_register
            }
        });
    }
}
