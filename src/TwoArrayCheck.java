/**
 * 创建人：yinwuteng
 * 创建时间：2019/2/27
 * 版本号：1.0.1
 * 描述：二维数组查找
 * 设计文档：
 * 1,2,8,9
 * 2,4,9,12
 * 4,7,10,13
 * 6,8,11,15
 */
public class TwoArrayCheck {
    public static boolean twoArrayCheck(int[][] data, int num) {
        if (data == null || data.length < 1 || data[0].length < 1) return false;
        int rows = data.length - 1; //数组的行数
        int col = data[1].length - 1; //数组的列数
        int  row = 0;
        while (col >= 0 && row <= rows){
            if (data[row][col]==num){
                return true;
            }else if (data[row][col]<num){
                row++;
            }else {
                col--;
            }
        }

            return false;
    }

    public static void main(String[] args) {
        int[][] data = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(twoArrayCheck(data, 9));
    }
}
