/**
 * 数字在排序数组中出现的次数
 * 思路：二分查找
 */
public class NumberShowInDatas {

    public static int showTimes(int[] data, int number) {

        if (data == null || data.length < 1 || data[0] > number || data[data.length - 1] < number) {
            throw new RuntimeException("Input Error");
        }
        return halfCheck(data, 0, data.length - 1, number, 0);
    }

    /**
     * @param data   数组
     * @param start  开始位置
     * @param end    结束位置
     * @param number 目标数字
     * @param times  出现次数
     * @return
     */
    public static int halfCheck(int[] data, int start, int end, int number, int times) {

        //直接查找中位数
        int mid = (start + end) / 2;
        if (data[mid] == number) {//如果中位数等于目标数字，则分别向左边和右边查找
            int left = mid;
            while (left >= start) {//向左边查找
                if (data[left] == number) {
                    times++;
                }
                left--;
            }
            int right = mid;
            while (right <= end) {//向右边查找
                if (data[right] == number) {
                    times++;
                }
                right++;
            }
        } else if (data[mid] < number) {//中位数比目标数字小。则说明在右边，查找右边
            halfCheck(data, mid + 1, end, number, times);
        } else {//中位数比目标数大，则说明在左边，查找左边
            halfCheck(data, start, mid - 1, number, times);
        }
        return times;
    }


}
