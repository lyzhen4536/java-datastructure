package com.lyz.java;

/**
 * @author yuan
 * @date 2021/10/24 下午9:06
 */


public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        HeroNode node1 = new HeroNode(1, "lyz");
        HeroNode node2 = new HeroNode(2, "lyx");
        HeroNode node3 = new HeroNode(3, "lyc");
        HeroNode node4 = new HeroNode(4, "lyv");
        HeroNode node5 = new HeroNode(5, "lyb");
        tree.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);

//        tree.preOrder();
//        System.out.println();
//
//        tree.infixOrder();
//        System.out.println();
//
//        tree.postOrder();
//        System.out.println();

        HeroNode heroNode = tree.postOrderSearch(5);
        System.out.println(heroNode);
        tree.delNode(5);
        heroNode = tree.postOrderSearch(5);
        System.out.println(heroNode);
    }
}

class BinaryTree {
    private HeroNode root;

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
}

class HeroNode {
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
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
            this.left.preOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.preOrder();
        }
    }
    public void postOrder(){
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no){
        System.out.println(1111);
        if (this.no == no){
            return this;
        }
        HeroNode res = null;
        if (this.left != null){
            res = this.left.preOrderSearch(no);
        }
        if (res != null){
            return res;
        }
        if (this.right != null){
            res = this.right.preOrderSearch(no);
        }
        return res;
    }
    public HeroNode infixOrderSearch(int no){
        System.out.println(2222);
        HeroNode res = null;
        if (this.left != null){
            res = this.left.infixOrderSearch(no);
        }
        if (res != null){
            return res;
        }
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            res = this.right.infixOrderSearch(no);
        }
        return res;
    }
    public HeroNode postOrderSearch(int no){
        System.out.println(3333);
        HeroNode res = null;
        if (this.left != null){
            res = this.left.postOrderSearch(no);
        }
        if (res != null){
            return res;
        }
        if (this.right != null){
            res = this.right.postOrderSearch(no);
        }
        if (this.no == no){
            return this;
        }
        return res;
    }

    public void delNode(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left != null ){
            this.left.delNode(no);
        }
        if (this.right != null ){
            this.right.delNode(no);
        }
    }
}
