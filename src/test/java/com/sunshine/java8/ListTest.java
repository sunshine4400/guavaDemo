package com.sunshine.java8;
import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @Description:
 * @Author: 孙涛
 * @Date: 2018-04-27 15:54
 **/
public class ListTest extends TestCase {

    //private Student student;
    //
    //public Student getStudent() {
    //    return student;
    //}
    //
    //public void setStudent(Student student) {
    //    this.student = student;
    //}

    public List<Student> createStudentList(){
        Student student1 = new Student("aaa","xxx","sx",90,1);
        Student student2 = new Student("bbb","xxx",null,71,1);
        Student student3 = new Student("ccc",null,"sx",60,2);
        Student student4 = new Student("ddd","DDD","sx",80,1);
        Student student5 = new Student("eee","EEE","sx",75,2);
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
//计算各种指数 平均值 最大 最小值
    public void test3(){
        //分析全部
        List<Student>  studentList = createStudentList();
        IntSummaryStatistics intSummaryStatistics = studentList.stream().mapToInt(stu -> stu.getScore()).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getSum());
        System.out.println(intSummaryStatistics.getCount());
    }

    public void test4() {
        List<Student> studentList = createStudentList();
        //获取等分最高的学生
        Optional<Student> optStudent = studentList.stream().collect(Collectors.maxBy(Comparator.comparing(student -> student.getScore())));

        //找打得分最高的学生
        int highScore = studentList.stream().collect(Collectors.maxBy(Comparator.comparing(student -> student.getScore()))).get().getScore();
        System.out.println("最高分 "+highScore);

        //计算平均值
        double avgScore = studentList.stream().collect(Collectors.averagingInt(Student::getScore));
        System.out.println("平均分 "+avgScore);

        //计算总得分
        int totalScore = studentList.stream().collect(Collectors.summingInt(Student::getScore));
        System.out.println("总得分 "+ totalScore);

        //按性别分组
         Map<Integer ,List<Student>> groupBySexMap = studentList.stream().collect(Collectors.groupingBy(Student::getSex));
        System.out.println("按照性别分组 "+ JSON.toJSONString(groupBySexMap));
    }
    public void test5() {
        List<Student> studentList = createStudentList();
        String studentName = studentList.stream().map(student -> student.getFirstName()).collect(Collectors.joining(",", "[", "]"));
        System.out.println("按照格式 拼装" + studentName);
        Map<Integer, Long> sexCountMap = studentList.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.counting()));
        // Map<Integer,Long> sexCountMap = studentList.stream().collect(Collectors.groupingBy(Student -> Student.getSex(),Collectors.counting()));
        System.out.println("统计各个性别学生个数：" + JSON.toJSONString(sexCountMap));
        Map<Integer, List<String>> sexNameMap = studentList.stream().
                collect(Collectors.groupingBy(Student::getSex,
                        Collectors.mapping(Student::getFirstName, Collectors.toList())));
        System.out.println("统计各个性别学生的姓名：" + JSON.toJSONString(sexNameMap));
    }
}
