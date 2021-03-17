
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
        insertionSort(test);
        for(int n : test){
            System.out.println(n+" ");
        }
    }
    public static void insertionSort(int[] arr) {
        //0~1有序
        //0~2有序
        //...
        //0~n-1有序
        if(arr.length<2 || arr == null) return;
        for(int i=1;i<arr.length;++i){
           for(int j=i;j>0;--j){
               if(arr[j]<arr[j-1]) swap(arr, j, j-1);
           }
       }
//        for(int i=1;i<arr.length;++i){
//            for(int j= i - 1;j >= 0 && arr[j+1] < arr[j]; --j){
//                swap(arr, j, j+1);
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
