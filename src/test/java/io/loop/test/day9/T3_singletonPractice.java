package io.loop.test.day9;

import org.testng.annotations.Test;

import java.util.SortedMap;

public class T3_singletonPractice {

    @Test
    public void T3_singletonPractice() {
        String str = T2_singletonPattern_Example.getWord();
        System.out.println("str=" + str);

        System.out.println("==============");
        String str2 = T2_singletonPattern_Example.getWord();
        System.out.println("str2=" + str2);
    }
}
