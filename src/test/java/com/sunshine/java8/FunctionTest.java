package com.sunshine.java8;

import junit.framework.TestCase;

import java.util.function.Function;

/**
 * @Description:
 * @Author: 孙涛
 * @Date: 2018-06-21 11:19
 **/
public class FunctionTest extends TestCase{
    public  void test1(){
        Function<Integer,Integer> f = x -> x + 1;
        Function<Integer,Integer> g = x -> x * 2;
        Function<Integer,Integer> h = f.andThen(g);
        Function<Integer,Integer> i = f.compose(g);
        //(2+1)*2 = 6
        int a = h.apply(2);
        System.out.println(a);
        //(2*2)+1 = 5
        int b = i.apply(2);
        System.out.println(b);
    }


}
