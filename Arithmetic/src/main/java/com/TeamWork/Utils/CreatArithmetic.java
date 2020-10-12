package com.TeamWork.Utils;

public class CreatArithmetic {
    public static String[] creat(int max, int round){
        String[] answer = new String[round+1];
        String[] allArithmetic = new String[round+1];
        for (int i = 0; i < round; i++) {
            do {
                String arithmetic = ExpressionBuilder.build(max);
                allArithmetic[i] = arithmetic;
                answer[i] = String.valueOf(evalRPN.calculate(arithmetic));
            }while(haveIt(answer,answer[i]));
        }
        return allArithmetic;
    }
    private static boolean haveIt(String []answer,String it){
        for (int i = 0; i < answer.length; i++) {
            if (answer[i].equals(it)){
                return true;
            }
        }
        return false;
    }
}
