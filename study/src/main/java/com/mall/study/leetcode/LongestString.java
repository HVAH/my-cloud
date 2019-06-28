package com.mall.study.leetcode;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *              示例：
 *              给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 *              给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 *              给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 * @Author HuangJiang
 * @Date 2018/8/7 18:18
 * @Version 1.0
 **/
public class LongestString {
    public static void main(String[]args){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(getLongestString("pwwkew"));
        stopWatch.stop();
        System.out.println(stopWatch.getTime());
    }

    /**
     * 思路,利用HashMap甄别重复字串,
     *
     * @param
     * @return
     */
    public static int getLongestString(String s) {
        int l = 0,r  = -1, result = 0;
        int[] t = new int[256];
        char[] chars = s.toCharArray();
        while(r + 1 < chars.length) {
            if( t[chars[r+1]] == 0)
                t[chars[++r]]++;
            else t[chars[l++]]--;
            result = Math.max(r-l+1,result);
        }
        return result;
    }
}
