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
                int result = solution(edtCheck.getText().toString().trim());
                if (result == 0) {
                    txtResult.setText("Return 0 => not nested");
                } else {
                    txtResult.setText("Return 1 => is nested");
                }
            }
        });
    }

    public int solution(String input) {
        if (input.length() == 0) return 1;

        if (input.length() % 2 == 1) return 0;

        if (input.charAt(0) != '(' && input.charAt(input.length() - 1) != ')') return 0;

        Stack<Character> chars = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (chars.size() == 0) {
                chars.push(input.charAt(i));
            } else {
                if (isMatch(chars.peek(), input.charAt(i))) {
                    chars.pop();
                } else {
                    chars.push(input.charAt(i));
                }
            }
        }
        return chars.size() == 0 ? 1 : 0;
    }

    private boolean isMatch(char a, char b) {
        switch (a) {
            case '{':
                return b == '}';
            case '(':
                return b == ')';
            case '[':
                return b == ']';
            case '<':
                return b == '>';
            default:
                return false;
        }
    }

}
