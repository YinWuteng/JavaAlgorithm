import java.util.Arrays;

/**
 * 创建人：yinwuteng
 * 创建时间：2019/2/22
 * 版本号：1.0.1
 * 描述：排序例子
 * 设计文档：
 */
public class SortSimple {


    /**
     * 冒泡排序
     *
     * @param data   数组
     * @param length 数组长度
     * @return 从左到右，最大在右边,每次挑选最大的往右边排
     */
    private static int[] bubleSort(int[] data, int length) {
        if (data == null) return null;
        int out, in, temp;
        //从最后一个值开始
        for (out = length - 1; out > 0; out--) { //外层控制每次循环选取个数
            for (in = 0; in < out; in++) {
                if (data[in] > data[in + 1]) {
                    temp = data[in];
                    data[in] = data[in + 1];
                    data[in + 1] = temp;
                }
            }
        }
        return data;
    }

    /**
     * 选择排序
     *
     * @param data   待排序数组
     * @param length 数组长度
     * @return 选取一个值，默认第一个值，每次都拿一个和他比较，若小于，则交换
     */
    private static int[] choseSort(int[] data, int length) {
        int out, in, temp;
        for (out = 0; out < length; out++) {
            for (in = out + 1; in < length; in++) {
                if (data[out] > data[in]) {
                    temp = data[in];
                    data[in] = data[out];
                    data[out] = temp;
                }
            }
        }
        return data;
    }

    /**
     * 插入排序，选取一个中间值
     *
     * @param data   数组
     * @param length 数组长度
     * @return 选择一个做为标记
     */
    private static int[] insertSort(int[] data, int length) {
        int out, in, temp;
        for (out = 0; out < length; out++) {
            in = out;
            temp = data[out];
            while (in > 0 && data[in - 1] > temp) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
        return data;

    }

    /**
     * 快速排序
     *
     * @param data  数据源
     * @param left  开始位置
     * @param right 结束位置
     * @return
     */

    private static int partition(int[] data, int left, int right) {

        int temp = data[left];

        while (right > left) {
            //先找右边，依此比较
            while (temp <= data[right] && left < right) {
                right--;
            }
            //当基准数大于arr[right]则交换
            if (left < right) {
                data[left] = data[right];
                left++;
            }

            //在找左边，
            while (temp >= data[left] && left < right) {
                left++;
            }
            //当左边的数大于基准数，则将左边的数放在右边
            if (left < right) {
                data[right] = data[left];
                right--;
            }

        }
        data[left] = temp;
        return left;

    }

    private static void quickSort(int[] data, int left, int right) {
        if (data == null || left >= right || data.length <= 1) {
            return;
        }
        int mid = partition(data, left, right);
        quickSort(data, left, mid);
        quickSort(data, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] data = {3, 1, 5, 4, 8, 7, 2};
        quickSort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));
    }




}
