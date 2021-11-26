package com.lyz.java;

/**
 * @author yuan
 * @date 2021/10/18 下午7:23
 */


public class StackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.show();
        int pop = stack.pop();
        System.out.println(pop);
        stack.show();
    }
}

class ArrayStack{
    public int maxSize;
    public int top = -1;
    public int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("盏空！");
            throw new RuntimeException("盏空！");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("盏满！");
            return;
        }
        top++;
        stack[top] = value;
    }

    public void show(){
        if (isEmpty()){
            System.out.println("盏空！");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d \n",i,stack[i]);
        }
    }
}
