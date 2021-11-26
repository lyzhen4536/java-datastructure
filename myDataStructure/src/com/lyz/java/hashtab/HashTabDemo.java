package com.lyz.java.hashtab;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2021/11/20 下午10:14
 */


public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入 id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的 id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

class HashTab {
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int hashFun = hashFun(emp.id);
        empLinkedLists[hashFun].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    public void findEmpById(int id) {
        int hashFun = hashFun(id);
        Emp emp = empLinkedLists[hashFun].findEmpById(id);
        if (emp != null) {
            System.out.printf("在第%d 条链表中找到 雇员 id = %d\n", (hashFun + 1), id);
        } else {
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

    public int hashFun(int id) {
        return id % size;
    }

}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
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

    public void list(int no) {
        if (head == null) {
            System.out.println("空！");
            return;
        }
        System.out.print("第 " + (no + 1) + " 链条的信息为：");
        Emp cur = head;
        while (true) {
            System.out.printf(" => id=%d name=%s\t", cur.id, cur.name);
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("空！");
            return null;
        }
        Emp cur = head;
        while (true) {
            if (cur.id == id) {
                break;
            }
            if (cur.next == null) {
                cur = null;
                break;

            }
            cur = cur.next;
        }
        return cur;
    }

}
