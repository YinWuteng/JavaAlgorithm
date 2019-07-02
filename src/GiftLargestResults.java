/**
 * 礼物的最大值，
 * 动态规划
 * 从左上开始，每次向右或者向下移动直到右下角
 * 递归会导致大量重复计算
 */
public class GiftLargestResults {

    public static void main(String[] args) {
        int[][] data = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        getMostResults(data,data.length,data[0].length);
    }

    public static int getMostResults(int[][] data, int rows, int cols) {
        if (data == null || rows < 1 || cols < 1) return 0;
        //定义一个一维度数组用来存储最大值,
        int[] maxValue = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;//控制左右
                int up = 0; //控制上下
                if (i > 0) {//获取当前数组记录的最大当列对应的值
                    up=maxValue[j];
                }
                if (j > 0) {//获取上一个最大值
                    left=maxValue[j-1];
                }
                maxValue[j] = Math.max(up, left) + data[i][j];

            }
        }
        return maxValue[cols - 1];
    }
}
