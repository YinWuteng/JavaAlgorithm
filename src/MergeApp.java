import java.util.Arrays;

/**
 * 创建人：yinwuteng
 * 创建时间：2019/2/28
 * 版本号：1.0.1
 * 描述：归并排序
 * 设计文档：
 */
public class MergeApp {

    public static int[] merge(int[] arrayA, int arrayALength, int[] arrayB, int arrayBLength, int[] arrayC) {

        int a = 0, b = 0, c = 0;

        while (a < arrayALength && b < arrayBLength) { //数组A和数组B均遍历完
            if (arrayA[a] < arrayB[b]) {
                arrayC[c++] = arrayA[a++];
            } else {
                arrayC[c++] = arrayB[b++];
            }
        }
        while (a < arrayALength) {
            arrayC[c++] = arrayA[a++];
        }
        while (b < arrayBLength) {
            arrayC[c++] = arrayB[b++];
        }


        return arrayC;
    }

    public static void main(String[] args) {
        int[] arrayA = {23, 47, 81, 95};
        int[] arrayB = {7, 14, 39, 55, 62, 74};
        int[] arrayC = new int[10];
        merge(arrayA, 4, arrayB, 6, arrayC);
        System.out.println(Arrays.toString(arrayC));
    }
}
