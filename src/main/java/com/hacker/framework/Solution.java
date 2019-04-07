package com.hacker.framework;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution {

    public static int kthLargestElement(int n, int[] nums) {
        // write your code here
        Set<Integer> sets = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            sets.add(nums[i]);
        }

        List<Integer> lists = new ArrayList<>(sets);
        lists.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        return lists.get(lists.size() - n);
    }


    public static void main(String[] args) {
        int i = kthLargestElement(6, new int[]{5, 9, 6, 3, 5, 2, 1, 7, 45, 12, 14, 78});
        System.out.println(i);
    }
}