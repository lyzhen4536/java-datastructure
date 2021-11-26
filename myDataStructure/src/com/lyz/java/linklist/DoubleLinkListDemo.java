package com.lyz.java.linklist;

/**
 * @author yuan
 * @date 2021/11/12 下午8:07
 */


public class DoubleLinkListDemo {
    public static void main(String[] args) {
        DoubleHeroNode node1 = new DoubleHeroNode(1, 111);
        DoubleHeroNode node2 = new DoubleHeroNode(2, 222);
        DoubleHeroNode node3 = new DoubleHeroNode(3, 333);
        DoubleHeroNode node4 = new DoubleHeroNode(4, 444);
        DoubleHeroNode node5 = new DoubleHeroNode(5, 555);
        DoubleHeroNode node6 = new DoubleHeroNode(6, 666);
        node1.add(node2);
        node1.add(node3);
        node1.add(node4);
        node1.add(node5);
        node1.add(node6);
        node1.show();
        System.out.println();
        node1.update(new DoubleHeroNode(6, 777));
        node1.show();
        System.out.println();
        node1.delNode(6);
        node1.show();
    }
}

class DoubleHeroNode {
    public int id;
    public int data;
    DoubleHeroNode pre;
    DoubleHeroNode next;

    public DoubleHeroNode(int id, int data) {
        this.id = id;
        this.data = data;
    }

    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }

    public void add(DoubleHeroNode node) {
        DoubleHeroNode head = this;
        if (head.next == null) {
            head.next = node;
            node.pre = head;
            return;
        }
        while (head.next != null) {
            head = head.next;
        }
        head.next = node;
        node.pre = head;
    }

    public void update(DoubleHeroNode node) {
        DoubleHeroNode head = this;
        if (head.next == null || head.id == node.id) {
            head.data = node.data;
            return;
        }
        while (head.next != null) {
            if (head.next.id == node.id) {
                head.next.data = node.data;
                break;
            }
            head = head.next;
        }
    }

    public void delNode(int id) {
        DoubleHeroNode head = this;
        if (head.id == id) {
            head = null;
            return;
        }
        while (head.next != null) {
            if (head.next.id == id) {
                head.next = head.next.next;
                if (head.next != null) {
                    head.next.pre = head.pre;
                }
                break;
            }
            head = head.next;
        }

    }

    public void show() {
        DoubleHeroNode head = this;
        if (head == null) {
            System.out.println("空！");
            return;
        }
        System.out.print(head);
        while (head.next != null) {
            head = head.next;
            System.out.print(head);
        }
    }


}
