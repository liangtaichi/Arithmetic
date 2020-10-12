package com.Teamwork.Utils;

import com.TeamWork.Utils.ProperFraction;
import com.TeamWork.Utils.ProperFractionBuilder;
import org.junit.Test;

public class ProperFractionBuilderTest {
    @Test
    public void testBuild(){
        ProperFraction properFraction = ProperFractionBuilder.build(5);
        System.out.println(properFraction.showCompleteRepresentation());
    }
}
