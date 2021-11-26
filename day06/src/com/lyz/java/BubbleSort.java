package com.lyz.java;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuan
 * @date 2021/10/21 下午6:55
 */


public class BubbleSort {
    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 10, 20};
//
//        System.out.printf("第 %d 次排序 ",1);
//        System.out.println(Arrays.toString(arr));
//
//        bubbleSort(arr);
//
//        System.out.printf("第 %d 次排序 ",2);
//        System.out.println(Arrays.toString(arr));

        int [] arr = RandomArr.getRandomArr(80000);

        int before = (int) System.currentTimeMillis();

        bubbleSort(arr);

        int after = (int) System.currentTimeMillis();


        System.out.println(after - before);

    }

    public static void bubbleSort(int [] arr){
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

//            System.out.printf("第 %d 次排序 ",i+1);
//            System.out.println(Arrays.toString(arr));

            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
    }
}
