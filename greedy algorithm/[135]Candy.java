//There are N children standing in a line. Each child is assigned a rating value
//.
//
// You are giving candies to these children subjected to the following requireme
//nts:
//
//
// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
//
//
// What is the minimum candies you must give?
//
// Example 1:
//
//
//Input: [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1,
//2 candies respectively.
//
//
// Example 2:
//
//
//Input: [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2,
//1 candies respectively.
//             The third child gets 1 candy because it satisfies the above two c
//onditions.
//
// Related Topics 贪心算法
// 👍 443 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        int num = ratings.length;
        int[] candy = new int[num];
        if(num < 2) return 1;
        for(int i=1; i<num; ++i){
            if(ratings[i] > ratings[i-1])
                candy[i] = candy[i-1] + 1;
        }
        for(int i = num-1; i>0; --i){
            if(ratings[i] < ratings[i-1])
                candy[i-1] = Math.max(candy[i-1], candy[i] + 1);
        }
        // below 3 are all the same
//        int sum = num;
//        for(int i : candy){
//            sum += i;
//        }
//        return sum;

//        return Arrays.stream(candy).sum() + num;
        return Arrays.stream(candy).reduce(num, Integer::sum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
