/**
 * 和为s的数字
 * 输入一个递增排序的数组和一个数字，在数组中查找两个数，使得它们的和正好是s
 */
public class TwoNumberResultIsS {

    public static int[] getNumbers(int[] data, int result) {
        int[] arr = new int[2];
        if (data == null || data.length < 2) {
            return arr;
        }
        if (data[0] + data[1] > result || data[data.length - 1] + data[data.length - 2] < result) {
            return arr;
        }
        int start = 0;
        int end = data.length - 1;
        while (start < end) {
            if (data[start] + data[end] == result) {
                arr[0] = data[start];
                arr[1] = data[end];
                break;
            } else if (data[start] + data[end] > result) {
                end--;
            } else {
                start++;
            }
        }
        return arr;
    }
}
