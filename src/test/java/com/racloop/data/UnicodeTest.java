package com.racloop.data;

import org.junit.Test;

public class UnicodeTest {

    @Test
    public void testUnicode() {
        String name =  "Björnstad12 Jean-Marie Le'Blanc Żółć Ὀδυσσεύς 原田雅彦 ";
        String str = name.replaceAll("[^\\p{L}^\\p{Pd}]", "");
        System.out.println(str);
    }

    @Test
    public void count() {
        String name =  "R.A.M. Punchouty";
        int count = 0;
        String [] str = name.split(" ");
//        count = count + str.length;
        for (String s : str) {
            String [] t = s.split("\\.");
            count = count + t.length;
        }
        System.out.println(count);
    }



    @Test
    public void coutn() {
        String name =  "Ars�lio P.";
        System.out.println(name.indexOf('\uFFFD'));
    }
}
