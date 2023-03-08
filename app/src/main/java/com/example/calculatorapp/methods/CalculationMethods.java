package com.example.calculatorapp.methods;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class CalculationMethods extends Methods{
    private Context context;

    @Override
    void setContext(Context context) {
        this.context = context;
    }
    public CalculationMethods(Context context){
        setContext(context);
    }


    public double initiateNreturn(String expression){
        Stack<String> stack = conversion(expression);
        return calculation(stack);
    }

    //converting expression from infix to postfix
    private Stack<String> conversion(String expression){
        try{
            HashMap<Character,Integer> heirarchy = new HashMap<Character,Integer>();
            Stack<String> operandStack = new Stack<String>();
            Stack<String> operatorStack = new Stack<String>();
            heirarchy.put('~',-1);
            heirarchy.put(OPEN_BRAC,0);
            heirarchy.put(PLUS,1);
            heirarchy.put(MINUS,1);
            heirarchy.put(PROD,2);
            heirarchy.put(DIV,2);

            StringBuilder temp = new StringBuilder();
            temp.append("");
            char poppedData = '~';
            for (int i=0; i<expression.length(); i++){
                char c = expression.charAt(i);
                if ((c>=48 && c<=57) || c==PERIOD){
                    temp.append(c);
                }
                else{
                    if (!temp.toString().equals("")){
                        operandStack.add(temp.toString());
                        temp.delete(0,temp.length());
                    }
                    if (c==OPEN_BRAC)
                        operatorStack.push(""+c);
                    else if (c==CLOSE_BRAC){
                        while (poppedData!=OPEN_BRAC){
                            poppedData = operatorStack.pop().charAt(0);
                            operandStack.push(poppedData+"");
                        }
                        operandStack.pop();
                        poppedData = '~';
                    }
                    else{
                        if (!operatorStack.empty()){

                            if (heirarchy.get(c)>heirarchy.get(operatorStack.peek().charAt(0))){
                                operatorStack.push(c+"");
                            }
                            else{
                                while (poppedData!=OPEN_BRAC && heirarchy.get(poppedData)<heirarchy.get(c)){
                                    poppedData = operatorStack.pop().charAt(0);
                                    operandStack.push(poppedData+"");
                                }
                                operatorStack.push(poppedData+"");
                                operatorStack.push(c+"");
                            }
                        }
                        else{
                            operatorStack.push(c+"");
                        }
                    }
                }
            }
            if (!temp.toString().equals(""))
                operandStack.add(temp.toString());
            temp.delete(0,temp.length());
            while (!operatorStack.empty()){
                operandStack.push(operatorStack.pop());
            }
            return operandStack;
        }
        catch (Exception e){
//            Log.e("calculation",e.getMessage().toString());
            Toast.makeText(context, "Error at conversion()", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    private double calculation(Stack<String> stack){
        try {
            Iterator<String> i = stack.iterator();
            Stack<Double> finalStack = new Stack<>();
            Toast.makeText(context,stack.toString(), Toast.LENGTH_SHORT).show();
            char ch;
            while (i.hasNext()){
                String s = i.next();
                if (s.length()==1 && !Character.isDigit(s.charAt(0))){
                    //this condition means operator
                    ch = s.charAt(0);
                    double b = finalStack.pop();
                    double a = finalStack.pop();
                    double res = calculate(a,b,ch);
                    finalStack.push(res);
                }
                else{
//                    this condition means operand
                    double num = Double.parseDouble(s);
                    finalStack.push(num);
                }
            }
            return finalStack.pop();
        }
        catch (Exception e){
            Toast.makeText(context, "Unknown error at calculation()", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    private double calculate(double a,double b,char c){
        double result = Double.MIN_VALUE;
        try{
            if (c==PLUS)
                result = a+b;
            else if (c==MINUS)
                result = a-b;
            else if (c==PROD)
                result = a*b;
            else if (c==DIV)
                result = a/b;
        }
        catch (ArithmeticException ae){
            Toast.makeText(context, "ERROR! Can't divide by zero", Toast.LENGTH_SHORT).show();
        }
        return result;
    }

}
