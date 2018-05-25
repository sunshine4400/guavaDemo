package com.sunshine.java8;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Description:
 * @Author: 孙涛
 * @Date: 2018-05-24 15:37
 **/
public class PredicateConsumerDemo {

    public static Student updateStudentFee(Student student,
                                           Predicate<Student> studentPredicate , Consumer<Student> studentConsumer){
        if(studentPredicate.test(student)){
            studentConsumer.accept(student);
        }
        return  student;
    }

    public static void main(String[] args) {
        Student student1 = new Student("sun","shine",9.5);
        student1 = updateStudentFee(student1,student -> student.getGrade() > 8.5,student -> student.setFeeDiscount(30.0));
        student1.printFee();

        Student student2 = new Student("leno","alise",8.0);
         student2 = updateStudentFee(student2,student ->  student.getGrade() >= 8.0 ,student ->  student.setFeeDiscount(20.0));
        student2.printFee();

    }

}
