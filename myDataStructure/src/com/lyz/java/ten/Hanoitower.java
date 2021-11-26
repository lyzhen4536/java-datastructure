package com.lyz.java.ten;

/**
 * @author yuan
 * @date 2021/11/25 下午7:25
 */


public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第 1 个盘从 " + a + "->" + c);
        } else {
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            hanoiTower(num - 1, b, a, c);
        }
    }
}
