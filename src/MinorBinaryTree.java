/**
 * 输出二叉树镜像
 */
public class MinorBinaryTree {


    public static void minor(BinaryTreeNode parent){
        if (parent!=null){
            BinaryTreeNode tmp=null;
            tmp=parent.left;
            parent.left=parent.right;
            parent.right=tmp;
            minor(parent.left);
            minor(parent.right);
        }
    }

}
