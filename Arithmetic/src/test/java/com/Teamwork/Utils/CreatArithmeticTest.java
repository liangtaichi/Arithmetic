package com.Teamwork.Utils;

import com.TeamWork.Utils.CreatArithmetic;
import org.junit.Test;

public class CreatArithmeticTest {
    @Test
    public void testCreate(){
        String[] arithmetic = CreatArithmetic.creat(5,5);
        StringBuffer s = new StringBuffer();

        for(String s1 :arithmetic){
            s.append(s1);
        }
        System.out.println(s.toString());
    }
}
