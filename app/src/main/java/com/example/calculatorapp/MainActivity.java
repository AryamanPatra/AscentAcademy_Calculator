package com.example.calculatorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.example.calculatorapp.methods.InputMethods;

public class MainActivity extends AppCompatActivity {
    String expressionString = "";
    InputMethods inputMethods;
    TextView expressionTv;
    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expressionTv = findViewById(R.id.calculationView);
        inputMethods = new InputMethods(MainActivity.this);
        expressionTv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
//                expressionTv.setText(editable.toString());
            }
        });

    }

    @SuppressLint("NonConstantResourceId")
    @SuppressWarnings("unused")
    public void btnClick(@NonNull View view){
        expressionTv = findViewById(R.id.calculationView);
        resultTv = findViewById(R.id.resultView);
        String resultString="";
        switch (view.getId()){
//            other buttons
            case R.id.equals:
                resultString = inputMethods.inputEquals(expressionString);
                resultTv.setText(resultString);
                break;

            case R.id.open_bra:
                expressionString = inputMethods.inputOpenBracs(expressionString);
                expressionTv.setText(expressionString);
                break;

            case R.id.close_bra:
                expressionString = inputMethods.inputCloseBracs(expressionString);
                expressionTv.setText(expressionString);
                break;

            case R.id.cancel:
                expressionString = inputMethods.inputCancel(expressionString);
                expressionTv.setText(expressionString);
                break;

            case R.id.all_cancel:
                expressionString = inputMethods.inputAllCancel();
                expressionTv.setText(expressionString);
                break;

            case R.id.period:
                expressionString = inputMethods.inputPeriod(expressionString);
                expressionTv.setText(expressionString);
                break;

//              operator buttons
            case R.id.plus:
                expressionString = inputMethods.inputPlus(expressionString);
                expressionTv.setText(expressionString);
                break;

            case R.id.minus:
                expressionString = inputMethods.inputMinus(expressionString);
                expressionTv.setText(expressionString);
                break;

            case R.id.prod:
                expressionString = inputMethods.inputProd(expressionString);
                expressionTv.setText(expressionString);
                break;

            case R.id.div:
                expressionString = inputMethods.inputDiv(expressionString);
                expressionTv.setText(expressionString);
                break;

//                number buttons
            case R.id.n0:
                expressionString = inputMethods.input0(expressionString);
                expressionTv.setText(expressionString);
                break;
            case R.id.n1:
                expressionString = inputMethods.input1(expressionString);
                expressionTv.setText(expressionString);
                break;
            case R.id.n2:
                expressionString = inputMethods.input2(expressionString);
                expressionTv.setText(expressionString);
                break;
            case R.id.n3:
                expressionString = inputMethods.input3(expressionString);
                expressionTv.setText(expressionString);
                break;
            case R.id.n4:
                expressionString = inputMethods.input4(expressionString);
                expressionTv.setText(expressionString);
                break;
            case R.id.n5:
                expressionString = inputMethods.input5(expressionString);
                expressionTv.setText(expressionString);
                break;
            case R.id.n6:
                expressionString = inputMethods.input6(expressionString);
                expressionTv.setText(expressionString);
                break;
            case R.id.n7:
                expressionString = inputMethods.input7(expressionString);
                expressionTv.setText(expressionString);
                break;
            case R.id.n8:
                expressionString = inputMethods.input8(expressionString);
                expressionTv.setText(expressionString);
                break;
            case R.id.n9:
                expressionString = inputMethods.input9(expressionString);
                expressionTv.setText(expressionString);
                break;
        }
    }
}