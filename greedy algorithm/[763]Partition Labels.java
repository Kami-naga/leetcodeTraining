//A string S of lowercase English letters is given. We want to partition this st
//ring into as many parts as possible so that each letter appears in at most one p
//art, and return a list of integers representing the size of these parts.
//
//
//
// Example 1:
//
//
//Input: S = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it split
//s S into less parts.
//
//
//
//
// Note:
//
//
// S will have length in range [1, 500].
// S will consist of lowercase English letters ('a' to 'z') only.
//
//
//
// Related Topics 贪心算法 双指针
// 👍 420 👎 0


import java.util.ArrayList;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String S) {
//        int len = S.length();
//        ArrayList<Integer> result = new ArrayList<>();
//        HashSet<Character> dup = new HashSet<>();
//        int i = 0;
//        int j = 0;
//        char[] chars = S.toCharArray();
//        while(i < len && j < len){
//            dup.add(chars[i]);
//            for (int k = len - 1; k > i; --k) {
//                if (chars[k] == chars[i]) {
//                    j = k;
//                    break;
//                }
//            }
//            for(int t=i+1; t<j; ++t){
//                char tmp = chars[t];
//                if (dup.contains(tmp)) continue;
//                else {
//                    dup.add(tmp);
//                    for (int u = len - 1; u > t; --u) {
//                        if (chars[u] == tmp) {
//                            if(u > j) j=u;
//                            break;
//                        }
//                    }
//                }
//            }
//            int size = j - i + 1;
//            result.add(size);
//            i = j + 1;
//            j = i;
//        }
//        return result;

        int len = S.length();
        int[] last = new int[26];
        //get the last positions of all the characs of the string
        for(int i=0; i<len; ++i){
            last[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=start; i<len; ++i){
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if(i == end){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
