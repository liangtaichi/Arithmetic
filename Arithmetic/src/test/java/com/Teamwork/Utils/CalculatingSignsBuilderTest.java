package com.Teamwork.Utils;

import com.TeamWork.Utils.CalculatingSignsBuilder;
import org.junit.Test;

public class CalculatingSignsBuilderTest {
    @Test
    public void testBuild(){
        String sign = CalculatingSignsBuilder.build();
        System.out.println(sign);
    }
}
