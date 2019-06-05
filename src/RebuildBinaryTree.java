/**
 * 重建二叉树，输出头节点
 * 前序遍历序列{1,2,4,7,3,5,6,8}
 * 中序遍历序列{4,7,2,1,5,3,8,6}
 */
public class RebuildBinaryTree {
    private class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }


    /**
     * @param qData 前序数组
     * @param zData 中序数组
     * @return
     */
    private BinaryTreeNode construct(int[] qData, int[] zData) {
        if (qData == null || qData.length < 1 || qData.length != zData.length) return null;
        return construct(qData, 0, qData.length - 1, zData, 0, zData.length - 1);
    }

    /**
     * @param qData 前序数组
     * @param qs    前序开始位置
     * @param qe    前序结束位置
     * @param zData 中序数组
     * @param zs    中序开始
     * @param ze    中序结束
     */
    private BinaryTreeNode construct(int[] qData, int qs, int qe, int[] zData, int zs, int ze) {

        //从前序的结果可以得到跟节点值
        int root = qData[qs];
        //通过跟节点在中序数组的位置，可以得到左右子树
        int index=0;
        while (index<=ze && zData[index]!=root){
            index++;
        }
        if (index>ze){throw new RuntimeException("输入不合法");}
        //创建当前的根节点
        BinaryTreeNode node=new BinaryTreeNode();
        node.value=root;
        //递归构建当前根节点的左子树，左子树元素个数为index-is+1个
        //左子树对应的前序遍历的位置在[qs-1,qs+index-zs]
        //左子树对应的中序遍历的位置在[zs,index-1]
        node.left=construct(qData,qs-1,qs+index-zs,zData,zs,index-1);
        //递归构建当前根节点的右子树,右子树的元素个数为ze-index
        //右子树对应的前序遍历位置在[qs+index-ze+1，qe]
        //右子树对应的中序遍历位置在[index+1,ze]
        node.right=construct(qData,qs+index-zs+1,qe,zData,index+1,ze);
        return node;
    }

}
