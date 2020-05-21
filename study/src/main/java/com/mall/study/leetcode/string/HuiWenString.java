package com.mall.study.leetcode.string;

/**
 * @Description 求一个字符串里包含的最大的回文子串
 * @Author Jiang
 * @Version 1.0
 **/
public class HuiWenString {
    public static void main(String[] args) {
        System.out.println(huiwenStr("cbbbb"));
    }

    private static String huiwenStr (String s) {
        char[] chars = s.toCharArray();
        String result = "";
        int maxLength = 0;
        int b = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++){
            if (i >0 || i < chars.length -1) {
                int thisa = i - 1;
                int thisend = i + 1;
                System.out.println("b=" + thisa + " en = " + thisend);
                while (true) {
                    if ((thisa >= 0 && thisend < chars.length) && (chars[thisa] == chars[thisend] || chars[thisa] == chars[thisend -1])) {
                        thisa--;
                        thisend++;
                    System.out.println("        b=" + thisa + " en = " + thisend);
                    } else {
                        if (thisend - thisa > maxLength) {
                            maxLength = thisend - thisa;
                            b = thisa + 1;
                            end = thisend -1;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("====== b=" + b + " en = " + end);
        return s.substring(b , end +1);
    }

    private static String isHuiwenStr(String s) {
        return "";
    }
}


