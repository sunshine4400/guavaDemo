package com.sunshine.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: 孙涛
 * @Date: 2018-05-21 15:23
 **/
public class Java8TestPredicate {
    public static void main(String[] args) {
        List <Integer>  list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        // Predicate<Integer> predicate = n -> true
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true
        System.out.println("输出所有数据:");
        // 传递参数 n
        eval(list,n -> true);
        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n%2 为 0 test 方法返回 true
        System.out.println("输出所有偶数:");
        eval(list,n -> n%2 == 0);
        // Predicate<Integer> predicate2 = n -> n > 3
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n 大于 3 test 方法返回 true
        System.out.println("输出大于 3 的所有数字:");
        eval(list,n -> n > 3);
        System.out.println("输出大于 5 的所有数字:");
        List<Integer> returnList = conditionFilter(list,s -> s > 5);
        returnList.forEach(System.out::println);

        List<String> wordList = Arrays.asList("helloo","sunshine","dump","shift");
        wordList.stream().filter(word -> word.length() > 5).map(word -> word.toUpperCase()).forEach(System.out::println);

    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate){
        for (Integer n : list) {
            if(predicate.test(n)){
                System.out.println(n);
            }
        }
    }
    public static List<Integer> conditionFilter(List<Integer> list, Predicate<Integer> predicate){
       return list.stream().filter(predicate).collect(Collectors.toList());
    }
}
