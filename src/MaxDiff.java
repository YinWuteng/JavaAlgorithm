/**
 * 股票的最大利润
 * 数组[9,11,8,5,7,12,16,14]
 * 方法一：循环。比较所有的差值
 * 方法二：先找出其中的最大值，然后在它之前的最小值
 */
public class MaxDiff {

    /**
     * 方法二，写法一
     *
     * @param data
     * @return
     */
    public static int getMaxDif(int[] data) {
        if (data == null || data.length < 2) {
            return -1;
        }
        int max = data[0];

        int maxPos = 0; //记录最大值的位置

        for (int i = 1; i < data.length - 1; i++) {
            if (data[i] > max) {
                max = data[i];
                maxPos = i;
            }
        }

        //然后在前面找
        int min = data[0];
        for (int i = 1; i < maxPos; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return max - min;
    }

    /**
     * 方法二，写法二
     *
     * @param data
     * @return
     */
    public static int maxDif(int[] data) {
        if (data == null || data.length < 2) {
            return 0;
        }
        int min = data[0];
        int maxDif = data[1] - min;
        for (int i = 2; i < data.length; i++) {
            if (data[i - 1] < min) {
                min = data[i - 1];
            }
            int curDif = data[i] - min;
            if (curDif > maxDif) {
                maxDif = curDif;
            }
        }
        return maxDif;
    }
}
