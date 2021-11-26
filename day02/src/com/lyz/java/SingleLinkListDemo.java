package com.lyz.java;

import java.util.Stack;

/**
 * @author yuan
 * @date 2021/10/13 下午4:44
 */


public class SingleLinkListDemo {
    public static void main(String[] args) {
//        SingleLinkList list = new SingleLinkList();
//        list.add(new HeroNode(1,"lyz","a"));
//        list.add(new HeroNode(2,"lyg","b"));
//        list.add(new HeroNode(4,"lys","d"));
//        list.add(new HeroNode(5,"lyc","e"));
//        list.add(new HeroNode(6,"lyk","f"));
//        list.list();

//        System.out.println("##############################");
//        list.addByOrder(new HeroNode(3,"lyf","c"));
//        list.addByOrder(new HeroNode(3,"lyf","c"));
//        list.list();

//        System.out.println("##############################");
//        list.update(new HeroNode(2,"lllll","a"));
//        list.list();

//        System.out.println("##############################");
//        list.delete(2);
//        list.list();

//        System.out.println("##############################");
//        int length = list.length();
//        System.out.println("链表长度为： " + length);

//        System.out.println("##############################");
//        Object lastIndexNode = list.getLastIndexNode(2);
//        System.out.println(lastIndexNode);

//        System.out.println("##############################");
//        list.reverse(list.getHead());
//        list.list();

//        System.out.println("##############################");
//        list.reversePrint();
//        System.out.println("##############################");
//        list.list();

        SingleLinkList list1 = new SingleLinkList();
        SingleLinkList list2 = new SingleLinkList();
        list1.add(new HeroNode(1,"lyz","a"));
        list2.add(new HeroNode(2,"lyg","b"));
        list1.add(new HeroNode(4,"lys","d"));
        list2.add(new HeroNode(5,"lyc","e"));
        list1.add(new HeroNode(6,"lyk","f"));

        System.out.println("##############################");

        SingleLinkList singleLinkList = list1.mergeList(list2);

        singleLinkList.list();

    }
}

class SingleLinkList{

    private HeroNode head = new HeroNode(0,"","");

    public SingleLinkList mergeList(SingleLinkList list){
        if (this.head.next == null || list.head.next == null)
            return this.head.next == null ? list : this;
        SingleLinkList singleLinkList = new SingleLinkList();
        HeroNode beforeNode = this.head.next;
        HeroNode afterNode = list.head.next;
        HeroNode temp = singleLinkList.head;
        while (beforeNode != null || afterNode != null){
            if (beforeNode != null && afterNode != null){
                if (beforeNode.no >= afterNode.no){
                    temp.next = afterNode;
                    afterNode = afterNode.next;
                }else {
                    temp.next = beforeNode;
                    beforeNode = beforeNode.next;
                }
            }
            temp = temp.next;
            if (beforeNode == null){
                temp.next = afterNode;
                afterNode = afterNode.next;
            }
            if (afterNode == null){
                temp.next = beforeNode;
                beforeNode = beforeNode.next;
            }
        }
        return singleLinkList;

    }
    /*
    * class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        h = ListNode(-1)
        cur = h

        cur1 = l1
        cur2 = l2

        while cur1 != None and cur2 != None:
            if cur1.val <= cur2.val:
                cur.next = cur1
                cur1 = cur1.next
            else:
                cur.next = cur2
                cur2 = cur2.next
            cur = cur.next

        if cur1 != None:
            cur.next = cur1

        if cur2 != None:
            cur.next = cur2
        return h.next
*/

    public HeroNode getHead(){
        return head;
    }

    public void reversePrint(){
        if (head.next == null)
            return;
        HeroNode temp = head.next;
        Stack<HeroNode> stack = new Stack<>();
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0)
            System.out.println(stack.pop());
    }

    /*
    * 创建一个新的头节点，并且将每一个原节点的下一添加到新节点头部的后面
    *
    *
    * */

    public void reverse(HeroNode head){
        if (head.next == null || head.next.next == null)
            return;
        HeroNode reverseNode = new HeroNode(0,"","");
        HeroNode temp = head.next;
        HeroNode next = null;
        while (temp != null){
            next = temp.next;
            temp.next = reverseNode.next;
            reverseNode.next =temp;
            temp = next;
        }
        head.next = reverseNode.next;

    }

    public Object getLastIndexNode(int num){
        HeroNode temp = head.next;
        if (temp == null)
            return null;
        if (num > length() || num < 0)
            return "输入错误！";
        for (int i = 0; i < length() - num; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int length(){
        int len = 0;
        HeroNode temp = head.next;
        if (temp == null)
            return 0;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    public void delete(int no){
        HeroNode temp = head.next;
        if (temp == null){
            System.out.println("链表为空！");
            return;
        }
        while (true){
            if (temp == null){
                System.out.println("当前英雄不存在！");
                break;
            }
            if (temp.next.no == no){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    public void update(HeroNode heroNode){
        HeroNode temp = head.next;
        if (temp == null){
            System.out.println("链表为空！");
            return;
        }
        while (true){
            if (temp == null){
                System.out.println("当前英雄不存在！");
                break;
            }
            if (temp.no == heroNode.no){
                temp.name = heroNode.name;
                temp.nickName = heroNode.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }

        temp.next = heroNode;
    }


    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        if (temp.next == null){
            temp.next = heroNode;
            return;
        }
        boolean flag = false;
        while (true){
            if (temp.next.no > heroNode.no){
                break;
            }else if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("当前节点已存在！");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    public void list(){
        HeroNode temp = head.next;
        if (temp == null){
            return;
        }
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
