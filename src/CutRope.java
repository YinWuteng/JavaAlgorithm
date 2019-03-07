/**
 * 创建人：yinwuteng
 * 创建时间：2019/3/6
 * 版本号：1.0.1
 * 描述：剪绳子、动态规划、贪婪算法
 * 设计文档：
 */
public class CutRope {

    /**
     * 动态规划
     *
     * @param length
     * @return f(n)=maxf(i)*f(n-i)
     */
    public static int dynamicSolution(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;
        int[] datas = new int[length + 1];
        datas[0] = 0;
        datas[1] = 0;
        datas[2] = 1;
        datas[3] = 2;
        int max = 0;
        for (int i = 4; i < length; i++) {
            max = 0;
            for (int j = 1; j < i / 2; j++) {
                int partion = datas[j] * datas[i - j];
                if (max < partion)
                    max = partion;
                datas[i] = max;
            }

        }
        return datas[length];
    }

    /**
     * 贪婪算法
     * 尽可能剪长度为3的绳子
     *
     * @param length
     * @return
     */
    public static int greedy(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;
        //尽可能多地去剪长度为3的绳子段
        int timesOf3 = length / 3;
        //当绳子最后剩下长度为4的时候，不能在剪去长度为3的绳子段
        if (length - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timeOf2 = (length - timesOf3 * 3) / 2;
        return (3 * timesOf3) * (2 * timeOf2);
    }

    public static void main(String[] args) {
        System.out.println(greedy(7));
    }
}
