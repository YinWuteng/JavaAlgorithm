/**
 * 数组中，出现次数超过一半的数字
 * 常规思路，排序，则数组中间的那个肯定是出现次数超过一半的数字
 * 数组合法性：是否有出现次数超过一半的数字
 */
public class NumberAppearHalfTimes {
    /**
     * 解法二，记录法
     */

    public static void printNum(int[] data) {
        if (data == null || data.length < 1) return;
        int times = 1; //用于记录数字出现次数
        int result = data[0]; //开始数字

        //从第二位开始
        for (int i = 1; i < data.length; i++) {
           //如果记数为0,则更换记录值
            if (times==0){
                result=data[i];
                times=1;
            }else if (result==data[i]){
                //记录的值与统计值相等
                times++;
            }else {//如果不相同就相互抵消
                times--;
            }
        }


        //查询数组是否合格
        times=0;
        for (int i=0;i<data.length;i++){
            if (result==data[i]){
                times++;
            }
        }
        if (times>data.length/2){
               System.out.println(result);
        }else {
            System.out.println("输入数组不合规范");
        }

    }
}
