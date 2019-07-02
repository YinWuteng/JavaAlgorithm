/**
 * 最长不包含重复字符的子字符串
 * arabcacfr
 * 出现的位置的间距大于当前的最大长度，则f(n)=f(n-1)+1
 * 出现的位置的间距小于当前的最大长度 则需要从出现的位置开始算
 */
public class LargestNotContainSubString {



    public static int notContainSubString(String str) {
        if (str == null || str.length() < 1) return 0;
        //初始化一个数字用来保存每个字母在数组中出现的位置
        int[] pos = new int[26];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = -1;
        }


        int preLength = 0; //f(n-1)
        int curLength = 0; //f(n)
        int maxLength = 0;
        for (int i = 0; i < str.length(); i++) {
            int letterNumber = str.charAt(i) - 'a';//用于记录当前字母

            // 小于0代表没有出现过 或 当前出现的距离大于最大值
            if (pos[letterNumber] < 0 && i - pos[letterNumber] > preLength) {
                curLength = preLength + 1;
            } else {//出现的距离小于长度的最大值
                curLength = i - pos[letterNumber];
            }
            //存储字母出现的位置
            pos[letterNumber] = i;
            if (curLength > maxLength)
                maxLength = curLength;
            preLength = curLength;
        }
        return maxLength;
    }
}
