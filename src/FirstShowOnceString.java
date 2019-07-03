/**
 * 第一次只出现一次的字符
 * 声明辅助空间替换时间复杂度
 */
public class FirstShowOnceString {


    public static String firstShow(String str) {
        if (str == null || str.length() < 1) return "";
        //初始化一个数组用于记录每个字符出现的次数
        int[] pos = new int[26];
        //初始化一个字符串用于之后取出字符
        String result = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < str.length(); i++) {
            //用于计算出i所在字符到a字符的距离
            int index = str.charAt(i) - 'a';
            //出现一次，当前位置数量加1
            pos[index]++;
        }
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] == 1) {
                return String.valueOf(result.toCharArray()[i]);
            }
        }
        return " ";
    }
}
