package _第二季._排序;

/**
 * 冒泡算法
 * 把大的数一赴往后移
 * *----------------------
 * 优化1：当已经有序时，跳出循环不再进行排序
 * 但是如果完全无序时，反而会慢
 * 优化2：记录尾部有序的，然后循环只要到有序的index
 */
public class _冒泡 {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5};
        int[] arr = {2, 3, 1, 11, 5, 9,15,16,17};
        sort2(arr);
        System.out.println("-------------------------------");
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    /**
     * 最基本的写法
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int end = arr.length-1; end > 0; end--) {
            for (int begin = 1; begin <=end; begin++) {
                if (arr[begin - 1] > arr[begin]) {
                    int temp = arr[begin];
                    arr[begin] = arr[begin - 1];
                    arr[begin - 1] = temp;
                }
            }
        }
    }

    /**
     * 优化1，当已排好序时直接break
     * @param arr
     */
    public static void sort1(int[] arr) {
        for (int end = arr.length-1; end> 0; end--) {
            boolean sorted = true;
            for (int begin = 1; begin <=end; begin++) {
                if (arr[begin - 1] > arr[begin]) {
                    sorted = false;
                    int temp = arr[begin];
                    arr[begin] = arr[begin - 1];
                    arr[begin - 1] = temp;
                }
            }
            if(sorted){
                break;
            }
        }
    }

    /**
     * 记录最后一串已排好序的位置
     * @param arr
     */
    public static void sort2(int[] arr) {
        for (int end = arr.length-1; end > 0; end--) {
            int sortedIndex = 0;
            for (int begin = 1; begin <=end; begin++) {

                if (arr[begin - 1] > arr[begin]) {
                    sortedIndex = begin;
                    int temp = arr[begin];
                    arr[begin] = arr[begin - 1];
                    arr[begin - 1] = temp;
                }
            }
            end = sortedIndex;
        }
    }
}
