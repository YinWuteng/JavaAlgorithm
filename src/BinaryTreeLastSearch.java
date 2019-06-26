/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。
 * 输入数组{5,7,6,9,11,10,8}则返回true
 * 解题思路:后序遍历，则最后一位为根节点，从头开始找，直到找到大于根节点的数字，则前面的为左子树(均小于根节点)，
 * 后面的为右子树(均大于根节点)
 */
public class BinaryTreeLastSearch {

    public static boolean isAfterTrasver(int[] data){
        if (data==null || data.length==0)return false;
        return isAfterTrasver(data,0,data.length-1);
    }

    public static boolean isAfterTrasver(int[] data,int start,int end){

        //如果处理的数据只有一个或者没有数据要处理
        if (start>=end){
            return true;
        }
        //记录开始位置
       int index=start;
       //寻找大于根节点的位置，end-1，最后一位不需要处理
        while (index<end-1 && data[index]<data[end]){
            index++;
        }

        //记录右边开始的值
        int right=index;

        //在右边寻找，知道找到根节点
        while (index<end-1 && data[index]>data[end]){
            index++;
        }

        //若最后找到的index值等于end，说明符合
        if (index!=end-1){
            return false;
        }
        //继续查找左边和右边
        return isAfterTrasver(data,start,right-1) && isAfterTrasver(data,right,end-1);
    }
}
