package com.sunshine.java8;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Author: 孙涛
 * @Date: 2018-06-22 10:51
 **/
public class ReduceTest extends TestCase{

    public List<Student> createStudentList(){
        Student student1 = new Student("aaa","xxx","sx",90,1);
        Student student2 = new Student("bbb","xxx",null,71,1);
        Student student3 = new Student("ccc",null,"sx",60,2);
        Student student4 = new Student("ddd","DDD","sx",80,1);
        Student student5 = new Student("eee","EEE","sx",85,2);
        Student student6 = new Student("fff","FFF","sx",92,1);
        Student student7 = new Student("ggg","GGG","sx",86,2);
        //List<Student> studentList = Arrays.asList(student1,student2,student3,student4);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);
        return studentList;
    };

    public void test1(){
        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6);
        //计算list的值
        int totalNum = numberList.stream().reduce(0,Integer::sum);
        System.out.println(totalNum);
    }

    public void test2() {
        List<Student> studentList = createStudentList();
        int totalScore = studentList.stream().filter(student -> student.getScore() >= 90).map(Student::getScore).reduce(0, Integer::sum);
        System.out.println("大于等于90分以上的，总分之和 ： " + totalScore);
        Optional<Integer> totalScoreOptional = studentList.stream().filter(student -> student.getScore() >= 90).map(Student::getScore).reduce(Integer::sum);
        System.out.println("reduce 没有初始值时，用option来接");
        System.out.println("大于等于90分以上的，总分之和 ： " + totalScoreOptional.get());
    }

    public void test3() {
        List<Student> studentList = createStudentList();
        Optional<Integer> minScoreOptional = studentList.stream().map(Student::getScore).reduce(Integer::min);
        System.out.println("查找班级分数最低分："+minScoreOptional.get());
    }


}
