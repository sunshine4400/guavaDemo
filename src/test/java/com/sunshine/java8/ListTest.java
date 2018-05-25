package com.sunshine.java8;

import junit.framework.TestCase;

import java.util.*;


/**
 * @Description:
 * @Author: 孙涛
 * @Date: 2018-04-27 15:54
 **/
public class ListTest extends TestCase {

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> createStudentList(){
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
        return studentList;
    };
    public void test1(){
        List<Student>  studentList = createStudentList();
        //System.out.println("before " + studentList.size());
        //studentList.removeIf(s -> s.getScore() <= 60);
        //System.out.println("after " + studentList.size());
        //打印输出
        studentList.forEach(student -> System.out.println(student.getFirstName()+" "+student.getScore()));
        System.out.println("按名称排序： " + studentList.size());
        Collections.sort(studentList,(a,b)->a.getScore().compareTo(b.getScore()) );
        studentList.forEach(s -> System.out.println(s.getFirstName()+" "+s.getScore()));
       // System.out.println();studentList.forEach(Student::getFirstName);
        //List<Integer> list = new ArrayList<>();
        //list.add(1);
        //list.add(2);
        //list.add(3);
        //list.add(4);
        //list.removeIf(s -> s%2==0);               // 过滤掉模2等于0的数
        //list.forEach(s -> System.out.println(s)); // 输出 1 3
    }

    public void test2(){
        Integer[] a = new Integer[]{3, 1, 2, 4, 6, 5};
        Comparator<Integer> comparator = Integer::compare;
        Arrays.sort(a, comparator);
        System.out.println("升序：" + Arrays.toString(a));

        Arrays.sort(a,comparator.reversed());
        System.out.println("降序："+Arrays.toString(a));



        //List<Student>  studentList = createStudentList();
        //Comparator<Student> studentComparator = (Student s1, Student s2) -> (s1.getScore().compareTo(s2.getScore()));
        //Arrays.sort(studentList,(Student s1, Student s2) -> (s1.getScore().compareTo(s2.getScore()));

    }
}
