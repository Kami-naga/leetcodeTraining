//Given a string s, determine if it is a palindrome, considering only alphanumer
//ic characters and ignoring cases.
//
//
// Example 1:
//
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//
//
// Example 2:
//
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 2 * 105
// s consists only of printable ASCII characters.
//
// Related Topics 双指针 字符串
// 👍 350 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int L = 0;
        int R = s.length() - 1;
        while(L < R){
            while(L < R && !Character.isLetterOrDigit(s.charAt(L))) ++L;
            while(L < R && !Character.isLetterOrDigit(s.charAt(R))) --R;
            if(Character.toLowerCase(s.charAt(L++)) != Character.toLowerCase(s.charAt(R--))) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
