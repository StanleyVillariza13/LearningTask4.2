package com.example.mathematicalproblem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;

    double prelim, endterm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editTextNumber1);
        et2 = (EditText) findViewById(R.id.editTextNumber2);
        Button calculate = findViewById(R.id.button8);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double grade = SolveGrade();
                int classify = classify(grade);
                switch (classify) {
                    case 1:
                        Intent pass = new Intent(MainActivity.this, passActivity.class);
                        startActivity(pass);
                        break;

                    case 2:
                        Intent fail = new Intent(MainActivity.this, failActivity.class);
                        startActivity(fail);
                        break;
                }

            }
        });
    }

    public double SolveGrade(){
        if (et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty()) {
            prelim = 0;
            endterm = 0;
        } else {
            prelim = Double.parseDouble(et1.getText().toString());
            endterm = Double.parseDouble(et1.getText().toString());
        }
        double solver;
        return solver=(((prelim+endterm)/200)*100);



    }
    public int classify(double grade){
        if (grade>=75){
            return 1;
        }
        else{return 2;}
    }
}
