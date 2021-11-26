package com.lyz.java.queue;

/**
 * @author yuan
 * @date 2021/11/9 下午6:21
 */


public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(10);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        queue.addQueue(4);
        queue.addQueue(4);
        queue.addQueue(4);
        queue.addQueue(4);
        queue.addQueue(4);
        queue.addQueue(4);
        queue.addQueue(4);
        queue.addQueue(4);
        queue.addQueue(4);
        queue.addQueue(4);
        queue.addQueue(4);
        queue.addQueue(4);
        queue.addQueue(4);
        queue.showQueue();
        System.out.println();
        queue.popQueue();
        queue.showQueue();
    }
}

class CircleQueue {
    private int front;
    private int rear;
    private int[] arr;
    private int maxSize;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void popQueue() {
        if (!isEmpty()) {
            arr[front] = 0;
            front = (front+1) % maxSize;
        }
    }

    public void addQueue(int val) {
        if (!isFull()) {
            arr[rear] = val;
            rear = (rear + 1) % maxSize;
        }
    }
    
    public void showQueue() {
        for (int i = 0; i < (rear - front + maxSize) % maxSize; i++) {
            System.out.print(arr[(front + i) % maxSize] + "-> ");
        }
    }
}
