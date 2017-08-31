package com.truongtestinnovatube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    private EditText edtCheck;
    private Button btnCheck;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtCheck = (EditText) findViewById(R.id.edtCheck);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        txtResult = (TextView) findViewById(R.id.txtResult);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NestedValidator.solution(edtCheck.getText().toString().trim()) == 1) {
                    txtResult.setText("Return 1 => is nested");
                } else {
                    txtResult.setText("Return 0 => not nested");
                }
            }
        });
    }

}
