import java.util.Arrays;
import java.util.HashMap;

public class _动态规划 {
    public static void main(String[] args) {

        _斐波拉契 a = new _斐波拉契();
        int x = a.fib(8);
        int x2 = a.fib2(8);
        int x3 = a.fib3(8);
        int x4 = a.fib4(8);
        System.out.println(x4 + " <<>> " + x3 + " ----- --- " + x + " ---- " + x2);

        _零钱 b = new _零钱();
        int[] arrs = {1, 3, 5};
        System.out.println(b.coinChange(arrs, 13));
    }


    static class _斐波拉契 {

        int fib2(int N) {
            if (N == 1 || N == 2) return 1;
            return fib(N - 1) + fib(N - 2);
        }

        public int fib(int num) {
            if (num == 1 || num == 2) {
                return 1;
            }
            if (map.containsKey(num)) {
                return map.get(num);
            } else {
                int x = fib(num - 1) + fib(num - 2);
                map.put(num, x);
                return x;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int fib3(int n) {
            map.put(1, 1);
            map.put(2, 1);
            for (int i = 3; i <= n; i++) {
                map.put(i, map.get(i - 1) + map.get(i - 2));
            }
            return map.get(n);
        }

        int fib4(int n) {
            if (n == 1 || n == 2) {
                return 1;
            }
            int prev = 1;
            int curr = 1;
            for (int i = 3; i <= n; i++) {
                int sum = prev + curr;
                prev = curr;
                curr = sum;
            }
            return curr;
        }
    }

    static class _零钱 {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            // 数组大小和最大值都为amount+1

            //base case
            dp[0] = 0;
            // 外层for在遍历所有状态的所有取值
            for (int i = 0; i <= amount; i++) {
                // 内层for循环在求所有选择的最小值
                for (int coin : coins) {
                    // 子问题无解就跳过
                    if (coin > i) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
