package com.lyz.java;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/10/22 下午7:48
 */


public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {53, 3, 542, 748, 14, 214};
//        radixSort(arr);
//        System.out.println(Arrays.toString(arr));

        int [] arr = RandomArr.getRandomArr(80000);
        int before = (int) System.currentTimeMillis();
        radixSort(arr);
        int after = (int) System.currentTimeMillis();
        System.out.println(after - before);
    }

    public static void radixSort(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        int [][] bucket = new int[10][arr.length];
        int[] bucketEleCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfEle = arr[j] / n % 10;
                bucket[digitOfEle][bucketEleCounts[digitOfEle]] = arr[j];
                bucketEleCounts[digitOfEle]++;
            }
            int index = 0;
            for (int j = 0; j < bucketEleCounts.length; j++) {
                if (bucketEleCounts[j] != 0){
                    for (int k = 0; k < bucketEleCounts[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                bucketEleCounts[j] = 0;
            }
        }
    }
}
