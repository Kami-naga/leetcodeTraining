//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array.
//
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y. You may assume that nums1 has a size equal to m + n such that it has enough s
//pace to hold additional elements from nums2.
//
//
// Example 1:
// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
// Example 2:
// Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//
//
// Constraints:
//
//
// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -109 <= nums1[i], nums2[i] <= 109
//
// Related Topics 数组 双指针
// 👍 738 👎 0


//import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] result = new int[m+n];
//        int i = 0, j = 0, k = 0;
//        while(i<m && j<n){
//            result[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
//        }
//        while(i < m){
//            result[k++] = nums1[i++];
//        }
//        while(j < n){
//            result[k++] = nums2[j++];
//        }
        //System.arraycopy(result,0,nums1,0,n+m);
        //take less space? just do from bottom of nums1

        int pos = m-- + n-- - 1;
        while(m >= 0 && n >= 0){
            nums1[pos--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while(n>=0){
            nums1[pos--] = nums2[n--];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
