package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtFullName,txtWeight,txtHeihgt,txtGoal,txtAge,txtPhone;
    CheckBox checkBox;
    RadioGroup radioGroup;
    Button btn;
    String  team = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFullName = findViewById(R.id.txtname);
        txtWeight = findViewById(R.id.txtweight);
        txtHeihgt = findViewById(R.id.txtheight);
        txtGoal = findViewById(R.id.txtgoal);
        txtAge = findViewById(R.id.txtage);
        txtPhone = findViewById(R.id.txtphone);
        radioGroup = findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton rb= (RadioButton) findViewById(checkedId);
                team = rb.getTag().toString();
                Toast.makeText(MainActivity.this, team, Toast.LENGTH_SHORT).show();
            }
        });
        checkBox = findViewById(R.id.checkbox);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentBMI =  Integer.parseInt(txtWeight.getText().toString()) + (Integer.parseInt(txtHeihgt.getText().toString()) * Integer.parseInt(txtHeihgt.getText().toString()));
                int goalBMI =  Integer.parseInt(txtGoal.getText().toString()) + (Integer.parseInt(txtHeihgt.getText().toString()) * Integer.parseInt(txtHeihgt.getText().toString()));

                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("currentBMI",String.valueOf(currentBMI));
                i.putExtra("goalBMI",String.valueOf(goalBMI));


                String check = "";
                if(checkBox.isChecked()) {
                    check = "Phone: " + txtPhone.getText().toString();
                } else {
                    check = "";

                }
                i.putExtra("checkBox",check);


                    i.putExtra("txtFullName",team + txtFullName.getText().toString());


                startActivity(i);
            }
        });
    }
}