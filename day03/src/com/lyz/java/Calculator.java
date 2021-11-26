package com.lyz.java;

/**
 * @author yuan
 * @date 2021/10/18 下午8:01
 */


public class Calculator {
    public static void main(String[] args) {
        String exp = "130+200*6-2";
        ArrayStackDemo numStack = new ArrayStackDemo(10);
        ArrayStackDemo operateStack = new ArrayStackDemo(10);
        int num1 = 0;
        int num2 = 0;
        int index = 0;
        int res = 0;
        int operate = 0;
        char ch = ' ';
        String keepNum = "";

        while (true){
            ch = exp.substring(index,index+1).charAt(0);
            if (operateStack.isOperate(ch)){
                if (!operateStack.isEmpty()){
                    if (operateStack.priority(ch) <= operateStack.priority(operateStack.peak())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operate = operateStack.pop();
                        res = numStack.cal(num1, num2, operate);
                        numStack.push(res);
                        operateStack.push(ch);
                    }else {
                        operateStack.push(ch);
                    }
                }else {
                    operateStack.push(ch);
                }
            }else {
//                numStack.push(ch - 48);
                keepNum += ch;

                if (index == exp.length() -1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if (operateStack.isOperate(exp.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= exp.length()){
                break;
            }
        }

        while (true){
            if (operateStack.isEmpty())
                break;
            num1 = numStack.pop();
            num2 = numStack.pop();
            operate = operateStack.pop();
            res = numStack.cal(num1, num2, operate);
            numStack.push(res);
        }

        System.out.println(exp + " = " + numStack.pop());

    }
}

class ArrayStackDemo{
    public int maxSize;
    public int top = -1;
    public int[] stack;

    public ArrayStackDemo(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public int peak(){
        return stack[top];
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

    public int priority(int operate){
        if (operate == '*' || operate == '/'){
            return 1;
        }else if (operate == '+' || operate == '-'){
            return 0;
        }else{
            return -1;
        }
    }

    public boolean isOperate(char val){
        return val == '*' || val == '-' ||val == '+' ||val == '/';
    }

    public int cal(int num1, int num2, int operate){
        int res = 0;
        switch (operate){
            case '*':
                res = num1 * num2;
                break;

            case '/':
                res = num2 / num1;
                break;

            case '+':
                res = num1 + num2;
                break;

            case '-':
                res = num2 - num1;
                break;

            default:
                break;
        }
        return res;
    }
}
