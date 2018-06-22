package com.sunshine.java8;

import com.sunshine.java8.domain.ScoreLevelEunm;
import junit.framework.TestCase;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * @Description:
 * @Author: 孙涛
 * @Date: 2018-06-22 15:13
 **/
public class CollectorTest extends TestCase{

    public void test1(){
        List<Student> studentList = StudentFactory.createStudentList();
        long count = studentList.stream().collect(counting());
        System.out.println("学生总数：" + count);
    }

    public void test2(){
        List<Student> studentList = StudentFactory.createStudentList();
        Optional<Student> studentOptional = studentList.stream().
                collect(maxBy(Comparator.comparingInt(Student::getScore)));
        studentOptional.ifPresent(student -> {
            System.out.println("分数最高的学生的姓名："+student.getFirstName());
        });
        System.out.println("分数最高的学生的姓名：：" + studentOptional.get().getFirstName());
    }

    public void test3(){
        List<Student> studentList = StudentFactory.createStudentList();
        //总分
        int sumScore = studentList.stream().collect(summingInt(Student::getScore));
        //平均分
        double avgScore = studentList.stream().collect(averagingInt(Student::getScore));
        //统计分析
        IntSummaryStatistics intSummaryStatistics = studentList.stream().collect(summarizingInt(Student::getScore));
        System.out.println("统计分析 平均分:"+intSummaryStatistics.getAverage());
        System.out.println("统计分析 总分:"+intSummaryStatistics.getSum());
        System.out.println("总分:"+sumScore);
        System.out.println("平均分:"+avgScore);
    }

    public void test4(){
        List<Student> studentList = StudentFactory.createStudentList();
        //获取所有学生的姓名，并且用逗号分开
        String studentName = studentList.stream().map(Student::getFirstName).collect(joining(","));
        System.out.println("所有学生的姓名，并且用逗号分开 :"+studentName);
    }

    public void test5() {
        List<Student> studentList = StudentFactory.createStudentList();
        //按分数枚举值进行分组，及格，好，完美
        Map<ScoreLevelEunm, List<Student>> scoreLevelEunmListList = studentList.stream().collect(
                groupingBy(student -> {
                    if(student.getScore() < 75) return ScoreLevelEunm.BAD;
                    else if(student.getScore() >89) return ScoreLevelEunm.PERFECT;
                    else return ScoreLevelEunm.GOOD;
                }));
        System.out.println(scoreLevelEunmListList.toString());
    }

    //TODO 多次分组
    //public void test6() {
    //    List<Student> studentList = StudentFactory.createStudentList();
    //    //按分数枚举值进行分组，及格，好，完美
    //    Map<Student,Map<ScoreLevelEunm, List<Student>>> scoreLevelEunmListList = studentList.stream().collect(groupingBy(Student::getSex));
    //    System.out.println(scoreLevelEunmListList.toString());
    //}
    public void test7() {
        List<Student> studentList = StudentFactory.createStudentList();
        Map<ScoreLevelEunm, Long> scoreLevelEunmListList = studentList.stream().collect(
                groupingBy(student -> {
                    if(student.getScore() < 75) return ScoreLevelEunm.BAD;
                    else if(student.getScore() >89) return ScoreLevelEunm.PERFECT;
                    else return ScoreLevelEunm.GOOD;
                },counting()));
        System.out.println("统计各个阶段的学生人数："+scoreLevelEunmListList.toString());
    }
}
