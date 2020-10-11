package com.TeamWork.Utils;

import java.math.BigDecimal;
import java.util.Random;

public class ExpressionBuilder {
    public static String build(int max){
        Random random = new Random();
        int count = random.nextInt(3) + 2;
        String expression;
        switch (count){
            case 2: expression = TwoNumberOperation(max);
            case 3: expression = ThreeNumberOperatrion();
        }
    }

    /**
     * 两数四则运算式子生成
     * @return TwoNumberOperation
     */
    public static String TwoNumberOperation(int max){
        String sign,operation;
        ProperFraction e1,e2;
        /**
         * 本部分产生一个算数符号
         */
        sign = CalculatingSignsBuilder.build();
        /**
         * 本部分产生两个两个数字
         */
        e1 = ProperFractionBuilder.build(max);
        e2 = ProperFractionBuilder.build(max);
        /**
         * 如果sign为 - ，保证e1 大于等于 e2
         */
        if (sign.equals("-")){
            BigDecimal ValueOfE1 = new BigDecimal(e1);
            BigDecimal ValueOfE2 = new BigDecimal(e2);
            int tag = ValueOfE1.compareTo(ValueOfE2);
            while(tag < 0){
                e2 = CalculatingSignsBuilder.build();
                ValueOfE2 = new BigDecimal(e2);
                tag = ValueOfE1.compareTo(ValueOfE2);
            }
        }
        operation = e1.concat(" ").concat(sign).concat(" ").concat("=").concat(" ").concat(";");
        return operation;
    }
    /**
     * 三数四则运算式子生成
     * @return ThreeNumberOperatrion
     */
    public static String ThreeNumberOperatrion(){
        String e1,e2,e3,sign1,sign2,operation;
        /**
         * 产生两个算数符号
         */
        sign1 = CalculatingSignsBuilder.build();
        sign2 = CalculatingSignsBuilder.build();
        /**
         * 产生三个数
         */
        e1 = CalculatingSignsBuilder.build();
        e2 = CalculatingSignsBuilder.build();
        e3 = CalculatingSignsBuilder.build();
        if (sign1.equals("-")|sign2.equals("-")){
            //两个减号
            if (sign1.equals("-")&sign2.equals("-")){
                
            }
        }
    }
}
