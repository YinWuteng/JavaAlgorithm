/**
 * 对称二叉树
 */
public class SymmetryTree {

    public static boolean symmetryTree(BinaryTreeNode parent){
        if (parent==null)return true;
        if (parent.left.value==parent.right.value){
            return compareTree(parent.left,parent.right);
        }
        return false;
    }

    public static boolean compareTree(BinaryTreeNode node1,BinaryTreeNode node2){
        if (node1==node2)return true;
        if (node1==null || node2==null)return false;
        if (node1.value!=node2.value)return false;
        return compareTree(node1.left,node2.right)&&compareTree(node1.right,node2.left);
    }

}
