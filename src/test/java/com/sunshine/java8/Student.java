package com.sunshine.java8;

/**
 * @Description:
 * @Author: 孙涛
 * @Date: 2018-04-27 15:55
 **/
public class Student implements Comparable<Integer>{

  private  String firstName;

    private String lastName;

    private Integer sex;

    private String address;

    private Double grade;

    private Integer  score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    private  Double feeDiscount = 0.0;

    private Double baseFee = 2000.0;

    public Student(String firstName, String lastName, Double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public Student(String firstName, String lastName, String address, Integer score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.score = score;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Double getFeeDiscount() {
        return feeDiscount;
    }

    public void setFeeDiscount(Double feeDiscount) {
        this.feeDiscount = feeDiscount;
    }

    public Double getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(Double baseFee) {
        this.baseFee = baseFee;
    }

    public void printFee(){
        Double newFee = baseFee - ((baseFee * feeDiscount)/100);
        System.out.println("The fee after discount: " + newFee);
    }

    public static int sortbyScore(Student a , Student b){
            return a.getScore().compareTo(b.getScore());
    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}
