/**
 * 创建人：yinwuteng
 * 创建时间：2019/2/27
 * 版本号：1.0.1
 * 描述：树的遍历
 * 设计文档：
 */
public class TreeTraversal {
    private static class BinaryTreeNode {
        int mValue;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 先访问根，在左，在右
     */
    private static void beforeTheOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.println(root.mValue);
            beforeTheOrder(root.left);//遍历左边
            beforeTheOrder(root.right); //遍历右边
        }
    }

    public static void main(String[] args) {

    }
}
