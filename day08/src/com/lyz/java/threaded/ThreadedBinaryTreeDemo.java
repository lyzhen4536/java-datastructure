package com.lyz.java.threaded;

/**
 * @author yuan
 * @date 2021/10/25 下午8:16
 */


public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "lyz");
        HeroNode node2 = new HeroNode(2, "lyx");
        HeroNode node3 = new HeroNode(3, "lyc");
        HeroNode node4 = new HeroNode(4, "lyv");
        HeroNode node5 = new HeroNode(5, "lyb");
        HeroNode node6 = new HeroNode(6, "lyn");
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        tree.setRoot(node1);
        tree.threadedNodes();

        HeroNode left = node5.getLeft();
        System.out.println(left);
        HeroNode right = node5.getRight();
        System.out.println(right);
        tree.threadedList();

    }
}

class ThreadedBinaryTree {
    private HeroNode root;
    private HeroNode pre;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder(){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("根结点为空！");
        }
    }
    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else {
            System.out.println("根结点为空！");
        }
    }
    public void postOrder(){
        if (root != null){
            root.postOrder();
        }else {
            System.out.println("根结点为空！");
        }
    }

    public HeroNode preOrderSearch(int no){
        HeroNode heroNode = this.root.preOrderSearch(no);
        if (heroNode != null){
            return heroNode;
        }else {
            System.out.println("未找到！");
            return null;
        }
    }
    public HeroNode infixOrderSearch(int no){
        HeroNode heroNode = this.root.infixOrderSearch(no);
        if (heroNode != null){
            return heroNode;
        }else {
            System.out.println("未找到！");
            return null;
        }
    }
    public HeroNode postOrderSearch(int no){
        HeroNode heroNode = this.root.postOrderSearch(no);
        if (heroNode != null){
            return heroNode;
        }else {
            System.out.println("未找到！");
            return null;
        }
    }

    public void delNode(int no){
        if (root != null){
            if (root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("root 为空，不能删除！");
        }
    }

    public void threadedNodes(HeroNode node){
        if (node == null){
            return;
        }

        threadedNodes(node.getLeft());

        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;

        threadedNodes(node.getRight());

    }

    public void threadNodesPre(HeroNode node){
        if (node == null){
            return;
        }
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        threadNodesPre(node.getLeft());
        threadNodesPre(node.getRight());
    }

    public void threadedNodes(){
        this.threadedNodes(root);
    }

     public void threadedList(){
        HeroNode node = root;
        while (node != null){
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }

            System.out.println(node);

            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
     }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
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

    public void infixOrder() {
        if (this.left != null) {
            this.left.preOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no) {
        System.out.println(1111);
        if (this.no == no) {
            return this;
        }
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.preOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.preOrderSearch(no);
        }
        return res;
    }

    public HeroNode infixOrderSearch(int no) {
        System.out.println(2222);
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.infixOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            res = this.right.infixOrderSearch(no);
        }
        return res;
    }

    public HeroNode postOrderSearch(int no) {
        System.out.println(3333);
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.postOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.postOrderSearch(no);
        }
        if (this.no == no) {
            return this;
        }
        return res;
    }

    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}

