package com.lyz.java.search;

/**
 * @author yuan
 * @date 2021/11/16 下午5:20
 */


public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
        int i = insertValueSearch(arr, 0, arr.length - 1, 1000);
        System.out.println(i);
    }

    public static int insertValueSearch(int[] arr, int left, int right, int val) {
        if (left > right || val < arr[0] || val > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (val - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (val > midVal) {
            return insertValueSearch(arr, mid + 1, right, val);
        } else if (val < midVal) {
            return insertValueSearch(arr, left, mid - 1, val);
        } else {
            return mid;
        }
    }
}
