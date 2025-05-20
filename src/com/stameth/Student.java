package com.stameth;

public class Student {
    static int count = 0;

    public Student() {
        count++;
    }

    public static void showCount() {
        System.out.println("作られた人数：" + count);
    }

    public static void main(String[] args) {
        new Student();
        new Student();
        Student.showCount();
    }

}
