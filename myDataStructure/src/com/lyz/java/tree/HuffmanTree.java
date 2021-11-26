package com.lyz.java.tree;


import java.util.ArrayList;
import java.util.Collections;

/**
 * @author yuan
 * @date 2021/11/5 上午9:40
 */


public class HuffmanTree {
    public static Node root;

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 8, 2, 0, 7};
        Node huffmanTree = createHuffmanTree(arr);
        huffmanTree.infixOrder();
    }

    public static void infixOrder() {
        if (root == null) {
            System.out.println("树为空！");
        } else {
            root.infixOrder();
        }
    }

    public static Node createHuffmanTree(int[] arr) {
        ArrayList<Node> list = new ArrayList<>();
        for (int value : arr) {
            list.add(new Node(value));
        }
        Collections.sort(list);
        System.out.println(list);
        while (list.size() > 1) {
            Node left = list.get(0);
            Node right = list.get(1);
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;
            list.remove(left);
            list.remove(right);
            list.add(parent);
            Collections.sort(list);
        }
        return list.get(0);
    }
}
