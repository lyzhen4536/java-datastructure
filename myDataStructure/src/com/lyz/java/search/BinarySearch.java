package com.lyz.java.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2021/11/16 下午4:32
 */


public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
        int search = binarySearch(arr, 0, arr.length - 1, 1000);
        List<Integer> integers = binarySearchList(arr, 0, arr.length - 1, 1000);
        System.out.println(search);
        System.out.println(integers);
    }

    public static int binarySearch(int[] arr, int left, int right, int val) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (val < arr[mid]) {
            return binarySearch(arr, left, mid + 1, val);
        } else if (val == arr[mid]) {
            return mid;
        } else {
            return binarySearch(arr, mid - 1, right, val);
        }
    }

    public static List<Integer> binarySearchList(int[] arr, int left, int right, int val) {
        if (left > right) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int mid = (left + right) / 2;
        if (val < arr[mid]) {
            return binarySearchList(arr, left, mid + 1, val);
        } else if (val == arr[mid]) {
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == val) {
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == val) {
                list.add(temp);
                temp++;
            }
            return list;
        } else {
            return binarySearchList(arr, mid - 1, right, val);
        }
    }
}
