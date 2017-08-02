package com.syswin.guava.base;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by suntaojs on 2017/3/19.
 */
public class IntsTest extends TestCase {

    public void test(){
        //转换成集合
        List<Integer> intArr = Ints.asList(1, 3, 4, 6);
        //用,号拼接
        String intStr = Ints.join(",", 1, 2, 3, 4);
        //把两个数组拼成一个数组
        int[] concat = Ints.concat(new int[]{1, 3}, new int[]{4, 6});
        //最大值：7
        int max = Ints.max(2, 3, 4, 7);
        //集合中是否包含指定的数字：false
        boolean contains = Ints.contains(new int[]{1, 3, 4, 5}, 6);
        //集合转换成数组
        int[] ints = Ints.toArray(Lists.newArrayList(1, 2, 3, 5));
        System.out.println("intArr:"+intArr);
        System.out.println("intStr:"+intStr);
        System.out.println("concat:"+concat);
        System.out.println("max:"+max);
        System.out.println("contains:"+contains);
        System.out.println("ints:"+ints);


    }
}
