/**
 * 冒泡算法
 * 把大的数一赴往后移
 * *----------------------
 * 优化：当已经有序时，跳出循环不再进行排序
 */
public class _冒泡 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 11, 5, 9};
        sort(arr);
    }

    public static void sort(int[] arrs) {
        for (int j = arrs.length - 1; j >= 0; j--) {
            boolean isSort = true;
            for (int i = 1; i < arrs.length; i++) {
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
