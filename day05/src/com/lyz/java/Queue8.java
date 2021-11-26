package com.lyz.java;

/**
 * @author yuan
 * @date 2021/10/20 下午9:52
 */


public class Queue8 {
    public int max = 8;
    int [] arr = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共 %d 种解法！",count);
    }

    private void check(int n){
        if (n == max){
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        return true;
    }

    private void print(){
        count++;
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
