package com.lyz.java;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/11/7 下午1:05
 */


public class KnapsackProblem {
    public static void main(String[] args) {

        /*
          这是动态规划问题中的 01 问题
         */

        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500, 3000, 2000}; //物品的价值 这里 val[i] 就是前面讲的 v[i]
        int m = 4; //背包的容量
        int n = val.length; //物品的个数

        int[][] path = new int[n + 1][m + 1];

        int[][] v = new int[n + 1][m + 1];
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        Arrays.fill(v[0], 0);

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
//                System.out.println("begin");
//                System.out.println(j);
//                System.out.println("after");
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
//                    v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i-1][j - w[i - 1]]);
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        for (int[] ints : v) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第 %d 个商品放入背包\n", i);
                j -= w[i - 1];
            }
            i--;
        }


    }
}
