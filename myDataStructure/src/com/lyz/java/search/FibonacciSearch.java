package com.lyz.java.search;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/11/20 下午2:47
 */


public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int i = fibonacciSearch(arr, 1);
        System.out.println("index=" + i);// 0
    }

    public static int fibonacciSearch(int[] arr, int value) {
        //查找界限
        int low = 0;
        int high = arr.length - 1;
        //存放分割数的下标和值
        int k = 0;
        int mid = 0;
        //得到斐波那契数列
        int[] fib = fib();
        //获得k分割数的下标
        while (high > fib[k] - 1) {
            k++;
        }
        //对数组扩容
        int[] temp = Arrays.copyOf(arr, fib[k]);
        //填充扩容数组
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        //当左界大于等于右界时退出
        while (low <= high) {
            mid = low + fib[k - 1] - 1;
            if (value < temp[mid]) {
                //查找的数在左边
                high = mid - 1;
                //f[k] = f[k-1] + f[k-2],位于左半段时,下次判定mid时k应该-1
                k--;
            } else if (value > temp[mid]) {
                //查找的数在右边
                low = mid + 1;
                //f[k] = f[k-1] + f[k-2],位于右半段时,下次判定mid时k应该-2
                k -= 2;
            } else {
                //找到了
                //当mid位于扩容的数组中时，返回最大值
                return Math.min(mid, high);
            }
        }
        //没找到
        return -1;
    }


    public static int[] fib() {
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
}
