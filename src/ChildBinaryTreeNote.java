/**
 * 数的子结构
 * 输入两颗二叉树A、B，判断B是不是A子结构
 */
public class ChildBinaryTreeNote {
    public static boolean isChild(BinaryTreeNode parent, BinaryTreeNode child) {
        //两个对象相同
        if (parent == child) return true;
        //B的根节点为空，返回true
        if (child == null) return true;

        //B的根节点不为空，A的跟节点为空就返回false
        if (parent==null)return false;
        //记录匹配结果
        boolean result=false;
        if (parent.value==child.value){
            result=match(parent,child);
        }
        if (result)return true;
        return isChild(parent.left,child) || isChild(parent.right,child);
    }
    public static boolean match(BinaryTreeNode root1,BinaryTreeNode root2){
        if (root1==root2)return true;

        if (root2==null)return true;

        if (root1==null)return false;
        //如果两个节点的值相等，则分别判断其左子节点和右子节点
        if (root1.value==root2.value){
            return match(root1.left,root2.left) && match(root1.right,root2.right);
        }
        //节点值不相等
        return false;
    }
}
