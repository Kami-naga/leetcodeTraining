//Given n non-negative integers a1, a2, ..., an , where each represents a point
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x
//-axis forms a container, such that the container contains the most water.
//
// Notice that you may not slant the container.
//
//
// Example 1:
//
//
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can conta
//in is 49.
//
//
// Example 2:
//
//
//Input: height = [1,1]
//Output: 1
//
//
// Example 3:
//
//
//Input: height = [4,3,2,1,4]
//Output: 16
//
//
// Example 4:
//
//
//Input: height = [1,2,1]
//Output: 2
//
//
//
// Constraints:
//
//
// n == height.length
// 2 <= n <= 105
// 0 <= height[i] <= 104
//
// Related Topics 数组 双指针
// 👍 2280 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {

//        if(height == null || height.length < 2) return 0;
//        int L = 0;
//        int R = height.length - 1;
//        int maxArea = 0;
//        while(L < R){
//            int newArea = Math.min(height[L], height[R]) * (R - L);
//            maxArea = Math.max(maxArea, newArea);
//            if(height[L] <= height[R]){
//                ++L;
//            }else{
//                --R;
//            }
//        }
//        return maxArea;

//        int L = 0;
//        int R = height.length - 1;
//        int V = Math.min(height[L], height[R]) * R;
//        while(L < R){
//            int leftMax = height[L];
//            int rightMax = height[R];
//            if(leftMax <= rightMax){
//                while(L < R && height[++L] > leftMax){
//                    int newV = Math.min(height[L], rightMax) * (R - L);
//                    if(newV > V){
//                        leftMax = height[L];
//                        V = newV;
//                    }
//                    break;
//                }
//            }else{
//                while(L < R && height[--R] > rightMax){
//                    int newV = Math.min(height[R], leftMax) * (R - L);
//                    if(newV > V){
//                        rightMax = height[R];
//                        V = newV;
//                    }
//                    break;
//                }
//            }
//        }
//        return V;

// 可以学习下下边写法，每次都需要进行area的计算，所以直接循环体里先写着，而不要把必做的步骤丢进条件语句当中
        // 基本的情况是 height 长度 < 2
        if(height.length <= 1)
            return 0;
        // 双指针 i, j
        int i = 0, j = height.length - 1;
        int area = Integer.MIN_VALUE;

        // 只要 i 还比 j 小, 就可以继续计算面积
        while(i < j){
            int newArea = (j - i) * Math.min(height[i], height[j]);
            if(area < newArea){
                area = newArea;
            }
            int k;
            // 如果 height[i] 的值不大于 height[j] 的值，就往后移动到第一个高度大于 height[i] 的点
            if(height[i] <= height[j]){
                for(k = i + 1; k < j && height[k] <= height[i]; k++);
                i = k;
                continue;
            }

            // 当 height[j] < height[i] 时, 同理
            if(height[i] > height[j]){
                for(k = j - 1; k > i && height[k] <= height[j]; k--);
                j = k;
            }
        }
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
