import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _回溯框架 {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        _全排序 a = new _全排序();
//
//        List<List<Integer>> list = a.permute(nums);
//        list.forEach((list1) -> System.out.println(list1));

        _N皇后 b = new _N皇后();
        List<List<String>> list = b.solveNQueens(8);
        list.forEach((list1) -> System.out.println(list1));
    }

    static class _N皇后 {
        /**
         * N皇后
         */
        List<List<String>> res = new ArrayList<>();

        /* 输入棋盘边长 n，返回所有合法的放置 */
        List<List<String>> solveNQueens(int n) {
            char[][] chess = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    chess[i][j] = '.';
                }
            }
            // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
            backtrack(chess, 0);
            return res;
        }

        // 路径：chess 中小于 row 的那些行都已经成功放置了皇后
        // 选择列表：第 row 行的所有列都是放置皇后的选择
        // 结束条件：row 超过 chess 的最后一行
        void backtrack(char[][] chess, int row) {
            // 触发结束条件
            if (row == chess.length) {
                res.add(construct(chess));
                return;
            }
            int n = chess[row].length;
            for (int col = 0; col < n; col++) {
                // 排除不合法选择
                if (!isValid(chess, row, col)) {
                    continue;
                }
                // 做选择
                chess[row][col] = 'Q';
                // 进入下一行决策
                backtrack(chess, row + 1);
                // 撤销选择
                chess[row][col] = '.';
            }
        }

        /* 是否可以在 chess[row][col] 放置皇后？ */
        boolean isValid(char[][] chess, int row, int col) {
            int n = chess.length;
            //判断当前列有没有皇后,因为他是一行一行往下走的，
            //我们只需要检查走过的行数即可，通俗一点就是判断当前
            //坐标位置的上面有没有皇后
            for (int i = 0; i < n; i++) {
                if (chess[i][col] == 'Q') {
                    return false;
                }
            }
            // 检查右上方是否有皇后互相冲突
            for (int i = row - 1, j = col + 1;
                 i >= 0 && j < n; i--, j++) {
                if (chess[i][j] == 'Q') {
                    return false;
                }
            }
            // 检查左上方是否有皇后互相冲突
            for (int i = row - 1, j = col - 1;
                 i >= 0 && j >= 0; i--, j--) {
                if (chess[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }

        //把数组转为list
        private List<String> construct(char[][] chess) {
            List<String> path = new ArrayList<>();
            for (int i = 0; i < chess.length; i++) {
                path.add(new String(chess[i]));
            }
            return path;
        }

    }

    static class _全排序 {

        /**
         * 全排序
         * 框架
         * for 选择 in 选择列表:
         * # 做选择
         * 将该选择从选择列表移除
         * 路径.add(选择)
         * backtrack(路径, 选择列表)
         * # 撤销选择
         * 路径.remove(选择)
         * 将该选择再加入选择列表
         */
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(nums, track);
            return res;
        }

        private void backtrack(int[] nums, LinkedList<Integer> track) {
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }
            for (int num : nums) {
                if (track.contains(num)) {
                    continue;
                }
                track.add(num);
                backtrack(nums, track);
                track.removeLast();
            }
        }

    }
}
