package com.TeamWork.Utils;

public class Caculate {
    public ProperFraction caculate(ProperFraction properFraction1 , ProperFraction properFraction2 , String sign){
        ProperFraction answer = new ProperFraction();
        switch (sign){
            case "+" :{
                ProperFraction temp1 = new ProperFraction() , temp2 = new ProperFraction();
                temp1.setDenominator(properFraction1.getDenominator()*properFraction2.getMolecular());
                temp2.setDenominator(properFraction2.getDenominator()*properFraction1.getMolecular());
                answer.setMolecular(properFraction1.getMolecular()*properFraction2.getMolecular());
                answer.setDenominator(temp1.getDenominator()+temp2.getDenominator());
                answer.Reduce();
            }
            case "-" :{
                ProperFraction temp1 = new ProperFraction() , temp2 = new ProperFraction();
                temp1.setDenominator(properFraction1.getDenominator()*properFraction2.getMolecular());
                temp2.setDenominator(properFraction2.getDenominator()*properFraction1.getMolecular());
                answer.setMolecular(properFraction1.getMolecular()*properFraction2.getMolecular());
                answer.setDenominator(temp1.getDenominator()-temp2.getDenominator());
                answer.Reduce();
            }
            case "*" :{
                answer.setMolecular(properFraction1.getMolecular()*properFraction2.getMolecular());
                answer.setDenominator(properFraction1.getDenominator()*properFraction2.getDenominator());
                answer.Reduce();
            }
            case "÷" :{
                answer.setMolecular(properFraction1.getMolecular()*properFraction2.getDenominator());
                answer.setDenominator(properFraction1.getDenominator()*properFraction2.getMolecular());
                answer.Reduce();
            }
        }
        return answer;
    }
}
