import java.util.LinkedList;
import java.util.List;

/**
 * 约瑟夫环
 * 0...n-1这n个数字排成圆圈， 从数字0开始，每次从这个圆圈里删除第m个数字
 * 方法一：用环形链表
 * 方法二：用循环
 */
public class Josephuse {

    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //要删除元素的位置
        int idx = 0;
        while (list.size() > 1) {
            for (int i = 0; i < m; i++) {
                idx = (idx + 1) % list.size();
            }
            list.remove(idx);
        }
        return list.get(0);
    }

}
