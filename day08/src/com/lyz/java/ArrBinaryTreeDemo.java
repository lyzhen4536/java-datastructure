package com.lyz.java;

/**
 * @author yuan
 * @date 2021/10/25 下午7:49
 */


public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.infixOrder(0);
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public boolean isEmpty(int[] arr) {
        return arr == null || arr.length == 0;
    }

    public void preOrder(int index) {
        if (isEmpty(arr)) {
            System.out.println("数组为空！");
            return;
        }
        System.out.println(arr[index]);
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }

        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    public void infixOrder(int index) {
        if (isEmpty(arr)) {
            System.out.println("数组为空！");
            return;
        }
        if ((index * 2 + 1) < arr.length) {
            infixOrder(index * 2 + 1);
        }
        System.out.println(arr[index]);

        if ((index * 2 + 2) < arr.length) {
            infixOrder(index * 2 + 2);
        }
    }

    public void postOrder(int index) {
        if (isEmpty(arr)) {
            System.out.println("数组为空！");
            return;
        }

        if ((index * 2 + 1) < arr.length) {
            postOrder(index * 2 + 1);
        }

        if ((index * 2 + 2) < arr.length) {
            postOrder(index * 2 + 2);
        }
        System.out.println(arr[index]);

    }
}
