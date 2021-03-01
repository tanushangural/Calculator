package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Stack;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        Button button1 = findViewById(R.id.one);
        Button button2 = findViewById(R.id.two);
        Button button3 = findViewById(R.id.three);
        Button button4 = findViewById(R.id.four);
        Button button5 = findViewById(R.id.five);
        Button button6 = findViewById(R.id.six);
        Button button7 = findViewById(R.id.seven);
        Button button8 = findViewById(R.id.eight);
        Button button9 = findViewById(R.id.nine);
        Button button0 = findViewById(R.id.zero);
        Button buttonminus = findViewById(R.id.minus);
        Button buttonplus = findViewById(R.id.plus);
        Button buttonmultiply = findViewById(R.id.product);
        Button buttondivide = findViewById(R.id.divide);
        Button buttonequal = findViewById(R.id.equal);
        Button buttonclear = findViewById(R.id.clear);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonminus.setOnClickListener(this);
        buttonplus.setOnClickListener(this);
        buttonequal.setOnClickListener(this);
        buttonmultiply.setOnClickListener(this);
        buttondivide.setOnClickListener(this);
        buttonclear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.one:
                textView.setText(textView.getText().toString()+"1");
                break;

            case R.id.two:
                textView.setText(textView.getText().toString()+"2");
                break;

            case R.id.three:
                textView.setText(textView.getText().toString()+"3");
                break;

            case R.id.four:
                textView.setText(textView.getText().toString()+"4");
                break;

            case R.id.five:
                textView.setText(textView.getText().toString()+"5");
                break;

            case R.id.six:
                textView.setText(textView.getText().toString()+"6");
                break;

            case R.id.seven:
                textView.setText(textView.getText().toString()+"7");
                break;

            case R.id.eight:
                textView.setText(textView.getText().toString()+"8");
                break;

            case R.id.nine:
                textView.setText(textView.getText().toString()+"9");
                break;

            case R.id.zero:
                textView.setText(textView.getText().toString()+"0");
                break;

            case R.id.plus:
                textView.setText(textView.getText().toString()+"+");
                break;
            case R.id.minus:
                textView.setText(textView.getText().toString()+"-");
                break;
            case R.id.product:
                textView.setText(textView.getText().toString()+"*");
                break;
            case R.id.divide:
                textView.setText(textView.getText().toString()+"/");
                break;
            case R.id.equal:
                String ans = compute(textView.getText().toString());
                textView.setText(ans);
                break;
            case R.id.clear:
                textView.setText("");
                break;
        }
    }

    String compute(String expression){
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        first.append('0');
        second.append('0');
        int i=0;
        int length = expression.length();
        while(i<length && expression.charAt(i)>='0' && expression.charAt(i)<='9'){
            first.append(expression.charAt(i));
            i++;
        }
        if(i == length) return first.toString();
        char sign = expression.charAt(i);
        i+=1;

        while (i<length && expression.charAt(i)>='0' && expression.charAt(i)<='9'){
            second.append(expression.charAt(i));
            i++;
        }

        String ans = opertor(first.toString(),second.toString(),sign);
        return ans;
    }
    String opertor(String one,String two,char ch){

        int a = Integer.valueOf(one);
        int b = Integer.valueOf(two);
       // Toast.makeText(this,one+"   "+two,Toast.LENGTH_LONG).show();
        int ans=0;
        switch (ch){
            case '+':
                ans = a+b;
                break;
            case '-':
                ans = a-b;
                break;
            case '/':
                ans = a/b;
                break;
            case '*':
                ans = a*b;
                break;
            default: break;
        }

        return Integer.toString(ans);
    }

}