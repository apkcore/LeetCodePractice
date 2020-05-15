/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * ------------------------------------------------------------------------------------------
 * <p>
 * 这是个数组的搬运问题，也是现实中超市上货架的问题
 * 我们知道如果数组从头部添加元素时，整个数组都要向后挪，o(n)的时间复杂度，，如果有n个全部从头插的话效率是很低的，
 * 所以选择双指针从后往前，直到其中一个指针不在指向数组，也就是index<0
 * 比较双指针指向的值，大的放到第一个数组的尾部，对应指针往前移一位，如果到最后第二个数组的指针还有值，说明还有最小的值在前面，直接复制过去
 */
class Solution {
    public static void main(String[] args) {
        int[] nums1 = { 6,7,8,11,0,0,0,0};
        int[] nums2 = { 1,2,5,15};
        new Solution().merge(nums1,4,nums2,4);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        while (m > 0 && n > 0) {
            nums1[--len] = nums2[n - 1] > nums1[m - 1] ? nums2[--n] : nums1[--m];
        }
        if (n > 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }
    }

}
