package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 * 350. 两个数组的交集 II
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 */
public class Intersect {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int a = 0;
            int b = 0;
            List<Integer> list = new ArrayList();
            while (a < nums1.length && b < nums2.length) {
                if (nums1[a] < nums2[b]) {
                    a++;
                } else if (nums1[a] > nums2[b]) {
                    b++;
                } else {
                    list.add(nums1[a]);
                    a++;
                    b++;
                }
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }

            return res;
        }
    }
}
