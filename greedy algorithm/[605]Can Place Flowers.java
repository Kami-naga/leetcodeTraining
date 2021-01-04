//You have a long flowerbed in which some of the plots are planted, and some are
// not. However, flowers cannot be planted in adjacent plots.
//
// Given an integer array flowerbed containing 0's and 1's, where 0 means empty
//and 1 means not empty, and an integer n, return if n new flowers can be planted
//in the flowerbed without violating the no-adjacent-flowers rule.
//
//
// Example 1:
// Input: flowerbed = [1,0,0,0,1], n = 1
//Output: true
// Example 2:
// Input: flowerbed = [1,0,0,0,1], n = 2
//Output: false
//
//
// Constraints:
//
//
// 1 <= flowerbed.length <= 2 * 104
// flowerbed[i] is 0 or 1.
// There are no two adjacent flowers in flowerbed.
// 0 <= n <= flowerbed.length
//
// Related Topics 贪心算法 数组
// 👍 278 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length < 2) return (flowerbed[0] + n <= 1);
        int cnt = 0;
        int after = flowerbed[1];
        for(int i=0;i<flowerbed.length;++i){
            if (i == flowerbed.length -1) after = 0;
            else after = flowerbed[i+1];
            //3 situations:00,10,01
            if(after == 0){
                if(flowerbed[i] == 0) ++cnt;
                ++i;
            }else{
                //01 means must have a 0 behind 1 -> 010,so next i should be i+2
                i = i+2;
            }
        }
        return n<=cnt;

        //leetcode official solution2
//        int count = 0;
//        int m = flowerbed.length;
//        int prev = -1;
//        for (int i = 0; i < m; i++) {
//            if (flowerbed[i] == 1) {
//                if (prev < 0) {
//                    count += i / 2;
//                } else {
//                    count += (i - prev - 2) / 2;
//                }
//                prev = i;
//            }
//        }
//        if (prev < 0) {
//            count += (m + 1) / 2;
//        } else {
//            count += (m - prev - 1) / 2;
//        }
//        return count >= n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
