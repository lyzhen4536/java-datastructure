package com.lyz.java;

/**
 * @author yuan
 * @date 2021/10/18 下午3:22
 */


public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        int num = 5;
        list.addBoy(num);
        list.list();
        System.out.println("############################");
        long l = System.currentTimeMillis();
        list.countNumber(1,2,num);
        long e = System.currentTimeMillis();
        System.out.println("时间：" + (e - l));
    }
}

class CircleSingleLinkedList{
    private Boy first = null;

    public void countNumber(int startNo, int countNum, int nums){
        if (first == null || startNo < 1 || countNum > nums){
            System.out.println("输入不合法！");
            return;
        }
        Boy helper = first;
        while (true){
            if (helper.getNext() == first)
                break;
            helper = helper.getNext();
        }

        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true){
            if (helper == first)
                break;

            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first);
            first = first.getNext();
            helper.setNext(first);
        }

        System.out.println(first);

    }

    public void list(){
        if (first == null){
            System.out.println("链表为空！");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.println(curBoy);
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    public void addBoy(int nums){
        if (nums < 2){
            System.out.println("添加失败！");
            return;
        }
        Boy curBoy = null;
        for (int i = 0; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else {
                if (curBoy != null) {
                    curBoy.setNext(boy);
                }
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

}

class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
