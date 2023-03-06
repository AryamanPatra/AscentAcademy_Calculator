package com.example.calculatorapp.methods;

import android.content.Context;

import androidx.annotation.NonNull;

public class InputMethods extends Methods {
    private Context context;


    public InputMethods(Context context) {
        setContext(context);
    }

    @Override
    void setContext(Context context) {
        this.context = context;
    }

//    Digit Inputs
    public String input0(String s) {
        return s+N0;
    }

    public String input1(String s) {
        return s+N1;
    }

    public String input2(String s) {
        return s+N2;
    }

    public String input3(String s) {
        return s+N3;
    }

    public String input4(String s) {
        return s+N4;
    }

    public String input5(String s) {
        return s+N5;
    }

    public String input6(String s) {
        return s+N6;
    }

    public String input7(String s) {
        return s+N7;
    }

    public String input8(String s) {
        return s+N8;
    }

    public String input9(String s) {
        return s+N9;
    }

//    Other inputs

    public String inputPeriod(String s){
        return s+PERIOD;
    }
    public String inputPlus(String s){
        return s+PLUS;
    }
    public String inputMinus(String s){
        return s+MINUS;
    }
    public String inputProd(String s){
        return s+PROD;
    }
    public String inputDiv(String s){
        return s+DIV;
    }
    public String inputCloseBracs(String s){
        return s+CLOSE_BRAC;
    }
    public String inputOpenBracs(String s){
        return s+OPEN_BRAC;
    }

// Cancel & equals
    public String inputCancel(@NonNull String s){
        if (s.length()!=0){
            s = s.substring(0,s.lastIndexOf(s));
        }
        return s;
    }
    public String inputAllCancel(){
        return "";
    }
}
