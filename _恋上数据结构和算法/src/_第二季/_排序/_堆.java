package _第二季._排序;

public class _堆 {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5};
        int[] arr = {2, 3, 1, 11, 5, 9, 15, 16, 17};
        sort(arr);
        System.out.println("-------------------------------");
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    public static void sort(int[] arr) {
        int heapSize = arr.length;
        //原地建堆
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(arr, 0);
        }
        while (heapSize > 1) {
            // 交换堆顶和尾部元素
            swap(arr, 0, heapSize);
            heapSize--;
            // 恢复堆的性质
            siftDown(arr, 0);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void siftDown(int[] arr, int index) {
        int element = arr[index];
        int heapSize = arr.length;
        int half = heapSize >> 1;
        while (index < half) {
            // index要是非叶子节点
            // 默认使用左边和父节点比
            int childIndex = (index << 1) + 1;
            int child = arr[childIndex];
            int rightIndex = childIndex + 1;
            // 右边节点比左边大
            if (rightIndex < heapSize && arr[rightIndex] > child) {
                child = arr[childIndex - rightIndex];
            }

            // 大于等于子节点
            if (element >= child) {
                break;
            }
            arr[index] = child;
            index = childIndex;
        }
        arr[index] = element;
    }
}
