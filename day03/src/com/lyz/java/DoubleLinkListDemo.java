package com.lyz.java;

/**
 * @author yuan
 * @date 2021/10/18 下午2:21
 */


public class DoubleLinkListDemo {
    public static void main(String[] args) {
        DoubleLinkList list = new DoubleLinkList();
        list.add(new HeroNode(1,"lyz","a"));
        list.add(new HeroNode(2,"lyg","b"));
        list.add(new HeroNode(4,"lys","d"));
        list.add(new HeroNode(5,"lyc","e"));
        list.add(new HeroNode(6,"lyk","f"));
        list.list();

        System.out.println("#################################");
        list.update(new HeroNode(2,"lllll","a"));
        list.list();

        System.out.println("##############################");
        list.del(6);
        list.list();
    }
}

class DoubleLinkList{
    private HeroNode head = new HeroNode(0,"","");

    public void del(int no){
        HeroNode temp = head.next;
        if (temp == null)
            return;
        while (true){
            if (temp == null)
                break;
            if (temp.no == no){
                temp.pre.next = temp.next;
                if (temp.next != null)
                    temp.next.pre = temp.pre;
            }
            temp = temp.next;
        }
    }

    public void update(HeroNode heroNode){
        HeroNode temp = head.next;
        if (temp == null)
            return;
        while (true){
            if (temp == null)
                break;
            if (temp.no == heroNode.no){
                temp.name = heroNode.name;
                temp.nickName = heroNode.nickName;
            }
            temp = temp.next;
        }
    }

    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if (temp.next == null)
                break;
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public HeroNode getHead() {
        return head;
    }

    public void list(){
        HeroNode temp = head.next;
        if (temp == null) {
            return;
        }
        while (true){
            if (temp == null)
                break;
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
    public HeroNode pre;

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


