package com.lyz.java.recursion;

import com.sun.tools.javac.comp.Check;

/**
 * @author yuan
 * @date 2021/11/14 下午5:02
 */


public class Queue8 {
    private static int[] arr;
    private static int count;
    public static void main(String[] args) {
        arr = new int[8];
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println();
        System.out.printf("一共有 %d 种解法", count);
    }

    public void check(int n) {
        if (n == arr.length) {
            print();
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    public static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void print() {
        count++;
        for (int value : arr) {
            System.out.print(value + "-> ");
        }
    }

}
