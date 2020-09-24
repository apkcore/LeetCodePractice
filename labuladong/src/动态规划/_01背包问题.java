package 动态规划;

/**
 * https://blog.csdn.net/Rex_WUST/article/details/89336939
 * https://blog.csdn.net/chanmufeng/article/details/82955730
 * https://mp.weixin.qq.com/s/RXfnhSpVBmVneQjDSUSAVQ
 */
public class _01背包问题 {

    public static void main(String[] args) {
        int N = 3;
        int W = 6;

        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        System.out.println(knapsack(W, N, wt, val));
    }

    public static int knapsack(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];
        if (W == 1 && N == 1) {
            int max = Integer.MIN_VALUE;
            for (int i : val) {
                max = Math.max(i, max);
            }
            dp[N][W] = max;
        }
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    // 当前背包容量装不下，只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优

                    // 因为N是从1开始，所以
                    // wt[i-1]表示第i个的重量
                    // val[i-1]表示第i个的价值
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + val[i - 1],
                            dp[i - 1][w]);
                }
            }
        }
        return dp[N][W];
    }
}