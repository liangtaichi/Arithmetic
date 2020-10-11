package com.TeamWork.Utils;

import java.util.Random;

public class ExpressionBuilder {
    public static String build(int max){
        Random random = new Random();
        int count = random.nextInt(3) + 2;
        String expression;
        switch (count){
            case 2: expression = TwoNumberOperation(max);
            case 3: expression = ThreeNumberOperation(max);
            case 4: expression = FourNumberOperation(max);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + count);
        }
        return expression;
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
            ProperFraction answer = new ProperFraction();
            answer = Caculate.caculate(e1,e2,sign);
            if (answer.getDenominator() < 0){
                e2 = ProperFractionBuilder.build(max - 1);
            }
        }
        operation = e1.showCompleteRepresentation().concat(" ").concat(sign).concat(" ").concat(e2.showCompleteRepresentation()).concat(" ").concat("=").concat(" ").concat(";");
        return operation;
    }
    /**
     * 三数四则运算式子生成
     * @return ThreeNumberOperatrion
     */
    public static String ThreeNumberOperation(int max){
        String sign1,sign2,operation;
        ProperFraction e1 = new ProperFraction() ,e2 = new ProperFraction() ,e3 = new ProperFraction();
        ProperFraction answer = new ProperFraction();
        /**
         * 产生两个算数符号
         */
        sign1 = CalculatingSignsBuilder.build();
        sign2 = CalculatingSignsBuilder.build();
        /**
         * 产生三个数
         */
        e1 = ProperFractionBuilder.build(max);
        e2 = ProperFractionBuilder.build(max);
        e3 = ProperFractionBuilder.build(max);
        if (sign1.equals("-")|sign2.equals("-")){
            //两个减号
            if (sign1.equals("-")&sign2.equals("-")){
                answer = Caculate.caculate(e1,e2,sign1);
                answer = Caculate.caculate(answer,e3,sign2);
                while (answer.getDenominator() < 0){
                    e1 = ProperFractionBuilder.build(max);
                    e2 = ProperFractionBuilder.build(max/2);
                    e3 = ProperFractionBuilder.build(max/2);
                    answer = Caculate.caculate(e1,e2,sign1);
                    answer = Caculate.caculate(answer,e3,sign2);
                }
            }
            else if (sign1.equals("-")){
                answer = Caculate.caculate(e1,e2,sign1);
                while (answer.getDenominator() < 0){
                    e1 = ProperFractionBuilder.build(max);
                    e2 = ProperFractionBuilder.build(max -1);
                    answer = Caculate.caculate(e1,e2,sign1);
                }
            }
            else if (sign2.equals("-")){
                answer = Caculate.caculate(e1,e2,sign1);
                while (answer.getDenominator() < 0){
                    e3 = ProperFractionBuilder.build(
                            Caculate.caculate(e1,e2,sign1).getDenominator()/Caculate.caculate(e1,e2,sign1).getMolecular());

                }
            }
        }
        operation = e1.showCompleteRepresentation().concat(" ").concat(sign1).concat(" ").concat(e2.showCompleteRepresentation()).concat(" ").concat(sign2).concat(e3.showCompleteRepresentation()).concat("=").concat(" ").concat(";");
        return operation;
    }
    public static String FourNumberOperation(int max){
        String sign1,sign2,sign3,operation;
        ProperFraction e1 = new ProperFraction() ,e2 = new ProperFraction() ,e3 = new ProperFraction(),e4 = new ProperFraction();
        ProperFraction answer = new ProperFraction();
        /**
         * 产生两个算数符号
         */
        sign1 = CalculatingSignsBuilder.build();
        sign2 = CalculatingSignsBuilder.build();
        sign3 = CalculatingSignsBuilder.build();
        /**
         * 产生三个数
         */
        e1 = ProperFractionBuilder.build(max);
        e2 = ProperFractionBuilder.build(max);
        e3 = ProperFractionBuilder.build(max);
        e4 = ProperFractionBuilder.build(max);
        if (sign1.equals("-")|sign2.equals("-")|sign3.equals("-")){
            //三个减号
            if (sign1.equals("-")&sign2.equals("-")&sign3.equals("-")){
                answer = Caculate.caculate(e1,e2,sign1);
                answer = Caculate.caculate(answer,e3,sign2);
                answer = Caculate.caculate(answer,e4,sign3);
                while (answer.getDenominator() < 0){
                    e1 = ProperFractionBuilder.build(max);
                    e2 = ProperFractionBuilder.build(max/3);
                    e3 = ProperFractionBuilder.build(max/3);
                    e4 = ProperFractionBuilder.build(max/3);
                    answer = Caculate.caculate(e1,e2,sign1);
                    answer = Caculate.caculate(answer,e3,sign2);
                    answer = Caculate.caculate(answer,e4,sign3);
                }
            }
            //两个减号
            else if (sign1.equals("-")&sign2.equals("-")){
                answer = Caculate.caculate(e1,e2,sign1);
                answer = Caculate.caculate(answer,e3,sign2);
                answer = Caculate.caculate(answer,e4,sign3);
                while (answer.getDenominator() < 0){
                    e1 = ProperFractionBuilder.build(max);
                    e2 = ProperFractionBuilder.build(max/2);
                    e3 = ProperFractionBuilder.build(max/2);
                    answer = Caculate.caculate(e1,e2,sign1);
                    answer = Caculate.caculate(answer,e3,sign2);
                    answer = Caculate.caculate(answer,e4,sign3);
                }
            }
            else if (sign1.equals("-")&sign3.equals("-")){
                answer = Caculate.caculate(e1,e2,sign1);
                answer = Caculate.caculate(answer,e3,sign2);
                answer = Caculate.caculate(answer,e4,sign3);
                while (answer.getDenominator() < 0){
                    e1 = ProperFractionBuilder.build(max);
                    e2 = ProperFractionBuilder.build(max/2);
                    e4 = ProperFractionBuilder.build(max/2);
                    answer = Caculate.caculate(e1,e2,sign1);
                    answer = Caculate.caculate(answer,e3,sign2);
                    answer = Caculate.caculate(answer,e4,sign3);
                }
            }
            else if (sign2.equals("-")&sign3.equals("-")){
                answer = Caculate.caculate(e1,e2,sign1);
                answer = Caculate.caculate(answer,e3,sign2);
                answer = Caculate.caculate(answer,e4,sign3);
                while (answer.getDenominator() < 0){
                    e1 = ProperFractionBuilder.build(max);
                    e3 = ProperFractionBuilder.build(max/2);
                    e4 = ProperFractionBuilder.build(max/2);
                    answer = Caculate.caculate(e1,e2,sign1);
                    answer = Caculate.caculate(answer,e3,sign2);
                    answer = Caculate.caculate(answer,e4,sign3);
                }
            }
            else if (sign1.equals("-")){
                answer = Caculate.caculate(e1,e2,sign1);
                while (answer.getDenominator() < 0){
                    e1 = ProperFractionBuilder.build(max);
                    e2 = ProperFractionBuilder.build(max -1);
                    answer = Caculate.caculate(e1,e2,sign1);
                }
            }
            else if (sign2.equals("-")){
                answer = Caculate.caculate(e1,e2,sign1);
                while (answer.getDenominator() < 0){
                    e3 = ProperFractionBuilder.build(
                            Caculate.caculate(e1,e2,sign1).getDenominator()/Caculate.caculate(e1,e2,sign1).getMolecular());

                }
            }
            else if (sign3.equals("-")){
                answer = Caculate.caculate(e1,e2,sign1);
                while (answer.getDenominator() < 0){
                    e4 = ProperFractionBuilder.build(
                            Caculate.caculate(e1,e2,sign1).getDenominator()/Caculate.caculate(e1,e2,sign1).getMolecular());

                }
            }
        }
        operation = e1.showCompleteRepresentation().concat(" ").concat(sign1).concat(" ").concat(e2.showCompleteRepresentation()).concat(" ").concat(sign2).concat(e3.showCompleteRepresentation()).concat("=").concat(" ").concat(";");
        return operation;
    }
}
