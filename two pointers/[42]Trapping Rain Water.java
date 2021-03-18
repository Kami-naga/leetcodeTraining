//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it can trap after raining.
//
//
// Example 1:
//
//
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are
// being trapped.
//
//
// Example 2:
//
//
//Input: height = [4,2,0,3,2,5]
//Output: 9
//
//
//
// Constraints:
//
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Related Topics 栈 数组 双指针 动态规划
// 👍 2160 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        //use 2 pointer tosolve the problem! no extra space needed!
        if(height == null || height.length < 3) return 0;
        int L = 1;
        int R = height.length - 2;
        int lMax = height[0];
        int rMax = height[height.length - 1];
        int V = 0;
        while(L <= R){
            if(lMax <= rMax){
                V += Math.max(lMax - height[L], 0);
                lMax = Math.max(lMax, height[L++]);
            }else{
                V += Math.max(rMax - height[R], 0);
                rMax = Math.max(rMax, height[R--]);
            }
        }
        return V;
        // we can use only 1 array which stores the max value from right
//        if(height == null || height.length < 3) return 0;
//        int[] rMaxArray = new int[height.length];
//        rMaxArray[height.length - 1] = height[height.length - 1];
//        for(int i=height.length - 2; i >= 0; --i){
//            rMaxArray[i] = Math.max(rMaxArray[i+1], height[i]);
//        }
//        int V = 0;
//        int lMax = height[0];
//        for(int i=1; i< height.length - 1; ++i){
//            V += Math.max(Math.min(lMax, rMaxArray[i]) - height[i], 0);
//            lMax = Math.max(lMax, height[i]);
//        }
//        return V;
        // 2 arrays are used to store the max values from left&right
//        if(height == null || height.length < 3) return 0;
//        int[] lMaxArray = new int[height.length];
//        lMaxArray[0] = height[0];
//        for(int i=1; i < lMaxArray.length; ++i){
//            lMaxArray[i] = Math.max(lMaxArray[i-1], height[i]);
//        }
//        int[] rMaxArray = new int[height.length];
//        rMaxArray[height.length - 1] = height[height.length - 1];
//        for(int i=height.length - 2; i >= 0; --i){
//            rMaxArray[i] = Math.max(rMaxArray[i+1], height[i]);
//        }
//        int V = 0;
//        for(int i=1; i< height.length - 1; ++i){
//            V += Math.max(Math.min(lMaxArray[i], rMaxArray[i]) - height[i], 0);
//        }
//        return V;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
