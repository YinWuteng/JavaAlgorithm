import java.util.Arrays;

/**
 * 字符串的排列
 * 输入字符串abc
 * 打印出所有排列abd,acb,bac,bca,cab,cba
 */
public class CharsSort {

    public static void printCharsSort(char[] chars) {

        if (chars.length > 0) {
            print(chars, 0, chars.length - 1);
        }
    }

    /**
     * @param chars 字符数组
     * @param start 开始位置
     * @param end   结束位置
     */
    public static void print(char[] chars, int start, int end) {
        if (start == end) {
            //已经排完
            System.out.println(Arrays.toString(chars));
        } else {
            char tmp;
            //对当前还未处理的字符串进行处理，每个字符都可以作为当前处理位置的元素
            for (int i = start; i < end; i++) {
                tmp=chars[start];
                chars[start]=chars[i];
                chars[i]=tmp;
                //处理下一个位置
                print(chars,i,end);
            }
        }
    }
}
