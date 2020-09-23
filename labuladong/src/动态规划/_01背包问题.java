package 动态规划;

public class _01背包问题 {

    public static void main(String[] args) {
        int N = 1;
        int W = 1;

        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        System.out.println(knapsack(W, N, wt, val));
    }

    public static int knapsack(int W, int N, int[] wt, int[] val) {
//        int[][] dp = new int[N + 1][W + 1];
        int[][] dp = new int[N + 1][W + 1];
        // 声明动态规划表.其中v[i][j]对应于：当前有i个物品可选，并且当前背包的容量为j时，我们能得到的最大价值

        // 填动态规划表。当前有i个物品可选，并且当前背包的容量为j。
//        for (int i = 0; i < N+1; i++) {
//            for (int j = 0; j < W + 1; j++) {
//                if (i == 0) {
//                    dp[i][j] = 0; // 边界情况：若只有0道题目可以选做，那只能得到0分。所以令V(0,j)=0
//                } else if (j == 0) {
//                    dp[i][j] = 0; // 边界情况：若只有0分钟的考试时间，那也只能得0分。所以令V(i,0)=0
//                } else {
//                    if (j < wt[i]) {
//                        dp[i][j] = dp[i - 1][j];// 包的容量比当前该物品体积小，装不下，此时的价值与前i-1个的价值是一样的，即V(i,j)=V(i-1,j)；
//                    } else {
//                        dp[i][j] = Math.max(dp[i - 1][j],
//                                dp[i - 1][j - wt[i]] + val[i]);// 还有足够的容量可以装当前该物品，但装了当前物品也不一定达到当前最优价值，所以在装与不装之间选择最优的一个，即V(i,j)=max｛V(i-1,j)，V(i-1,j-w(i))+v(i)｝。
//                    }
//                }
//            }
//        }

        if(W==1&&N==1){
            int max = Integer.MIN_VALUE;
            for (int i : val) {
                max = Math.max(i,max);
            }
         return max;
        }
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                System.out.println(w+" - "+i+" - "+wt[i-1]);
                if (w - wt[i-1] < 0) {
                    // 当前背包容量装不下，只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    System.out.println(dp[i - 1][w - wt[i-1]]);
                    System.out.println(val[i-1]);
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i-1]] + val[i-1],
                            dp[i - 1][w]);
                }
            }
        }
        System.out.println(N+"个"+W+"重动态规划表如下：");
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                System.out.print("("+i+"个,"+j+"重)"+dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("背包内最大的物品价值总和为：" + dp[N][W]);
//        int[] item = new int[N + 1];// 下标i对应的物品若被选中，设置值为1
//        Arrays.fill(item, 0);// 将数组item的所有元素初始化为0
//
//        // 从最优解，倒推回去找
//        int j = W;
//        for (int i = N; i > 0; i--) {
//            if (dp[i][j] > dp[i - 1][j]) {// 在最优解中，v[i][j]>v[i-1][j]说明选择了第i个商品
//                item[i] = 1;
//                j = j - wt[i];
//            }
//        }
//
//        System.out.print("包内物品的编号为：");
//        for (int i = 0; i < N + 1; i++) {
//            if (item[i] == 1) {
//                System.out.print(i + " ");
//            }
//        }
        System.out.println("----------------------------");
        return dp[N][W];
    }
}