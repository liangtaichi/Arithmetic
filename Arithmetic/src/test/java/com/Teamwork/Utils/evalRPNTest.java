package com.Teamwork.Utils;

import com.TeamWork.Utils.ProperFraction;
import com.TeamWork.Utils.evalRPN;
import org.junit.Test;

public class evalRPNTest {
    @Test
    public void testCaculate(){
        ProperFraction properFraction = evalRPN.calculate("2/3 * 4/5 =");
        System.out.println(properFraction.showCompleteRepresentation());
    }
}
