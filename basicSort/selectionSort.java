
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
        selectionSort(test);
        for(int n : test){
            System.out.println(n+" ");
        }
    }
    public static void selectionSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        int minIndex = 0;
        for(int i = 0; i < arr.length - 1; ++i){
            minIndex = i;
            for(int j = i + 1; j < arr.length; ++j){
                minIndex = arr[j]<arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }
    public static void swap(int[] arr, int i, int j){
        //小心异或自己会为0，再次最后一个元素就会异或自己使其变0，所以控制循环i < arr.length - 1
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
