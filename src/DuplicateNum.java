/**
 * 创建人：yinwuteng
 * 创建时间：2019/2/27
 * 版本号：1.0.1
 * 描述：获取重复数字
 * 设计文档：
 */
public class DuplicateNum {
    public static int getDuplicateNum(int[] data) {
        if (data==null||data.length <= 1) return -1;
        for (int i = 0; i < data.length; i++) {
            //如果i和数组对应的值不相等
            if (i != data[i]) {
                //查找该数字的对应下标,若相等，则输出
                if (data[i] == data[data[i]]) {
                    return data[i];
                } else {//若不相等，则交换
                    int temp = data[data[i]];
                    data[data[i]] = data[i];
                    data[i] = temp;
                }
            }
        }
        return -2;
    }

    public static void main(String[] args){
        int[] data={2,3,1,0,2,5,3};
        System.out.println(getDuplicateNum(data));
    }
}
