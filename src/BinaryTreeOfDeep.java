/**
 * 二叉树的深度
 * 1
 * 2     3
 * 4   5      6
 * 7
 * 深度为3
 * <p>
 * 思路：递归，每次递增加1
 */
public class BinaryTreeOfDeep {


    public static int getBinaryTreeOfDeep(BinaryTreeNode node) {
        if (node == null) return 0;
        return getDeep(node, 0);
    }

    public static int getDeep(BinaryTreeNode node, int deep) {
        if (node == null) return deep;
        int left = getDeep(node.left, deep);
        int right = getDeep(node.right, deep);
        return left > right ? (left + 1) : (right + 1);
    }
}
