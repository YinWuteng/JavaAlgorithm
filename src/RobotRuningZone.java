/**
 * 机器人运动范围
 * m行n列，机器人从坐标(0,0)开始
 * 当k为18时，机器人能够进入方格(35,37)，因为3+5+3+7=18.但它不能进入方格(35,38)
 * 回溯法
 */
public class RobotRuningZone {


    /**
     *
     * @param threshould 约束值
     * @param rows 行
     * @param cols 列
     * @return
     */
    public static int arrivaBlank(int threshould, int rows, int cols) {
        //校验输入合法性
        if (threshould < 0 || rows < 1 || cols < 1) return 0;
        //初始化一个数组，用于记录是否被走过
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        return movingCountCore(threshould, rows, cols, 0, 0, visited);
    }

    /**
     *
     * @param threshould 约束值
     * @param rows 总行数
     * @param cols 总列数
     * @param row 行
     * @param col 列
     * @param visited 是否走过
     * @return
     */
    public static int movingCountCore(int threshould, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshould, rows, cols, row, col, visited)) {
            visited[col * rows + col] = true;
            count = 1 + movingCountCore(threshould, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshould, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshould, rows, cols, row, col + 1, visited)
                    + movingCountCore(threshould, rows, cols, row - 1, col, visited);
        }
        return count;
    }

    /**
     *
     * @param threshould 约束值
     * @param rows 总行数
     * @param cols 总列数
     * @param row 行
     * @param col 列
     * @param visited 是否走过
     * @return
     */
    public static boolean check(int threshould, int rows, int cols, int row, int col, boolean[] visited) {
        return col >= 0 && col < cols && row >= 0 && row < rows && !visited[col * rows + col] && getSum(row) + getSum(col) <= threshould;
    }


    public static int getSum(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}
