/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * ----------------------------------------------------------
 * <p>
 * 题解：
 * 我们可以经他补一个完整的数序列，通过一直异或，最后剩下的就是那个缺失的数
 * https://mp.weixin.qq.com/s/WBXkHdm-Vm-Wwn5hsI9Ryw
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(new Main().missingNumber(nums));
    }

    public int missingNumber2(int[] nums) {
        int ret = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            ret ^= nums[i] ^ i;
        }
        // 因为nums是不完整的数组，比如0，1，2，4，index只能到3，这时候需要在最后再^下4
        return ret ^ i;
    }

    public int missingNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; ) {
            // 因为nums是不完整的数组，比如0，1，2，4，index只能到3，这时候需要在最后再^下4
            ret ^= nums[i++];
            ret ^= i;
        }
        return ret;
    }
}
