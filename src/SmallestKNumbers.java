import java.util.TreeSet;

/**
 * 最小的k个数,
 * 解法一：排序，查找
 * 解法二：TreeSet特性
 */
public class SmallestKNumbers {

    public static void main(String[] args) {
        int[] data = {3, 4, 5, 1, 2, 8, 4, 9};
        printNum(data, 4);
    }

    public static void printNum(int[] data, int k) {
        //检验合法性
        if (data == null || data.length < 1) return;
        if (data.length > k && k > 0) {
            //利用TreeSet特性
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < data.length; i++) {
                treeSet.add(data[i]);
            }
            for (int i = 0; i < k; i++) {
                //输出treeSet最上面的一位
                System.out.println(treeSet.first());
                //移除最上面的一位
                treeSet.remove(treeSet.first());
            }
        }

    }
}
