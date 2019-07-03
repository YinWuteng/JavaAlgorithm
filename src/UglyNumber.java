/**
 * 丑数
 * 只包含因子2,3,5的数被称作为丑数
 * 1也是丑数
 * 获取第N个丑数
 * <p>
 * 思路：用一个辅助空间来存储已经得出的丑数
 * 已经得出的丑数，分别乘以因子，找出最小的一位数作为下一个存入数组的
 * 1,2,3,4,5,6,8,9,10
 */
public class UglyNumber {
    public static void main(String[] args) {
        System.out.println("打印数字");
        System.out.println(getIndexUglyNum(2));
    }

    public static int getIndexUglyNum(int index) {
        if (index <= 0) return 0;
        //申明一个数组用于存储丑数
        int[] data = new int[index];
        data[0] = 1;
        //初始化下一个要处理的位置
        int pos = 1;

        //记录各个因子处理到的位置
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (pos < index) {
            //获取三者中最小的值
            int min = min(data[p2] * 2, data[p3] * 3, data[p5] * 5);
            data[pos] = min;
            //如果三者中有比数组中记录的最后的一位数小时，位置加1
            while (data[p2] * 2 <= data[pos]) {
                p2++;
            }
            while (data[p3] * 3 <= data[pos]) {
                p3++;
            }
            while (data[p5] * 5 <= data[pos]) {
                p5++;
            }
            pos++;
        }
        return data[pos-1];
    }


    public static int min(int n1, int n2, int n3) {
        int min = n1 < n2 ? n1 : n2;
        return min < n3 ? min : n3;
    }


    /**
     * 方法二
     *
     * @return
     */
    public static int get2(int index) {
        if (index <= 0) return 0;

        //从1开始，所以num=1,count=1;
        int num = 1;
        int count = 1;
        while (count < index) {
            if (isUglyNumber(num)) {
                count++;
            }
            num++;
        }
        return num;
    }

    public static boolean isUglyNumber(int num) {


        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
