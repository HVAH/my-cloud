package com.mall.study.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *              你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用
 *              给定 nums = [2, 7, 11, 15], target = 9
 *              因为 nums[0] + nums[1] = 2 + 7 = 9
 *              所以返回 [0, 1]fasfasdfasdf
 * @Author HuangJiang
 * @Date 2018/8/2 18:00
 * @Version 1.0
 **/
public class TwoSum {
    public static void main(String[]args){
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] sum = twoSum(arr, 15);
        System.out.println(Arrays.toString(sum));
        System.out.println(Arrays.toString(twoSum2(arr, 15)));
    }

    /**
     * 暴力遍历
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count ++;
                if (target == (nums[i] + nums[j])) {
                    System.out.println("循环 " + count + " 次");
                    return new int[] {nums[i], nums[j]};
                }
            }
        }
        return new int []{};
    }

    /**
     * 一次遍历,利用set,加入的同时,在集合里查找 x = target - nums[i]
     * @param nums
     * @param target
     * @return
     */
    public static int [] twoSum2(int [] nums, int target) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            count ++;
           set.add(nums[i]);
           if (set.contains(target - nums[i]) && nums[i] * 2 != target) {
               System.out.println("循环 " + count + " 次");
               return new int[] {nums[i], target- nums[i]};
           }
        }
        return new int []{};
    }

}
