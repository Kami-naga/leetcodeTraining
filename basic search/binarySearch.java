
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] test = {1,1,2,3,4,4,4,5,6,6,6,7,7,8,8,8,9,9,9,10};
        System.out.println(binarySearch(test, 5));
    }
    public static boolean binarySearch(int[] arr, int n) {
        if(arr == null) return false;
        int L = 0;
        int R = arr.length - 1;
        int M = 0;
        while(L < R){
            //int M = (L + R)/2
            //int M = L + (R - L)/2 prevent overflow of (L + R) IntegerMax + IntegerMax
            M = L + ((R - L) >> 1);
            if(arr[M] == n){
                return true;
            }else if(arr[M] > n){
                R = M - 1;
            }else{
                L = M + 1;
            }
        }
        return arr[L] == n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
