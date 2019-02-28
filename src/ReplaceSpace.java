/**
 * 创建人：yinwuteng
 * 创建时间：2019/2/27
 * 版本号：1.0.1
 * 描述：替换空格
 * 设计文档：
 */
public class ReplaceSpace {

    public static String replaceSpace(String result) {
        if (result == null) return result;
        int spaceCount = 0;
        char[] results = result.toCharArray();

        //先计算出空格数量
        for (int i = 0; i < results.length; i++) {
            if (' ' == results[i]) {
                spaceCount++;
            }
        }
        //初始化输出字符串长度
        char[] outResult = new char[result.length() + spaceCount * 2];
        int outResultPos = result.length() + spaceCount * 2 - 1;
        for (int i = results.length - 1; i >= 0; i--) {
            if (results[i] == ' ') {
                outResult[outResultPos] = '0';
                outResult[outResultPos - 1] = '2';
                outResult[outResultPos - 2] = '%';
                outResultPos -= 3;
            } else {
                outResult[outResultPos] = results[i];
                outResultPos--;
            }
        }
        return String.valueOf(outResult);
    }

    public static void main(String[] args) {
        String result = "hh are happy!";
        System.out.println(replaceSpace(result));
    }
}
