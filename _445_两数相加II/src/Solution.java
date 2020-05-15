import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * -----------------------------------------------------------------------------
 * <p>
 * 解析：
 * 这个题其实很简单，就是计算时要保证最右边对齐，也就是后进先出，依次放入两个栈，再从栈中取值相加，用一个变量flag来表示是否有进位
 */

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1.next != null) {
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2.next != null) {
            stack1.push(l2.val);
            l2=l2.next;
        }
        boolean flag = false;
        while (!stack1.empty()&&!stack2.empty()){

        }
    }
}
