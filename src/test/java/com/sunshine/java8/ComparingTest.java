package com.sunshine.java8;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * @Author: 孙涛
 * @Date: 2018-06-21 10:45
 **/
public class ComparingTest extends TestCase{

    public List<Student> createStudentList(){
        Student student1 = new Student("aaa","xxx","sx",90,1);
        Student student2 = new Student("bbb","xxx",null,71,1);
        Student student3 = new Student("ccc",null,"sx",60,2);
        Student student4 = new Student("ddd","DDD","sx",80,1);
        Student student5 = new Student("eee","EEE","sx",80,2);
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
        List<Student>  studentList = createStudentList();
        //创建一个按分数升序的比较器
        Comparator<Student> comparatorAsc = Comparator.comparing(Student::getScore);
        //创建一个按分数降序的比较器
        Comparator<Student> comparatorDesc = Comparator.comparing(Student::getScore).reversed();
        //按分数排序完之后，再按照性别排序
        Comparator<Student> comparatorScoreSex = Comparator.
                                        comparing(Student::getScore).reversed().
                                        thenComparing(Student::getSex);
        studentList.stream().sorted(comparatorAsc).forEach(student -> {
            System.out.println(student.getSex() + "v "+ student.getScore());
        }
        );
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        studentList.stream().sorted(comparatorDesc).forEach(student -> {
                    System.out.println(student.getSex() + "v "+ student.getScore());
                }
        );
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        studentList.stream().sorted(comparatorScoreSex).forEach(student -> {
                    System.out.println(student.getSex() + "v "+ student.getScore());
                }
        );


    }
}
