package jae.han.com.hanjaepe2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private EditText fullnameInput;
  private EditText ageInput;
  private EditText genderInput;

  private TextView fullnameOutput;
  private TextView ageOutput;
  private TextView genderOutput;

  private Button search;
  private Button save;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullnameInput = (EditText) findViewById(R.id.fullnameInput);
        ageInput = (EditText) findViewById(R.id.ageInput);
        genderOutput = (EditText) findViewById(R.id.genderInput);

        fullnameOutput = (TextView) findViewById(R.id.fullnameOutput);
        ageOutput = (TextView) findViewById(R.id.ageOutput);
        genderOutput = (TextView) findViewById(R.id.genderOutput);

        search = (Button) findViewById(R.id.search);
        save = (Button) findViewById(R.id.save);

    }



     public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("fullname", fullnameInput.getText().toString());
        editor.putString("age", ageInput.getText().toString());
        editor.putString("gender", genderInput.getText().toString());
        editor.apply();

    }

    public void displayData(View view){
       SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        String name = sharedPref.getString("fullname","");
        String age = sharedPref.getString("age","");
        String gender = sharedPref.getString("gender","");

        fullnameOutput.setText(name);
        ageOutput.setText(age);
        genderOutput.setText(gender);

    }
}
