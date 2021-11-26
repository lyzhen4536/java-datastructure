package com.lyz.java.tree;

/**
 * @author yuan
 * @date 2021/11/5 上午9:40
 */


public class Node implements Comparable<Node> {
    public Byte data;
    public int value;
    public Node left;
    public Node right;

    public Node(Byte data, int value) {
        this.data = data;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", value=" + value +
                '}';
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (left == null) {
                left = node;
            } else {
                left.add(node);
            }
        } else {
            if (right == null) {
                right = node;
            } else {
                right.add(node);
            }
        }

        if (rightHeight() - leftHeight() > 1) {
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
            return;
        }

        if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftHeight();
                rightRotate();
            } else {
                rightRotate();
            }
        }
    }

    public Node search(int val) {
        if (value == val) {
            return this;
        } else if (value < val) {
            if (right == null) {
                return null;
            }
            return right.search(val);
        } else {
            if (left == null) {
                return null;
            }
            return left.search(val);
        }
    }

    public Node searchParent(int val) {
        if ((left != null && left.value == val) || (right != null && right.value == val)) {
            return this;
        } else {
            if (left != null && value > val) {
                return left.searchParent(val);
            } else if (right != null && value <= val) {
                return right.searchParent(val);
            } else {
                return null;
            }
        }
    }


    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
    }

    private void leftRotate() {
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;
    }

    public void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

}
