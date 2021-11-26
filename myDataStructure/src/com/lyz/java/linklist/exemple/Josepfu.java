package com.lyz.java.linklist.exemple;


/**
 * @author yuan
 * @date 2021/11/12 下午9:17
 */


public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        int num = 5;
        list.addBoy(num);
        list.show();
        System.out.println();
        long l = System.currentTimeMillis();
        list.countNumber(1,2,num);
        long e = System.currentTimeMillis();
        System.out.println("时间：" + (e - l));
    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    public Boy getBoy(int startNo) {
        Boy temp = first;
        while (true) {
            if (temp.id == startNo){
                return temp;
            }
            temp = temp.next;
        }
    }

    public void countNumber(int startNo, int count, int counts) {
        if (first == null || count < 1 || startNo < 1 || count > counts) {
            System.out.println("输入不合法！");
            return;
        }
        Boy helper = getBoy(startNo);
        Boy cur = null;
        int step = 0;
        while (helper.next != helper) {
            if (step == count - 1) {
                System.out.println(helper);
                helper = cur;
                helper.next = helper.next.next;
                helper = helper.next;
                step = 0;
            } else {
                cur = helper;
                helper = helper.next;
                step++;
            }
        }

        System.out.println(helper.next);

    }

    public void show() {
        if (first == null) {
            System.out.println("空！");
            return;
        }
        Boy cur = first;
        while (true) {
            System.out.println(cur);
            if (cur.next == first) {
                break;
            }
            cur = cur.next;
        }
    }

    public void addBoy(int nums) {
        if (nums < 2) {
            System.out.println("创建失败！");
            return;
        }
        Boy cur = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.next = first;
                cur = first;
            } else {
                if (cur != null) {
                    cur.next = boy;
                }
                boy.next = first;
                cur = boy;
            }

        }
    }

}

class Boy {
    public int id;
    Boy next;

    public Boy(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                '}';
    }
}
