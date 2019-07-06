import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉搜索树的第k大节点
 * 5
 * 3   7
 * 2  4 6  8
 * 第三大的节点是4
 * <p>
 * 思路;由题可知为中序遍历规律
 * 中序遍历 左根右
 */
public class BinaryTreeKLargestNode {

    public static int getKValue(BinaryTreeNode node, int k) {
        if (node == null) {
           return -1;
        }
        //声明链表来存储二叉树中序遍历结果
        ArrayList<BinaryTreeNode> list = new ArrayList<>();
        getValue(node, list);
        int index = 0;
        for (BinaryTreeNode item :
                list) {
            index++;
            if (index == k) {
                return item.value;
            }
        }
        return -1;
    }

    public static void getValue(BinaryTreeNode node, ArrayList<BinaryTreeNode> list) {
        if (node.left != null) {//查找左边
            getValue(node.left, list);
        }
        list.add(node); //添加中间
        if (node.right != null) {
            getValue(node.right, list);
        }

    }
}
