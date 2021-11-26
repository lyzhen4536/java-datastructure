package com.lyz.java;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author yuan
 * @date 2021/10/25 下午11:09
 */


public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTree = createHuffmanTree(arr);
        preOrder(huffmanTree);
    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("该赫夫曼树是空树！");
        }
    }

    public static Node createHuffmanTree(int[] arr) {
        ArrayList<Node> list = new ArrayList<>();
        for (int value : arr) {
            list.add(new Node(value));
        }
        Collections.sort(list);
        System.out.println("list= " + list);

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

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {

        return this.value - o.value;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
