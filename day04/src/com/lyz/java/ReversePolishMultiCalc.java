package com.lyz.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author yuan
 * @date 2021/10/19 下午10:23
 */


public class ReversePolishMultiCalc {
    //匹配运算符
    static final String SYMBOL = "\\+|-|\\*|/|\\(|\\)";

    static final String LEFT = "(";
    static final String RIGHT = ")";
    static final String ADD = "+";
    static final String MINUS = "-";
    static final String TIMES = "*";
    static final String DIVISION = "/";

    //优先级
    static final int LEVEL_01 = 1;
    static final int LEVEL_02 = 2;
    static final int LEVEL_HIGH = Integer.MAX_VALUE;

    static Stack<String> stack = new Stack<>();
    static List<String> data = Collections.synchronizedList(new ArrayList<String>());

    //去除所有空白符号
    public static String replaceAllBlank(String s) {
        return s.replaceAll("\\s+", "");
    }

    //判断是否为数字
    public static boolean isNumber(String s) {
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(s).matches();
    }

    //判断是否是运算符
    public static boolean isSymbol(String s) {
        return s.matches(SYMBOL);
    }

    //匹配运算优先级
    public static int calcLevel(String s) {
        if ("+".equals(s) || "-".equals(s)) {
            return LEVEL_01;
        } else if ("*".equals(s) || "/".equals(s)) {
            return LEVEL_02;
        }
        return LEVEL_HIGH;
    }

    //匹配
    public static List<String> doMatch(String s) throws Exception {
        if (s == null || "".equals(s.trim())) throw new RuntimeException("data is empty");
        if (!isNumber(s.charAt(0) + "")) throw new RuntimeException("data illeagle,start not with a number");
        s = replaceAllBlank(s);

        String each;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isSymbol(s.charAt(i) + "")) {
                each = s.charAt(i) + "";
                if (stack.isEmpty() || LEFT.equals(each) || ((calcLevel(each) > calcLevel(stack.peek())) && calcLevel(each) < LEVEL_HIGH)) {
                    stack.push(each);
                } else if (!stack.isEmpty() && calcLevel(each) <= calcLevel(stack.peek())) {
                    while (!stack.isEmpty() && calcLevel(each) <= calcLevel(stack.peek())) {
                        if (calcLevel(stack.peek()) == LEVEL_HIGH) {
                            break;
                        }
                        data.add(stack.pop());
                    }
                    stack.push(each);
                } else if (RIGHT.equals(each)) {
                    while (!stack.isEmpty() && LEVEL_HIGH >= calcLevel(stack.peek())) {
                        if (LEVEL_HIGH == calcLevel(stack.peek())) {
                            stack.pop();
                            break;
                        }
                        data.add(stack.pop());
                    }
                }
                start = i;
            } else if (i == s.length() - 1 || isSymbol(s.charAt(i + 1) + "")) {
                each = start == 0 ? s.substring(start, i + 1) : s.substring(start + 1, i + 1);
                if (isNumber(each)) {
                    data.add(each);
                    continue;
                }
                throw new RuntimeException("data not match number");
            }
        }
        Collections.reverse(stack);
        data.addAll(new ArrayList<>(stack));
        System.out.println(data);
        return data;
    }

    //计算结果
    public static Double doCalc(List<String> list){
        Double d = 0d;
        if(list == null || list.isEmpty()){
            return null;
        }
        if(list.size() == 1){
            System.out.println(list);
            d = Double.valueOf(list.get(0));
            return d;
        }
        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list1.add(list.get(i));
            if(isSymbol(list.get(i))){
                Double d1 = doTheMath(list.get(i-2),list.get(i-1),list.get(i));
                list1.remove(i);
                list1.remove(i-1);
                list1.set(i-2,d1+"");
                list1.addAll(list.subList(i+1,list.size()));
                break;
            }
        }
        doCalc(list1);
        return d;
    }

    //运算
    public static Double doTheMath(String s1,String s2,String symbol){
        Double result;
        switch (symbol){
            case ADD:
                result = Double.valueOf(s1) + Double.valueOf(s2);
                break;
            case MINUS:
                result = Double.valueOf(s1) - Double.valueOf(s2);
                break;
            case TIMES:
                result = Double.valueOf(s1) * Double.valueOf(s2);
                break;
            case DIVISION:
                result = Double.valueOf(s1) / Double.valueOf(s2);
                break;
            default:
                result = null;
        }
        return result;
    }

    public static void main(String[] args) {
        String math = "12.8 + (2-3.55)*4+10/5.0";
        try{
            doCalc(doMatch(math));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
