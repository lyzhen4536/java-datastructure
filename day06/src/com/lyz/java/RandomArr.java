package com.lyz.java;

/**
 * @author yuan
 * @date 2021/10/21 下午9:40
 */


public class RandomArr {
    public static int[] getRandomArr(int num){
        int [] arr = new int [num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*num);
        }
        return arr;
    }
}
