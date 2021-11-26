package com.lyz.java;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2021/10/11 下午9:09
 */


public class CircleArrayQueue {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        boolean flag = true;
        while (flag){
            System.out.println();
            System.out.println("s(show) 现示队列");
            System.out.println("a(add) 添加数据到列");
            System.out.println("d(delete) 删除列");
            System.out.println("h(head) 头部数据");
            System.out.println("e(exit) 退出");
            Scanner scanner = new Scanner(System.in);
            char key = scanner.next().charAt(0);
            System.out.println();
            switch (key){
                case 's':{
                    queue.showQueue();
                    break;
                }
                case 'a':{
                    int num = scanner.nextInt();
                    queue.addQueue(num);
                    break;
                }
                case 'd':{
                    queue.popQueue();
                    break;
                }
                case 'h':{
                    queue.headQueue();
                    break;
                }
                case 'e':{
                    flag = false;
                    break;
                }
            }
        }
    }
}

class ArrayQueue {
    private int maxSize;
    //队尾 默认值 0
    private int rear;
    //队首 默认值 0
    private int front;
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public void addQueue(int num){
        if (isFull()){
            System.out.println("队列已满！");
            return;
        }
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    public int popQueue(){
        if (isEmpty()){
            System.out.println("队列为空！");
            return 0;
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空！");
            return;
        }
        for (int i = 0; i < (rear -front + maxSize) % maxSize; i++) {
            System.out.println(arr[(front+i) % maxSize]);
        }
    }

    public void headQueue(){
        if (isEmpty()){
            System.out.println("队列为空！");
            return;
        }
        System.out.println(arr[front]);
    }


}
