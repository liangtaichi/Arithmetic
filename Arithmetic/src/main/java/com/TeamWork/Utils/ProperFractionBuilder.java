package com.TeamWork.Utils;

import java.util.Random;

/**
 * 分数生成器
 * max 最大值， 当max == 0， 分数最大值为 100
 * @InputType int
 * @OutputType String
 */
public class ProperFractionBuilder {

    public static ProperFraction build(int max){
        if (max == 0){
            max = 100;
        }
        int min = 1;
        int molecular,denominator;
        ProperFraction poperFraction = new ProperFraction();
        Random random = new Random();
        //0生成分数，1生成整数
        int tag = random.nextInt(1);
        switch (tag){
            case 0:{
                //真分数生成
                //分母为1到max之间的数
                denominator =random.nextInt(max) + 1;
                //分子为denominator到min之间的数
                molecular = random.nextInt(denominator - min + 1) + min;
                //字符串拼接
                poperFraction.setDenominator(denominator);
                poperFraction.setMolecular(molecular);
            }
            case 1:{
                //整数生成
                molecular = random.nextInt(max);
                poperFraction.setMolecular(molecular);
                poperFraction.setDenominator(1);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + tag);
        }

        return poperFraction;
    }
}
