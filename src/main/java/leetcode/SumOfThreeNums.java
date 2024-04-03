package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/1fGaJU/description/
 * LCR 007. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 */
public class SumOfThreeNums {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        int n = nums.length;
        if(n < 3){
            return res;
        }
        Arrays.sort(nums);

        for(int i = 0; i < n-2; i++){
            if(nums[i] > 0){
                return res;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int start = i + 1;
            int end = n - 1;
            while(start < end){
                if(start > i + 1 && nums[start] == nums[start-1]){
                    start++;
                    continue;
                }
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > 0){
                    end--;
                }else if(sum < 0){
                    start++;
                }else{
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    res.add(list);
                    start++;
                    end--;
                }
            }
        }

        return res;
    }
}
