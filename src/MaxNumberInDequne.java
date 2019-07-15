import java.sql.Array;
import java.util.*;

/**
 * 队列的最大值
 * 输入数组{2,3,4,2,6,2,5,1}
 * 滑动窗口大小是3
 * 那么一共存在6个滑动窗口，最大值分别是{4,4,4,6,6,6,5}
 * 方法一：蛮力法，每次都比较滑动窗口里面的数字
 * 方法二：得到区间内的最大值
 */
public class MaxNumberInDequne {

    public static void main(String[] args) {
        int[] data = {2, 3, 4, 2, 6, 2, 5, 1};
//        getMaxList(data, 3);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            list.add(data[i]);
        }

        maxInWindows(list, 3);
    }

    /**
     * 蛮力法
     *
     * @param data
     * @param k
     */
    public static void getMaxList(int[] data, int k) {
        if (data == null || data.length < 1 || k < 0 || data.length < k) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        int start = 0; //滑动
        int end = start + k - 1; //结束位置
        int max = 0;
        while (end <= data.length - 1) {
            max = max(data, start, end);
            list.add(max);
            start++;
            end++;
        }
        System.out.println(Arrays.toString(list.toArray()));

    }

    public static int max(int[] data, int start, int end) {
        int max = data[start];
        for (int i = start + 1; i <= end; i++) {
            if (data[i] >= max) {
                max = data[i];
            }
        }
        return max;
    }


    private static List<Integer> maxInWindows(List<Integer> data, int size) {
        List<Integer> windowMax = new LinkedList<>();
        //条件检查
        if (data == null || size < 1 || data.size() < 1) {
            return windowMax;
        }

        Deque<Integer> idx = new LinkedList<>();//用于存储最大值得索引
        //窗口还没有被填满时，找最大的索引
        for (int i = 0; i < size && i < data.size(); i++) {
            //如果索引对应的值比之前存储的索引对应的值大或者相等。就删除之前存储的值
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }
            //添加索引
            idx.addLast(i);
        }
        //窗口已经被填满了
        for (int i = size; i < data.size(); i++) {
            //第一个窗口的最大值保存
            windowMax.add(data.get(idx.getFirst()));
            //如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }
            //删除已经滑出窗口的数据对应的下标
            if (!idx.isEmpty() && idx.getFirst() <= (i - size)) {
                idx.removeFirst();
            }
            //可能的最大的下标索引入队
            idx.addLast(i);
        }
        //最后一个窗口的最大值入队
        windowMax.add(data.get(idx.getFirst()));
        return windowMax;
    }
}
