import java.util.Arrays;

/**
 * 调整数组奇偶数位置
 * 使奇数在前，偶数在后
 */
public class AdjustmentArray {

    public static void main(String[] args){
        int[] data={2,3,5,6,8,0,1,9,4,7};
        System.out.println(Arrays.toString(adjustArray(data)));
    }
    public static int[] adjustArray(int[] array){
        if (array==null || array.length<=1)return array;
        int left=0;
        int right=array.length-1;
        while (left<right){
            //在左边寻找偶数
            while (left<right && !(array[left]%2==0)){
                left++;
            }

            //从右边寻找奇数
            while (left<right && array[right]%2==0){
                right--;
            }
            //交换奇偶位置
            int tmp=array[left];
            array[left]=array[right];
            array[right]=tmp;
        }
        return array;
    }
}
