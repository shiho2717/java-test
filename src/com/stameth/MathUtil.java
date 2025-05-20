package com.stameth;

public class MathUtil {
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = MathUtil.add(3, 7);
        System.out.println("結果: " + result);
    }
}
