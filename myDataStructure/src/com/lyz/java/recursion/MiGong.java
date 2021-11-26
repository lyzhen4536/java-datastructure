package com.lyz.java.recursion;

/**
 * @author yuan
 * @date 2021/11/14 下午4:00
 */


public class MiGong {
    public static void main(String[] args) {
        int[][] init = init(7, 8);
        show(init);
        init[3][1] = 1;
        init[3][2] = 1;
        boolean way = isWay(init, 1, 1);
        System.out.println("way = " + way);
        show(init);
    }

    public static int[][] init(int row, int column) {
        int[][] arr = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || i == row - 1) {
                    arr[i][j] = 1;
                }
                if (j == 0 || j == column - 1) {
                    arr[i][j] = 1;
                }
            }
        }
        return arr;
    }

    public static void show(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static boolean isWay(int[][] arr, int startRow, int startColumn) {
        if (arr[arr.length - 2][arr[0].length - 2] == 2) {
            return true;
        } else {
            if (arr[startRow][startColumn] == 0) {
                arr[startRow][startColumn] = 2;
                if (isWay(arr, startRow - 1, startColumn)) {
                    return true;
                } else if (isWay(arr, startRow, startColumn - 1)) {
                    return true;
                } else if (isWay(arr, startRow + 1, startColumn )) {
                    return true;
                } else if (isWay(arr, startRow, startColumn + 1)) {
                    return true;
                } else {
                    arr[startRow][startColumn] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
