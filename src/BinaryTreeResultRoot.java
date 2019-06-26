import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值得路径
 * <p>
 * 输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class BinaryTreeResultRoot {

    public static void printRoot(BinaryTreeNode node, int result) {

        if (node != null) {
            //用于存储二叉树的值
            List<Integer> list = new ArrayList<>();
            printRoot(node, result, 0, list);
        }


    }

    public static void printRoot(BinaryTreeNode node, int result, int curNum, List<Integer> list) {
        if (node != null) {
            curNum += node.value;
            list.add(node.value);
            if (curNum == result) {
                if (node.left == null && node.right == null) {
                    System.out.println(list);
                }
            } else if (curNum < result) {
                //遍历左子树
                printRoot(node.left, result, curNum, list);
                //遍历右子树
                printRoot(node.right, result, curNum, list);
            } else {//移除最后一位
                list.remove(list.size() - 1);
            }

        }
    }
}
