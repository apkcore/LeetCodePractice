package _第二季._排序;

public class _插入 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 11, 5, 9, 15, 16, 17};
        sort2(arr);
        System.out.println("-------------------------------");
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    private static void sort(int[] arr) {
        for (int begin = 1; begin < arr.length; begin++) {
            int cur = begin;
            // 将将前的元素与后面的那个比较，如果小于后面的元素，就交换位置
            while (cur > 0 && arr[cur] < arr[cur - 1]) {
                swap(arr, cur, cur - 1);
                cur--;
            }
        }
    }

    /**
     * 优化1：
     * 减少交换次数，把当前的值缓存起来，然后用前面的大值覆盖后面的小值
     */
    private static void sort1(int[] arr) {
        for (int begin = 1; begin < arr.length; begin++) {
            int cur = begin;
            int temp = arr[cur];
            // 将将前的元素与后面的那个比较，如果小于后面的元素，就交换位置
            while (cur > 0 && arr[cur] < arr[cur - 1]) {
                arr[cur] = arr[cur - 1];
                cur--;
            }
            arr[cur] = temp;
        }
    }

    /**
     * 优化2：
     * 减少查找的次数
     */
    private static void sort2(int[] arr) {
        for (int begin = 1; begin < arr.length; begin++) {
            int v = arr[begin];
            int index = searchIndex(arr, begin);
            System.out.println(index);
            for (int i = begin; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = v;
        }
    }

    /**
     * 找到元素应该的插入位置
     * 使用index的好处是能够限定arr的首尾
     */
    private static int searchIndex(int[] arr, int index) {
        int begin = 0;
        int end =index;
        while (end > begin) {
            int mid = (end + begin) >> 1;
            if (arr[mid] < arr[index]) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return begin;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b - 1] = temp;
    }
}
