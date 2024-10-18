package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this,MainActivity.class));
            }
        });
        TextView txt = findViewById(R.id.textView);
        Bundle extras = getIntent().getExtras();

            String value = "Name: " + extras.getString("txtFullName");
            value += "\nCurrentBMI:" + extras.getString("currentBMI");
            value += "\nGoalBMI:" + extras.getString("goalBMI");
            value += "\n" + extras.getString("checkBox");
            txt.setText(value);
            Toast.makeText(MainActivity2.this,"Hint:Mr or Ms for male and female.BMI formula:weight(kg)/(height(m)^2)" , Toast.LENGTH_SHORT).show();

    }
    }
