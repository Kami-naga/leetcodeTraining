
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        //教训:
        //使用左移右移一定要加括号！！！
        //异或方式交换，一定要注意相同两值异或会变0！！
        //使用大根堆进行由小到大堆排序方便点，每次0位置和最后一个交换，然后size--来踢掉最后一个
        System.out.println("Hello World!");
        int[] test = {3,2,4,6,8,3,9,2};
        for(int n : test){
            System.out.println(n+" ");
        }
        System.out.println();
        heapSort(test);
        for(int n : test){
            System.out.println(n+" ");
        }
    }
    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        for(int i = arr.length - 1; i>=0; --i){
            heapify(arr, i, arr.length);
        }
        System.out.println("lalalalalalala");
        for(int n : arr){
            System.out.println(n+" ");
        }
        int heapSize = arr.length;
        swap(arr, 0 , --heapSize);
        while(heapSize > 0){
            heapify(arr, 0, heapSize);
            for(int n : arr){
                System.out.println(n+" ");
            }
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        //new num goes to the end the of the arr
        //then check if the father of the new num is bigger/smaller than it
        //if so, swap them
        //loop above until root go to head of the heap -> 0
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    public static void heapify(int[] arr, int pos, int heapSize) {
        int left = (pos << 1) + 1;
        System.out.println("START heapify left="+left+", heapSize="+heapSize);
        while(left < heapSize){
            int maxIdx;
            if(left + 1 < heapSize && arr[left + 1] > arr[left]){ //check if have right son
                maxIdx = left + 1; //if no, get the left guy
            }else{// if yes, get the min/max one(left or right)
                maxIdx = left;
            }
            // compare father & min/max son
            maxIdx = arr[pos] > arr[maxIdx] ? pos: maxIdx;
            System.out.println("in heapify, minIdx="+maxIdx);
            if(maxIdx == pos){
                // if father is min/max, his sons will all be ok
                // so just stop here
                System.out.println("in heapify, break");
                break;
            }
            // son is min/max, then we nedd to swap father&son
            //then do the same operation between son & grandson to adjust the heap
            swap(arr, pos, maxIdx);
            pos = maxIdx;
            left = (pos << 1) + 1;
        }

    }

    public static void swap(int[] arr, int i, int j){
        //小心异或自己会为0，再次最后一个元素就会异或自己使其变0
        if(i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
