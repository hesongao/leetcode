package leetcode.array;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class _189_Rotate_M_20260921 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[(i + k) % n] = nums[i];
        }
        System.arraycopy(res, 0, nums, 0, n);
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};

        int k = 3;
        _189_Rotate_M_20260921 clazz = new _189_Rotate_M_20260921();
        System.out.println(Arrays.stream(nums).mapToObj(Objects::toString).collect(Collectors.joining(",", "[", "]")));
    }
}
