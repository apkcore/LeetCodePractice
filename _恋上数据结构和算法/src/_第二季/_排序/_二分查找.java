package _第二季._排序;

public class _二分查找 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 8, 9};
//        int[] arr = {2, 3, 1, 11, 5, 9, 15, 16, 17};
        int index = search(arr, 1);
        System.out.println(index);
    }

    private static int search(int[] arr, int element) {
        int begin = 0;
        int end = arr.length;
        while (end > begin) {
            int mid = (end + begin) >> 1;
            if (arr[mid] < element) {
                begin = mid + 1;
            } else if (arr[mid] > element) {
                end = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
