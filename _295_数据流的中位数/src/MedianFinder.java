import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------
 * 解析：
 * 很容易想到的就是先排序再找中间一个数，但是排序算法的时间复杂度都比较高，我们有没有更好的方式呢？
 * 其实仔细分析我们可以知道，把数据分为两段，只要保证其中一段一定要比另外一段要小，小的一段中的最大值，与大的一段的最小值，就是整个序列的中间元素，
 * 而无需对整个序列来进行排序。这时候，我们就知道要使用的是一个最大堆求出最小值，最小堆拿到最大值
 */
public class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        // 最大堆，可以拿到最大值
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // 最小堆，拿最小值
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 添加到最大堆，堆顶保持最大值
        maxHeap.add(num);
        // 把最大值放最小堆，堆顶会保持最小值
        minHeap.add(maxHeap.poll());
        // 如果最小堆的长度大小最大堆，就把堆顶的元素放到最大堆去
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) * 0.5f;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(8);
        double param_2 = obj.findMedian();
        System.out.println(param_2);
        obj.addNum(3);
        obj.addNum(4);
        param_2 = obj.findMedian();
        System.out.println(param_2);
    }
}
