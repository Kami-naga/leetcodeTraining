//Given an array nums with n integers, your task is to check if it could become
//non-decreasing by modifying at most 1 element.
//
// We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for ever
//y i (0-based) such that (0 <= i <= n - 2).
//
//
// Example 1:
//
//
//Input: nums = [4,2,3]
//Output: true
//Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
//
//
// Example 2:
//
//
//Input: nums = [4,2,1]
//Output: false
//Explanation: You can't get a non-decreasing array by modify at most one elemen
//t.
//
//
//
// Constraints:
//
//
// 1 <= n <= 10 ^ 4
// - 10 ^ 5 <= nums[i] <= 10 ^ 5
//
// Related Topics 数组
// 👍 402 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPossibility(int[] nums) {
        //greedy: make nums[i] min!
        int len = nums.length;
        if(len<3) return true;
        int cnt = 0;
        for(int i=0; i<len-1; ++i) {
            //if find decsending part, do something
            if (nums[i+1] < nums[i]) {
                //change at most 1 element, so if more than 1 time, just return false
                if (cnt >= 1) return false;
                else{// change 1 element part
                    //2 changing approaches:change former one to latter or latter to former
                    //it's better to change latter to former in almost situations
                    //but in situations like [3,3,2,4],
                    // 3->2[3,2,2,4] still should false,
                    // but 2->[3,3,3,4] can be true
                    //so we should check the element before the current one
                    if(i==0) nums[i] = nums[i+1];
                    else if(nums[i-1] <= nums[i+1]) nums[i] = nums[i+1];
                    else nums[i+1] = nums[i];
                }
                ++cnt;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
