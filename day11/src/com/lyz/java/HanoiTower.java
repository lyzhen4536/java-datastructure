package com.lyz.java;

/**
 * @author yuan
 * @date 2021/11/6 上午11:16
 */


public class HanoiTower {
    static int len;
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
        System.out.println(len);
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            hanoiTower(num - 1, b, a, c);
        }
        len++;
    }
}
