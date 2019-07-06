import java.util.Stack;

/**
 * 两个链表的第一个公共节点
 * 理解：公共节点之后，所有的节点都是相同的
 * 解法一：利用栈的思想
 * 解法二:由于后来重合的部分是相同的。根据他们的长度思考
 *        让较长的链表先走一段距离，然后两个链表同时走
 */
public class TwoLinkedListFirstCommonNode {

    public static LinkNode getFirst(LinkNode node1,LinkNode node2){
        if (node1==null || node2==null){
            throw new RuntimeException("Input Error");
        }
        int len1=0;
        while (node1!=null){
            len1++;
            node1=node1.next;
        }

        int len2=0;
        while (node2!=null){
            len2++;
            node2=node2.next;
        }

        int step=len1-len2;
        if (step>=0){//node1先走step步
            while (step>0){
                node1=node1.next;
                step--;
            }
        }else {//node2先走step步
            step=0-step;
            while (step>0){
                node2=node2.next;
                step--;
            }
        }

        while (node1!=null && node2!=null){
           if (node1==node2){
               return node1;
           }
           node1=node1.next;
           node2=node2.next;
        }
        return null;
    }


    public static LinkNode getFirstCommonNode(LinkNode node1,LinkNode node2){
        if (node1==null || node2==null){
            throw new RuntimeException("Input Error");
        }

        Stack<LinkNode> stack1=new Stack<>();
        while (node1!=null){
            stack1.push(node1);
            node1=node1.next;
        }
        Stack<LinkNode> stack2=new Stack<>();
        while (node2!=null){
            stack2.push(node2);
            node2=node2.next;
        }
        LinkNode linkNode=null;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if (stack1.peek()==stack2.peek()){
               linkNode= stack1.peek();
            }else {//在链表中的从后往前最后一次
                break;
            }
            stack1.pop();
            stack2.pop();
        }
        return linkNode;
    }
}
