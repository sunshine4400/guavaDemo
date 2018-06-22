package com.sunshine.java8;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @Description:
 * @Author: 孙涛
 * @Date: 2018-06-22 14:46
 **/
public class StreamTest extends TestCase{
    public void test1(){
        int [] numArr = {1,2,3,4,5,6};
        int total = Arrays.stream(numArr).sum();
        System.out.println("total "+total);
    }
}
