//There are some spherical balloons spread in two-dimensional space. For each ba
//lloon, provided input is the start and end coordinates of the horizontal diamete
//r. Since it's horizontal, y-coordinates don't matter, and hence the x-coordinate
//s of start and end of the diameter suffice. The start is always smaller than the
// end.
//
// An arrow can be shot up exactly vertically from different points along the x-
//axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x
//≤ xend. There is no limit to the number of arrows that can be shot. An arrow onc
//e shot keeps traveling up infinitely.
//
// Given an array points where points[i] = [xstart, xend], return the minimum nu
//mber of arrows that must be shot to burst all balloons.
//
//
// Example 1:
//
//
//Input: points = [[10,16],[2,8],[1,6],[7,12]]
//Output: 2
//Explanation: One way is to shoot one arrow for example at x = 6 (bursting the
//balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two ba
//lloons).
//
//
// Example 2:
//
//
//Input: points = [[1,2],[3,4],[5,6],[7,8]]
//Output: 4
//
//
// Example 3:
//
//
//Input: points = [[1,2],[2,3],[3,4],[4,5]]
//Output: 2
//
//
// Example 4:
//
//
//Input: points = [[1,2]]
//Output: 1
//
//
// Example 5:
//
//
//Input: points = [[2,3],[2,3]]
//Output: 1
//
//
//
// Constraints:
//
//
// 0 <= points.length <= 104
// points[i].length == 2
// -231 <= xstart < xend <= 231 - 1
//
// Related Topics 贪心算法 排序
// 👍 329 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if(len < 2) return len;
        //below code won't through the test. why? consider the border case of integer
        //Arrays.sort(points, (a,b)-> a[1]-b[1]);
        //[[-2147483646,-2147483645],[2147483646,2147483647]] 2's complement & overflow!
        // so + will become -, and sort will go wierd
        //just use the code below instead to avoid the problem
        Arrays.sort(points, (a,b)-> (a[1] > b[1] ? 1 : -1));
        int cnt = 1;
        int before = points[0][1];
        for (int i=1; i<len; ++i){
            if(points[i][0] > before) {
                ++cnt;
                before = points[i][1];
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
