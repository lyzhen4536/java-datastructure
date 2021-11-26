package com.lyz.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yuan
 * @date 2021/10/19 下午7:55
 */


public class PolandNotation {
    public static void main(String[] args) {
//        String exp = "3 4 + 5 * 6 -";
//        List<String> listString = getListString(exp);
//        System.out.println(listString);
//        int cal = cal(listString);
//        System.out.println(cal);

        String express = "1+((2+3)*4)-5";
        List<String> strings = toInfixExpression(express);
        System.out.println(strings);
        List<String> list = parseSuffixExpressionList(strings);
        System.out.println(list);

        System.out.println(cal(list));
    }

    public static List<String> parseSuffixExpressionList(List<String> ls){
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();

        for (String item: ls){
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.add(item);
            }
        }

        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }

    public static List<String> toInfixExpression(String s){
        ArrayList<String> ls = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                ls.add("" + c);
                i++;
            }else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while (i < s.length());

        return ls;
    }


    public static List<String> getListString(String exp){
        String[] split = exp.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String ele: split){
            list.add(ele);
        }
        return list;
    }

    public static int cal(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String item: list){
            if (item.matches("\\d+")){
                stack.push(item);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;

                if (item.equals("+")){
                    res = num1 + num2;
                }else if (item.equals("-")){
                    res = num1 - num2;
                }else if (item.equals("*")){
                    res = num1 * num2;
                }else if (item.equals("/")){
                    res = num1 / num2;
                }else{
                    throw new RuntimeException("处理有误！");
                }

                stack.push(res + "");
            }
        }

        return Integer.parseInt(stack.pop());
    }
}


class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String s){
        int res = 0;
        switch (s){
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                break;
        }
        return res;
    }
}
