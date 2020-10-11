package com.TeamWork.Utils;

import java.util.Random;

/**
 * 随机返回一个运算符号
 * @@OutputType String
 */
public class CalculatingSignsBuilder {
    public static String build() {
        Random random = new Random();
        int signNumber = random.nextInt(4) + 1;
        String sign;
        switch (signNumber){
            case 1: sign = "+";
            case 2: sign = "-";
            case 3: sign = "*";
            case 4: sign = "÷";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + signNumber);
        }
        return sign;
    }
}
