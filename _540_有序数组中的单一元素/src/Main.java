/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * ----------------------------------------------------------------------------------------
 * <p>
 * 解题思路：
 * 一：
 * 分析题意：只有一个数只出现了一次，也就是说只有一个整数为奇数个。
 * 看到时间复杂度log(n)就想到二分法，那么我们使用二分查找，就能解决此问题
 * 分别定义三个指针lo hi mid，lo首先指向index=0,hi指向index=length-1,mid指向lo+(lo+hi)/2；判断mid和左右两边哪个相等，
 * 如果都不相等，那么mid就是只出现了一次，如果有相等的，再以（m,m）为整体，看左右哪边是奇数，奇数的那边肯定是有一个元素只出现了一次，
 * 如果在左，把hi移动到mid这边，在右，把lo移动在mid边边，一直迭代到lo<=hi
 * <p>
 * 二：
 * 做为上面方法的改进版，把确定mid的值时，定义取mid索引index必做为偶数，当mid=mid+1时，lo=mid+2,否则hi=mid
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(new Main().singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length % 2 == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 != 0) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
