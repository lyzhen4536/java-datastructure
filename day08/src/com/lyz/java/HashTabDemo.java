package com.lyz.java;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2021/10/24 下午6:38
 */


public class HashTabDemo {
    public static void main(String[] args) {
//        EmpLinkedList list = new EmpLinkedList();
//        list.add(new Emp(1,"lyz"));
//        list.list();
//        list.update(new Emp(1,"lyc"));
//        list.list();
//        list.del(1);
//        list.list();

        HashTab hashTab = new HashTab(6);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add : 添加雇员");
            System.out.println("list : 显示雇员");
            System.out.println("find : 查找雇员");
            System.out.println("update : 更新信息");
            System.out.println("del : 删除雇员");
            System.out.println("exit : 退出");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入ID： ");
                    int no = scanner.nextInt();
                    System.out.println("输入姓名： ");
                    String name = scanner.next();
                    hashTab.add(new Emp(no, name));
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入ID： ");
                    int id = scanner.nextInt();
                    Emp emp = hashTab.findEmpByID(id);
                    System.out.println(emp);
                    break;
                case "update":
                    System.out.println("输入ID： ");
                    int uno = scanner.nextInt();
                    System.out.println("输入姓名： ");
                    String uName = scanner.next();
                    hashTab.update(new Emp(uno,uName));
                    break;
                case "del":
                    System.out.println("输入ID： ");
                    int dno = scanner.nextInt();
                    hashTab.del(dno);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }


}

class HashTab {
    private int size;
    private EmpLinkedList[] empLinkedLists;

    public HashTab(int size) {
        super();
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public int hashFun(int no){
        return no % size;
    }

    public void add(Emp emp){
        int tempNo = hashFun(emp.no);
        empLinkedLists[tempNo].add(emp);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i + 1);
        }
    }

    public Emp findEmpByID(int no){
        int tempNo = hashFun(no);
        if (empLinkedLists[tempNo].findEmpByID(no) != null){
            System.out.println("第 " + ((no % size) + 1) + " 条链表");
            return empLinkedLists[tempNo].findEmpByID(no);
        }else {
            System.out.println("未找到！");
            return empLinkedLists[tempNo].findEmpByID(no);
        }
    }

    public void update(Emp emp){
        int tempNo = hashFun(emp.no);
        empLinkedLists[tempNo].update(emp);
    }

    public void del(int no){
        int tempNo = hashFun(no);
        empLinkedLists[tempNo].del(no);
    }
}

class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null){
            head = emp;
            return;
        }

        Emp cur = head;

        while (true) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        cur.next = emp;
    }

    public void list(int i) {
        if (head == null) {
            System.out.println("没有这个员工！");
            return;
        }
        Emp cur = head;
        while (true) {
            System.out.println("第 " + i + " 条链表： " + cur);
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
    }

    public Emp findEmpByID(int no){
        if (head.no == no){
            return head;
        }
        Emp temp = head;
        while (true){
            if (temp.no == no){
                break;
            }
            if (temp.next == null){
                temp = null;
                break;
            }
            temp = temp.next;
        }
        return temp;
    }


    public void update(Emp emp) {
        if (head == null) {
            System.out.println("没有这个员工！");
            return;
        }
        Emp cur = head;
        while (true) {
            if (cur.no == emp.no) {
                cur.name = emp.name;
                break;
            }
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
    }

    public void del(int no){
        if (head == null) {
            System.out.println("没有这个员工！");
            return;
        }
        if (head.no == no){
            head = null;
            return;
        }
        Emp cur = head;
        while (true) {
            if (cur.next == null) {
                break;
            }
            if (cur.next.no == no) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }

    }


}

class Emp {
    public int no;
    public String name;
    public Emp next;

    public Emp(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
