package dayPractice._20261012;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 */
public class _283_MoveZeroes_S {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        for(int i = index;i < nums.length;i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {0,1,0,3,12};
        int[] nums = {1,0,1,0,3,12};
        _283_MoveZeroes_S clazz = new _283_MoveZeroes_S();
        clazz.moveZeroes(nums);
        System.out.println(Arrays.stream(nums).mapToObj(Objects::toString).collect(Collectors.joining(",", "[", "]")));
    }
}
