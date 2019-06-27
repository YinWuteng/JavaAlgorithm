import java.util.TreeSet;

/**
 * 数据流的中位数
 * 解法一：排序
 * 解法二:TreeSet特性
 */
public class DatasCenterNumber {

    public static void main(String[] args){
        double[] data={1,2,3};
        printNum(data);
    }
    public static void printNum(double[] data) {
        if (data == null || data.length < 1) return;
        TreeSet<Double> treeSet = new TreeSet<>();
        for (int i = 0; i < data.length; i++) {
            treeSet.add(data[i]);
        }
        double result;
        if (data.length % 2 == 0) {//如果数组长度为偶数,则查找中间的前面一位和后面一位
            for (int i = 0; i < (data.length / 2) - 1; i++) {
                treeSet.remove(treeSet.first());
            }
            double tmp = treeSet.first();
            treeSet.remove(treeSet.first());
            result = (tmp + treeSet.first()) / 2;
        } else {//为奇数,
            for (int i = 0; i < data.length / 2; i++) {
                treeSet.remove(treeSet.first());
            }
            result = treeSet.first();
        }
        System.out.println(result);
    }
}
