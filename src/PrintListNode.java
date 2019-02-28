/**
 * 创建人：yinwuteng
 * 创建时间：2019/2/27
 * 版本号：1.0.1
 * 描述：从尾到头打印链表
 * 设计文档：
 */
public class PrintListNode {
    public static class ListNode {
        int val; //节点的值
        ListNode nxt; //下一个节点
    }

    public static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion(root.nxt);
            System.out.println(root.val + " ");
        }
    }
}
