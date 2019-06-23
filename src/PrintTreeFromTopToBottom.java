import java.util.LinkedList;

/**
 * 从上到下打印二叉树
 * 利用链表特性,将根节点放置到链表中
 */
public class PrintTreeFromTopToBottom {

    public void printTreeNode(BinaryTreeNode parent){
        LinkedList<BinaryTreeNode> list=new LinkedList<>();
        if (parent==null){
            throw new RuntimeException("二叉树输入错误");
        }
        list.add(parent);
        BinaryTreeNode curNode; //用于记录处理的节点
        while (!list.isEmpty()){
            curNode=list.remove();
            System.out.println(curNode.value);
            if (curNode.left!=null){
                list.add(curNode.left);
            }

            if (curNode.right!=null){
                list.add(curNode.right);
            }
        }
    }

}
