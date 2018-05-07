package com.sunshine.java8;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


/**
 * @Description:
 * @Author: 孙涛
 * @Date: 2018-04-27 15:54
 **/
public class ListTest extends TestCase {

    public void test1(){
        Student student1 = new Student("aaa","xxx","sx",90);
        Student student2 = new Student("bbb","xxx",null,30);
        Student student3 = new Student("ccc",null,"sx",60);
        Student student4 = new Student("ddd","aa","sx",80);
        //List<Student> studentList = Arrays.asList(student1,student2,student3,student4);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        System.out.println(studentList.size());
        studentList.removeIf(s -> s.getScore() >= 60);
        System.out.println(studentList.size());
        //List<Integer> list = new ArrayList<>();
        //list.add(1);
        //list.add(2);
        //list.add(3);
        //list.add(4);
        //list.removeIf(s -> s%2==0);               // 过滤掉模2等于0的数
        //list.forEach(s -> System.out.println(s)); // 输出 1 3

    }
}
