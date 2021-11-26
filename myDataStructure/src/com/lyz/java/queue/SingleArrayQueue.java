package com.lyz.java.queue;

/**
 * @author yuan
 * @date 2021/11/12 下午3:12
 */


public class SingleArrayQueue {
    public static void main(String[] args) {
        SingleQueue queue = new SingleQueue(16);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        queue.addQueue(4);
        queue.showQueue();
        System.out.println();
        int val = queue.popQueue();
        System.out.println(val);
        queue.showQueue();

    }
}

class SingleQueue {
    private int maxSize;
    //队首
    private int front;
    //队尾
    private int rear;
    private int[] arr;

    public SingleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void addQueue(int val) {
        if (!isFull()) {
            arr[rear] = val;
            rear++;
        }
    }

    public int popQueue() {
        if (isEmpty()) {
            return 0;
        }
        int val = arr[front];
        arr[front] = 0;
        front++;
        return val;
    }

    public void showQueue() {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                System.out.print(arr[i] + "-> ");
            }
        }
    }
}
