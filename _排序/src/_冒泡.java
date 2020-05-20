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
        int[] arr = {2, 3, 1, 11, 5, 9};
        sort(arr);
    }

    public static void sort(int[] arrs) {
        for (int j = arrs.length - 1; j >= 0; j--) {
            boolean isSort = true;
            for (int i = 1; i <=j; i++) {
                if (arrs[i - 1] > arrs[i]) {
                    isSort = false;
                    int temp = arrs[i];
                    arrs[i] = arrs[i - 1];
                    arrs[i - 1] = temp;
                }
            }
            for (int i : arrs) {
                System.out.print(i + ",");
            }
            System.out.println();
            if (isSort) {
                System.out.println("break");
                break;
            }
        }
    }
}
