package com.lyz.java.search;

/**
 * @author yuan
 * @date 2021/11/16 下午4:27
 */


public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        int search = seqSearch(arr, 1000);
        System.out.println(search);
    }

    public static int seqSearch(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
