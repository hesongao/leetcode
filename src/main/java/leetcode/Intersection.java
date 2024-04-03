package leetcode;

import java.util.*;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 *
 * 349. 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的
 * 交集
 *  。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int a = 0;
        int b = 0;
        List<Integer> list = new ArrayList();
        while(a < nums1.length && b < nums2.length){
            if(nums1[a] > nums2[b]){
                b++;
            }else if(nums1[a] < nums2[b]){
                a++;
            }else{
                list.add(nums1[a]);
                a++;
                b++;
                while(a > 0 && a < nums1.length && nums1[a] == nums1[a-1]){
                    a++;
                }
                while(b > 0 && b < nums2.length && nums2[b] == nums2[b-1]){
                    b++;
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        int[] res;
        if(nums1.length > nums2.length){
            res = getIntersection(nums2, nums1);
        }else{
            res = getIntersection(nums1, nums2);
        }
        return res;
    }
    public int[] getIntersection(int[] nums1, int[] nums2){
        HashSet<Integer> set = new HashSet();
        HashSet<Integer> set2 = new HashSet();
        for(int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++){
            if(set2.contains(nums1[i])){
                set.add(nums1[i]);
            }
        }
        int[] res = new int[set.size()];
        Iterator it = set.iterator();
        int i = 0;
        while(it.hasNext()){
            res[i++] = (int)it.next();
        }
        return res;

    }
}
