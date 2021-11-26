package com.lyz.java.tree;

/**
 * @author yuan
 * @date 2021/11/24 下午10:26
 */


public class AVLTreeDemo {
    public static void main(String[] args) {
//        int[] arr = { 10, 11, 7, 6, 8, 9 };
//        int[] arr = {4, 3, 6, 5, 7, 8};
        int[] arr = {10, 12, 8, 9, 7, 6};
        Node root = new Node(0);
        for (int i : arr) {
            root.add(new Node(i));
        }
        System.out.println("infixOrder");
        root.infixOrder();
        System.out.println("没有左旋转前");
        System.out.println("树的高度： " + root.height());
        System.out.println("树左子树的高度： " + root.leftHeight());
        System.out.println("树右子树的高度： " + root.rightHeight());
    }
}