/**
 * 创建人：yinwuteng
 * 创建时间：2019/2/27
 * 版本号：1.0.1
 * 描述：斐波拉切数列
 * 设计文档：
 */
public class Fibonacci {

    /**
     * 递归实现
     *
     * @param n
     * @return
     */
    public static int result(int n) {
        if (n <= 1) return n;
        return result(n - 1) + result(n - 2);
    }

    /**
     * 声明临时变量
     *
     * @param n
     */

    public static int getResult(int n) {
        int result = 0;
        if (n <= 1) result = n;
        int firstNum = 0;
        int secondNum = 1;

        for (int i = 2; i <= n; i++) {
            result = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getResult(6));
    }
}
