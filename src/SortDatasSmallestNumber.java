/**
 * 把数组排成最小的数
 * 注意点，数组越界 int
 * 快速排序思想，将最小的排在最前面
 * 打印时使用StringBuilder
 */
public class SortDatasSmallestNumber {
    public static void main(String[] args) {
        char[] data = {'1', '6', '3', '4'};
        sort(data);
        printNum(data);
    }

    public static void sort(char[] datas) {

        if (datas == null || datas.length < 1) {
            throw new RuntimeException("输入有误");
        }
        sortArray(datas, 0, datas.length - 1);
    }


    public static void sortArray(char[] datas, int start, int end) {
        char provit = datas[start];
        int left = start;
        int right = end;
        if (left < right) {//标记值比右边的值大
            while (left < right && compareString(provit, datas[right]) < 0) {
                right--;
            }
            //将右边发现的小的值放在最左边
            datas[left] = datas[right];
            while (left < right && compareString(provit, datas[left]) > 0) {//在左边找比标记值大的
                left++;
            }
            datas[right] = datas[left];
            datas[left] = provit;
            sortArray(datas, start, left - 1);
            sortArray(datas, left + 1, end);
        }

    }

    public static int compareString(char s1, char s2) {
        String str1 = s1 + String.valueOf(s2);
        String str2 = s2 + String.valueOf(s1);
        return str1.compareTo(str2);
    }

    public static void printNum(char[] datas) {
        StringBuffer buffer = new StringBuffer();
        for (char data : datas
        ) {
            buffer.append(data);
        }
        System.out.println(buffer.toString());
    }
}
