package _第二季._排序;

public class _选择 {
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
        for (int end = arr.length - 1; end > 0; end--) {
            int maxIndex=0;
            for (int begin = 1; begin <= end; begin++) {
                if(arr[begin] > arr[maxIndex]){
                    maxIndex = begin;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[end];
            arr[end] = temp;
        }
    }

}
