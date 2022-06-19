package org.elasticsearch.plugin.utilTest;

import org.elasticsearch.index.common.custom.CustomConverter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DooFilterTest {

    @Test
    public void dooConverter(){

        String string= "doo";
        CustomConverter customConverter = new CustomConverter();
        String word = customConverter.convert(string);

        System.out.println("결과 : " + word);
        assertEquals("doo", word);
    }
}
