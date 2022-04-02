package com.android.s19110261;

public class Cal {
    public enum Operator{Calc, SUM}
    public double calc(double firstOperand, double secondOperand, double thirdOperand){
        double interest_rate = secondOperand/100;
        double count_date = thirdOperand*30;
        return firstOperand*interest_rate*count_date/360;
    }

    public double sum(double firstOperand, double secondOperand, double thirdOperand){
        double interest_rate = secondOperand/100;
        double count_date = thirdOperand*30;
        double interest = firstOperand*interest_rate*count_date/360;

        return firstOperand + interest;
    }
}
