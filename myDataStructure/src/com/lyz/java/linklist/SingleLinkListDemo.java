package com.lyz.java.linklist;

/**
 * @author yuan
 * @date 2021/11/12 下午7:07
 */


public class SingleLinkListDemo {
    public static void main(String[] args) {
        SingleHeroNode node1 = new SingleHeroNode(1, 111);
        SingleHeroNode node2 = new SingleHeroNode(2, 222);
        SingleHeroNode node3 = new SingleHeroNode(3, 333);
        SingleHeroNode node4 = new SingleHeroNode(4, 444);
        SingleHeroNode node5 = new SingleHeroNode(6, 666);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        node1.addLast(node2);
        node1.addLast(node3);
        node1.addLast(node4);
        node1.addLast(node5);
        node1.show();
        node1.add(new SingleHeroNode(5,555));
        node1.show();
        node1.delNode(2);
        node1.show();

    }
}

class SingleHeroNode {
    public int ID;
    public int data;
    SingleHeroNode next;

    public SingleHeroNode(int data, int ID) {
        this.data = data;
        this.ID = ID;
    }

    public void add(SingleHeroNode node) {
        SingleHeroNode temp;
        SingleHeroNode head = this;
        if (this.next == null) {
            this.next = node;
            return;
        }
        while (head.next != null) {
            if (this.next.ID < node.ID) {
                temp = head.next;
                head.next = node;
                node.next = temp;
                break;
            }
            head = head.next;
        }
    }

    @Override
    public String toString() {
        return "SingleHeroNode{" +
                "data=" + data +
                ", ID=" + ID +
                '}';
    }

    public void addLast(SingleHeroNode node) {
        SingleHeroNode head = this;
        if (this.next == null) {
            this.next = node;
            return;
        }
        while (head.next != null) {
            head = head.next;
        }
        head.next = node;
    }

    public void update(SingleHeroNode node) {
        SingleHeroNode head = this;
        if (this.next == null) {
            System.out.println("空！");
            return;
        }
        while (head.next != null) {
            if (head.next.ID == node.ID) {
                head.next.data = node.data;
            }
            head = head.next;
        }
    }

    public void delNode(int val) {
        SingleHeroNode head = this;
        if (this.data == val && this.next == null) {
            head = null;
            return;
        }
        while (head.next != null) {
            if (head.next.data == val) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
    }

    public void show() {
        SingleHeroNode head = this;
        if (head == null) {
            System.out.println("空！");
        }
        while (head.next != null) {
            System.out.print(head + "-> ");
            head = head.next;
        }
        System.out.println(head);
    }
}
