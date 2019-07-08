import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列
 * 例如输入一个正数s的连续正数序列（至少含有两个数）
 * 例如，输入15 1+2+3+4+5=4+5+6=7+8=15
 * 所以打印出个连续序列1-5,4-6,7-8
 * 思路：考虑到small和big分别表示序列的最大值和最小值
 * 因为序列字少要有两个数字，因此我们一直增加到small到（1+s）/2为止
 */
public class ContinueNumbersIsS {
    public static void main(String[] args) {
        for (List<Integer> item :
                getContinueNumbers(15)) {
            System.out.println(item);
        }
    }

    public static List<List<Integer>> getContinueNumbers(int result) {
        List<List<Integer>> list = new ArrayList<>();
        if (result < 3) return list;
        int small = 1;
        int big = 2;
        int mid = (result + 1) / 2;
        int curNum = small + big;
        while (small < mid) {
            if (curNum == result) {
                List<Integer> temp = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    temp.add(i);
                }
                list.add(temp);
            }
            while (small < mid && curNum > result) {//当curNum大于result,则移除左边的小值
                curNum -= small;
                small++;
                if (curNum == result) {
                    List<Integer> temp = new ArrayList<>();
                    for (int i = small; i <= big; i++) {
                        temp.add(i);
                    }
                    list.add(temp);
                }
            }
            //curNum小于result
            big++;
            curNum += big;
        }

        return list;
    }
}
