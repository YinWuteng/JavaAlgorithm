/**
 * 二分查找
 * 有序数组,一般情况升序数组
 */
public class BinaryCheck {
    public static void main(String[] args) {

        int[] data={1,2,3,4,5,6};
        System.out.println(binaryCheck(data,0,data.length-1,3));
    }

    public static boolean binaryCheck(int[] data,int start,int end ,int num) {
        //判断数组合法性
        if (data == null || data.length < 1) return false;
        if (start<=end){

            int mid=(start+end)/2;
            if (data[mid]==num){
                return true;
            }else if (data[mid]<num){//在右边
                return binaryCheck(data,mid+1,end,num);
            }else {//在左边
                return binaryCheck(data,start,mid-1,num);
            }

        }else{
            return false;
        }
    }
}
