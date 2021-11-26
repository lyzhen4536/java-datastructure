package com.lyz.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuan
 * @date 2021/10/23 下午8:42
 */


public class InsertValueSearch {
    public static void main(String[] args) {
//        int[] arr = new int[100];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i + 1;
//        }

        int[] arr = {1, 8, 77, 89, 1000, 1000, 1234};

        ArrayList<Integer> list = insertValueSearch(arr, 0, arr.length - 1, 1000);
        System.out.println(list);

    }

    public static ArrayList<Integer> insertValueSearch(int[] arr, int left, int right, int val) {
        System.out.println(11);
        int mid = left + (right + left) * (val - arr[left]) / (arr[right] - arr[left]);
        if (left > right || val < arr[left] || val > arr[right]) {
            return new ArrayList<Integer>();
        }
        if (val > arr[mid]) {
            return insertValueSearch(arr, mid + 1, right, val);
        } else if (val < arr[mid]) {
            return insertValueSearch(arr, left, mid - 1, val);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != val) {
                    break;
                }
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp >= arr.length || arr[temp] != val) {
                    break;
                }
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
