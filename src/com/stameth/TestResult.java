package com.stameth;

public class TestResult {
	static int totalScore = 0;
    static int studentCount = 0;

    public TestResult(int score) {
        totalScore += score;
        studentCount++;
    }

    public static double average() {
        return (double) totalScore / studentCount;
    }

    public static void main(String[] args) {
        new TestResult(80);
        new TestResult(90);
        new TestResult(70);
        System.out.println("平均点: " + TestResult.average());
    }
}
