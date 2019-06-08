/**
 * 旋转数组中的最小数字
 * 3,4,5,1,2
 * 3,3,3,1,3
 * 二分查找
 *
 */


public class RoateArray {
   public static void main(String[] args){

   }

    /**
     *
     * @param data 带查找数组
     * @return
     */
   public static int getMinNumber(int[] data){
     //判断输入是否合法
       if (data==null || data.length==0){
           throw new RuntimeException("输入不合法");
       }
       int start=0;//开始处理的第一个位置
       int end=data.length-1;//开始处理的最后一个位置

       int mi=start;
       //确保start前一个排好序的部分，hi在后一个排好序的部分
       while (data[start]>=data[end]){
           //当处理范围内只有两个数据时，返回后一个结果
           if (end-start==1)return data[end];
           //取中间位置
           mi=(start+end)/2;
           //如果三个数相等。则需要进行顺序处理

           if (data[start]==data[mi] && data[end]==data[mi])
               return minInorder(data,start,end);
           //如果中间位置对于的值在前一个排好序的部分，则最小的值在右边
           //将start为新的处理位置
           if (data[mi]>data[end])start=mi;
           //如果对应的值在后一个排好序的部分，则最小的值在左边,则最end设置为新的处理位置
           if (data[mi]<data[end])end=mi;
       }
       return data[mi];
   }

    /**
     * 找数组中的最小数
     * @param data 数组
     * @param start 开始位置
     * @param end 结束位置
     * @return
     */
   public static int minInorder(int[] data,int start,int end){
       int result=data[start];
       for (int i=start;i<=end;i++){
           if (result>data[i])
               result=data[i];
       }
       return result;
   }
}
