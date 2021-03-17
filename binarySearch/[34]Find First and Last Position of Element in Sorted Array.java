//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value.
//
// If target is not found in the array, return [-1, -1].
//
// Follow up: Could you write an algorithm with O(log n) runtime complexity?
//
//
// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3:
// Input: nums = [], target = 0
//Output: [-1,-1]
//
//
// Constraints:
//
//
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109
//
// Related Topics 数组 二分查找
// 👍 899 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int F = getFirstIndex(nums, target);
        int L = getLastIndex(nums, target);

        if((F != -1) && (L != -1) && nums[F] == target && nums[L]== target) return new int[]{F, L};
        else return new int[]{-1, -1};
    }

    public int getLastIndex(int[] nums, int target){
        int L = 0;
        int R = nums.length - 1;
        int M = 0;
        int index = -1;
        while(L <= R){
            M = L + ((R - L) >> 1);
            if(nums[M] > target){
                R = M - 1;
            }else{ //左侧边界向右缩，找到last
                L = M + 1;
                index = M;
            }
        }
        return index;
    }

    public int getFirstIndex(int[] nums, int target){
        int L = 0;
        int R = nums.length - 1;
        int M = 0;
        int index = -1;
        while(L <= R){
            M = L + ((R - L) >> 1);
            if(nums[M] >= target){//右侧边界向左缩，找到first
                R = M - 1;
                index = M;
            }else{
                L = M + 1;
            }
        }
        return index;
    }

    // official solution
    // reuse the search function to get both left index& right index
    // key: rightIdx = reult - 1; and control "= target" condition
    // in the binary search to get the index pos.
//    public int[] searchRange(int[] nums, int target) {
//        int leftIdx = binarySearch(nums, target, true);
//        int rightIdx = binarySearch(nums, target, false) - 1;
//        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
//            return new int[]{leftIdx, rightIdx};
//        }
//        return new int[]{-1, -1};
//    }
//
//    public int binarySearch(int[] nums, int target, boolean lower) {
//        int left = 0, right = nums.length - 1, ans = nums.length;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] > target || (lower && nums[mid] >= target)) {
//                right = mid - 1;
//                ans = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return ans;
//    }


}
//leetcode submit region end(Prohibit modification and deletion)
