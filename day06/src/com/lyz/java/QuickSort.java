package com.lyz.java;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/10/21 下午11:29
 */


public class QuickSort {
    public static void main(String[] args) {
//        int [] arr = {-9, 78, 0, 23, -567, 70};
//        quickSort(arr,0,arr.length -1);
//        System.out.println(Arrays.toString(arr));

        int [] arr = RandomArr.getRandomArr(80000);
        int before = (int) System.currentTimeMillis();
        quickSort(arr,0,arr.length -1);
        int after = (int) System.currentTimeMillis();
        System.out.println(after - before);
    }

    public static void quickSort(int [] arr, int left, int right){
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r){
            while (arr[l] < pivot){
                l++;
            }
            while (arr[r] > pivot){
                r--;
            }
            if (l >= r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot){
                r--;
            }

            if (arr[r] == pivot){
                l++;
            }

        }

        if (l == r){
            l++;
            r--;
        }

        if (left < r){
            quickSort(arr, left, r);
        }

        if (right > l){
            quickSort(arr,l, right);
        }

    }
}
