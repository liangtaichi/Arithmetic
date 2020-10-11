package com.TeamWork.Utils;

public class ProperFraction {
    int molecular;
    int denominator;
    void setMolecular(int molecular){
        this.molecular = molecular;
    }
    void setDenominator(int denominator){
        this.denominator = denominator;
    }
    int getMolecular(){
        return this.molecular;
    }
    int getDenominator(){
        return this.denominator;
    }
    //约分
    void Reduce(){
        int commonDivisor = getCommonDivisor(this.getDenominator(),this.getMolecular());
        setDenominator(getDenominator()/commonDivisor);
        setMolecular(getMolecular()/commonDivisor);
    }
    private int getCommonDivisor(int denominator , int molecular){
        int min;
        int tem = 1;
        min = (denominator<molecular) ? denominator:molecular;
        for(int i = min; i >= 1; i--)
        {
            if(denominator%i==0&&molecular%i==0) {
                tem = i;
            }
        }
        return tem;
    }
}
