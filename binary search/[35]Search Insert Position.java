//Given a sorted array of distinct integers and a target value, return the index
// if the target is found. If not, return the index where it would be if it were i
//nserted in order.
//
//
// Example 1:
// Input: nums = [1,3,5,6], target = 5
//Output: 2
// Example 2:
// Input: nums = [1,3,5,6], target = 2
//Output: 1
// Example 3:
// Input: nums = [1,3,5,6], target = 7
//Output: 4
// Example 4:
// Input: nums = [1,3,5,6], target = 0
//Output: 0
// Example 5:
// Input: nums = [1], target = 0
//Output: 0
//
//
// Constraints:
//
//
// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums contains distinct values sorted in ascending order.
// -104 <= target <= 104
//
// Related Topics 数组 二分查找
// 👍 850 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int L = 0;
        int R = nums.length - 1;
        //java 中变量在循环外声明不会使其更好，所以根据哪里用丢哪里的原则（域更清晰）丢进循环里更好
        //int M = 0;
        while(L < R){
            int M = L + ((R - L) >> 1);
            if(nums[M] == target){
                return M;
            }
            else if(nums[M] > target){
                R = M - 1;
            }else{
                L = M + 1;
            }
        }
        if(nums[L] >= target) return L;
        else  return L + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
