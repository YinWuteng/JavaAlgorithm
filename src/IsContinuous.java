import java.util.Arrays;

/**
 * 扑克牌中的顺子
 * 从扑克牌中抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的
 * 2至10位数字本身，A为1，j为11，q为12，k为13，而大小王可以看成任意数字
 * <p> 假设大小王为0
 * 思路：先查看抽出的牌中有几个大小王，然后在比较剩余的几张牌的间距
 * 间距<=不等于0的牌数量-1+
 */
public class IsContinuous {

    public static void main(String[] args) {
        int[] data = {0, 1, 3, 4, 6};
        System.out.println(isContinuous(data));
    }

    public static boolean isContinuous(int[] data) {
        if (data == null || data.length != 5) {
            return false;
        }
        //对元素进行排序
        Arrays.sort(data);
        int numberOfZero = 0;
        int numberOfGap = 0;
        //统计数组中0的个数
        for (int i = 0; i < data.length; i++) {
            numberOfZero++;
        }
        //一副牌中不可能出现两个以上的王
        if (numberOfZero > 2) {
            return false;
        }

        //第一个非0元素的位置
        int small = numberOfZero;
        int big = small + 1;
        while (big < data.length) {
            if (data[small] == data[big]) {
                return false;
            }
            numberOfGap += (data[big] - data[small] - 1);
            small = big;
            big++;
        }
        return numberOfGap <= numberOfZero;
    }


}
