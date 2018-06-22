package com.sunshine.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 孙涛
 * @Date: 2018-06-22 15:14
 **/
public class StudentFactory {
    public static List<Student> createStudentList(){
        Student student1 = new Student("aaa","xxx","sx",90,1);
        Student student2 = new Student("bbb","xxx",null,71,1);
        Student student3 = new Student("ccc",null,"sx",60,2);
        Student student4 = new Student("ddd","DDD","sx",80,1);
        Student student5 = new Student("eee","EEE","sx",80,2);
        Student student6 = new Student("fff","FFF","sx",91,1);
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
}
