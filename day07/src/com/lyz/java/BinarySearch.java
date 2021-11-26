package com.lyz.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2021/10/23 下午7:54
 */


public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
//        int search = binarySearch(arr, 0, arr.length - 1, 1000);
//        System.out.println(search);

        int[] arr = {1, 1, 77, 89, 1000, 100, 1234};
        List<Integer> list = binarySearchAllIndex(arr, 0, arr.length - 1, 1);
        System.out.println(list);
    }

    public static int binarySearch(int[] arr, int left, int right, int val) {
        int mid = (left + right) / 2;

        if (left > right) {
            return -1;
        }
        if (val > arr[mid]) {
            return binarySearch(arr, mid + 1, right, val);
        } else if (val < arr[mid]) {
            return binarySearch(arr, left, mid - 1, val);
        } else {
            return mid;
        }
    }

    public static List<Integer> binarySearchAllIndex(int[] arr, int left, int right, int val) {
        System.out.println(11);
        int mid = (left + right) / 2;

        if (left > right) {
            return new ArrayList<Integer>();
        }
        if (val > arr[mid]) {
            return binarySearchAllIndex(arr, mid + 1, right, val);
        } else if (val < arr[mid]) {
            return binarySearchAllIndex(arr, left, mid - 1, val);
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
