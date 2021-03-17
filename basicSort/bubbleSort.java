
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] test = {3,2,4,6,8,3,9,2};
        for(int n : test){
            System.out.println(n+" ");
        }
        System.out.println();
        bubbleSort(test);
        for(int n : test){
            System.out.println(n+" ");
        }
    }
    public static void bubbleSort(int[] arr) {
        //0~n-1
        //1~n-1
        //2~n-1
        //...
        //n-2~n-1
        if(arr == null || arr.length < 2) return;
        for(int i=0; i<arr.length-1; ++i){
            for(int j=arr.length-2;j>=i;--j){
                if(arr[j]>arr[j+1]) swap(arr, j, j+1);
            }
        }
        //0~n-1
        //0~n-2
        //...
        //0~1
//        for(int i=arr.length-1;i>=0;--i){
//            for(int j=0;j<i;++j){
//                if(arr[j]>arr[j+1]) swap(arr, j, j+1);
//            }
//        }
    }
    public static void swap(int[] arr, int i, int j){
        //小心异或自己会为0，再次最后一个元素就会异或自己使其变0
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
