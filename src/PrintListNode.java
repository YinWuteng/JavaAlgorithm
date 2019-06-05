import java.util.Stack;

/**
 * 创建人：yinwuteng
 * 创建时间：2019/2/27
 * 版本号：1.0.1
 * 描述：从尾到头打印链表
 * 设计文档：
 */
public class PrintListNode {
    public static void main(String[] args){
        ListNode listNode=new ListNode(1);
       listNode.nxt=new ListNode(2);
       listNode.nxt.nxt=new ListNode(3);
       listNode.nxt.nxt.nxt=new ListNode(4);
      // printListInverselyUsingRecursion(listNode);
       printListNodeWithStack(listNode);
    }


    public static class ListNode {
        public ListNode(int val){
            this.val=val;
        }
        int val; //节点的值
        ListNode nxt; //下一个节点
    }


    /**
     * 递归的方式
     * @param root
     */
    private static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion(root.nxt);
            System.out.println(root.val + " ");
        }
    }

    /**
     * 用栈
     * @param root
     */
    private static void  printListNodeWithStack(ListNode root){
        Stack<ListNode> stack=new Stack<>();
        while (root!=null){
            stack.push(root);
            root=root.nxt;
        }

        ListNode listNode;
        //输出打印
        while (!stack.isEmpty()){
            listNode=stack.pop();
            System.out.println(listNode.val+"");
        }

    }
}
