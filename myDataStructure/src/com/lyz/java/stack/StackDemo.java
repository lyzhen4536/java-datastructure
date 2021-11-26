package com.lyz.java.stack;

/**
 * @author yuan
 * @date 2021/11/13 下午11:55
 */


public class StackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.show();
        System.out.println();
        int pop = stack.pop();
        System.out.println(pop);
        stack.show();
    }
}

class ArrayStack {
    private int maxSize;
    private int top;
    private int[] arr;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("空！");
        }
        int val = arr[top];
        arr[top] = 0;
        top--;
        return val;
    }

    public void push(int val) {
        if (isFull()) {
            System.out.println("满！");
            return;
        }
        top++;
        arr[top] = val;
    }

    public void show() {
        for (int i = 0; i < maxSize; i++) {
            if (arr[i] != 0) {
                System.out.print(arr[i] + "-> ");
            }
        }
    }


}
