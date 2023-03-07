package com.example.calculatorapp.methods;

import android.content.Context;

public class FormatCheckerMethods extends Methods{
    private Context context;
    @Override
    void setContext(Context context) {
           this.context = context;
    }
    public FormatCheckerMethods(Context context){
        setContext(context);
    }

    int openBracCount = 0;
    int closeBracCount = 0;
    boolean areBracsFormatted(){
        return openBracCount > closeBracCount;
    }
    boolean areBracsFormatted(char ch){
        return ch != CLOSE_BRAC;
    }
    void allCancelled(){
        openBracCount=0;
        closeBracCount=0;
    }
//  the method below is to maintain states when some character is cancelled
    void whatIsCancelled(char ch){
        if (ch==OPEN_BRAC){
            openBracCount--;
        }
        else if (ch==CLOSE_BRAC){
            closeBracCount--;
        }
    }

}
