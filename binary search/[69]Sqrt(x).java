//Given a non-negative integer x, compute and return the square root of x.
//
// Since the return type is an integer, the decimal digits are truncated, and on
//ly the integer part of the result is returned.
//
//
// Example 1:
//
//
//Input: x = 4
//Output: 2
//
//
// Example 2:
//
//
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since the decimal part is
// truncated, 2 is returned.
//
//
// Constraints:
//
//
// 0 <= x <= 231 - 1
//
// Related Topics 数学 二分查找
// 👍 624 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        int L = 0;
        int R = x;
        int answer = 0;
        while(L <= R){
            int M = L + ((R - L) >> 1);
            if(1L*M*M == x){
                return M;
                // if M is very big , int will overflow, so need 1L to make it become long type
            }else if(1L*M*M > x){
                R = M - 1;
            }else{
                L = M + 1;
                answer = M;
            }
        }
        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
